package com.afrigis.services.internal.saas.api2;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afrigis.services.KeyValue;
import com.afrigis.services.LibMode;
import com.afrigis.services.Request;
import com.afrigis.services.Response;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.ext.AsyncCapable;
import com.afrigis.services.ext.ConfigurationAware;
import com.afrigis.services.ext.SaasTimeAware;
import com.afrigis.services.impl.GenericRequest;
import com.afrigis.services.internal.saas.ServicesProxy;
import com.afrigis.services.internal.saas.api2.impl.ParsedErrorData;
import com.afrigis.services.util.Version;
import org.apache.http.HttpHost;

/**
 * <p>
 * Represents the main interaction point with AGSaaS.
 * </p>
 * <p>
 * See {@link com.afrigis.services.internal.saas.api2 package} docs for code
 * samples.
 * </p>
 * <p>
 * See http://docs.afrigis.co.za/wiki/index.php/Products/SaaS/Overview#SaaS_v2
 * </p>
 *
 * @author inarievs
 * @author hendrikc
 * @see Response
 *
 *
 *
 */
public class SaasClient implements ServicesProxy, AsyncCapable,
        ConfigurationAware, SaasTimeAware {

    private static final int TEA_POT = 418;
    private static final double ONE_SEC_MILLIS_AS_DOUBLE = 1000.0;
    private static final int MAX_CONNECTIONS_PER_ROUTE = 4;
    private static final int MAX_TOTAL_CONNECTIONS = 8;
    private static final String X_SERVER_TIME = "X-ServerTime";
    private static final String LIBVER = "libver";
    private static final String LIBPLAT = "libplat";
    private static final String LIBMODE = "libmode";
    private static final String JAVA = "java";
    private static final String X_LIBVER = "X-libver";
    private static final String X_LIBPLAT = "X-libplat";
    private static final String X_LIBMODE = "X-libmode";
    private static final int ONE_SECOND = 1000;
    /**
     * Default service end point:
     * <code>https://saas.afrigis.co.za/rest/2/</code>.
     */
    public static final String DEFAULT_GW_URL_ROOT
            = "https://saas.afrigis.co.za/rest/2/";
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    private static final Charset UTF8 = Charset.forName("UTF-8");

    private String realGwBaseUrl = DEFAULT_GW_URL_ROOT;

    private final Boolean useSaasTime = true;
    private long timeOffset;

    private byte[] sharedKey;
    private String saasClient;

    private String lastRequestedUrl;

    private Boolean isTrial = Boolean.TRUE;

    private ExecutorService executorService;
    private long timeout;
    private final CloseableHttpClient httpClient;
    private HttpHost proxy;

    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * Creates an instance of the proxy, overriding the default URL.
     *
     * @param realGwUrl Base URL to be used
     */
    public SaasClient(String realGwUrl) {
        super();
        this.realGwBaseUrl = realGwUrl;

        httpClient = initHttpClient();
    }

    private CloseableHttpClient initHttpClient() {
        /*
         * See
         * https://hc.apache.org/httpcomponents-client-ga/tutorial/html/connmgmt
         * .html
         */
        final PoolingHttpClientConnectionManager cm
                = new PoolingHttpClientConnectionManager();

        // Bit redundant, since we will only ever call ONE host
        cm.setMaxTotal(MAX_TOTAL_CONNECTIONS);

        cm.setDefaultMaxPerRoute(MAX_CONNECTIONS_PER_ROUTE);
        
        if(proxy != null)
        return HttpClients.custom().setConnectionManager(cm).setProxy(proxy).build();
        return HttpClients.custom().setConnectionManager(cm).build();

    }

    /**
     * <p>
     * Creates an instance of the proxy, using the default base URL:
     * {@link #DEFAULT_GW_URL_ROOT} .
     * </p>
     */
    public SaasClient() {
        super();
        realGwBaseUrl = DEFAULT_GW_URL_ROOT;
        httpClient = initHttpClient();
    }

    public SaasClient(HttpHost proxy) {
        super();
        realGwBaseUrl = DEFAULT_GW_URL_ROOT;
        this.proxy = proxy;
        httpClient = initHttpClient();
    }

    /**
     * <p>
     * Constructor.
     * </p>
     *
     * @param key the client id
     * @param secret the secret
     */
    public SaasClient(String key, byte[] secret) {
        super();
        this.sharedKey = Arrays.copyOf(secret, secret.length);
        this.saasClient = key;
        httpClient = initHttpClient();
    }

    /**
     * <p>
     * Constructor.
     * </p>
     *
     * @param overRideUrl the service end point
     * @param clientId the client id
     * @param secret the secret
     */
    public SaasClient(String overRideUrl, String clientId, byte[] secret) {
        this(clientId, secret);
        this.realGwBaseUrl = overRideUrl;
    }

    /**
     *
     * @return Whether SaaSTime will be used
     */
    public boolean getUseSaasTime() {
        return useSaasTime;
    }

    /**
     *
     * @return The base URL being used
     */
    public String getRealGwBaseUrl() {
        return realGwBaseUrl;
    }

    /**
     *
     * @param message the message tha needs to be signed
     * @return URL safe Base64 encoded HMAC value
     * @see Base64#encodeBase64URLSafeString(byte[])
     * @see SecretKeySpec
     * @see Mac
     */
    protected String getHmac(String message) {
        String hmac;
        try {

            getLog().trace("Generating HMAC over string '{}'", message);
            final SecretKey signingKey = new SecretKeySpec(
                    sharedKey == null || sharedKey.length <= 0
                            ? saasClient.getBytes(UTF8) : sharedKey,
                    HMAC_SHA1_ALGORITHM);

            final Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(signingKey);

            final byte[] rawHmac = mac.doFinal(message.getBytes("ASCII"));
            // hmac = Base64.encodeBase64String(rawHmac);
            hmac = new String(Base64.encodeBase64(rawHmac), "UTF-8");

        } catch (Exception e) {
            getLog().error("Failed to generate HMAC!", e);
            hmac = "ERROR";
        }

        return hmac;
    }

    private Logger getLog() {
        return LoggerFactory.getLogger(getClass());

    }

    /**
     *
     * @return The client's secret key
     */
    public byte[] getSharedKey() {
        return sharedKey.clone();
    }

    /**
     *
     * @param secret The client's secret key
     */
    public void setSharedKey(byte[] secret) {
        this.sharedKey = secret != null ? secret.clone() : null;
        isTrial = !(secret != null && secret.length > 0);
    }

    /**
     *
     * @return The client user name
     */
    public String getSaasClient() {
        return saasClient;
    }

    /**
     *
     * @param clientId The client user name
     */
    public void setSaasClient(String clientId) {
        this.saasClient = clientId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.afrigis.services.internal.saas.api2.ServicesProxy#execute(com.afrigis
     * .services.internal.saas.api2.Response)
     */
    @Override
    public void execute(Request requestImpl, Response responseImpl) {
        final LibMode mode = requestImpl.getLibMode();
        execute(requestImpl, responseImpl, mode != null ? mode : LibMode.sync);

    }

    private long generateCurrentUtcTime() {
        final long saasTime = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
                .getTimeInMillis() / ONE_SECOND;
        return saasTime;
    }

    /**
     * <p>
     * Async wrapper for {@link #execute(Request, Response)}.
     * </p>
     *
     * @param <R> the implementing type of {@link Response}
     * @param req the request parameters
     * @param consumer the consumer object
     * @param completeBuild true if we should call
     * {@link Response#completeBuild()} internally
     * @return a {@link Future} promise that wraps the {@link Response} object
     */
    public <R extends Response> Future<R> executeAsync(final Request req,
            final R consumer, final boolean completeBuild) {
        final SaasClient me = this;
        return getExecutorService().submit(new Callable<R>() {

            @Override
            public R call() throws Exception {
                me.execute(req, consumer, LibMode.async);
                if (completeBuild) {
                    consumer.completeBuild();
                }

                return consumer;

            }
        });
    }

    /**
     * <p>
     * Synchronously executes the request.
     * </p>
     * <p>
     * This method executes synchronously, BUT it maybe wrapped in async code.
     * </p>
     *
     * @param <R> the specific type of the {@link Response}
     * @param requestImpl the request parameters
     * @param responseImpl the response object that will parse the response
     * @param libMode the mode the call is being made in
     *
     * @see #executeAsync(Request, Class, boolean)
     * @see #executeAsync(Request, Response, boolean)
     */
    // CHECKSTYLE:OFF: CyclomaticComplexity
    // CHECKSTYLE:OFF: JavaNCSS
    protected <R extends Response> void execute(Request requestImpl,
            R responseImpl, LibMode libMode) {
        try {
            requestImpl.validate();
        } catch (AfriGISServicesException e1) {
            final ParsedErrorData ped = new ParsedErrorData();
            ped.setCause(e1);
            ped.setMessage(e1.getErrorMessage());
            ped.setSource("AfriGIS Services Library");
            ped.setStatusCode(0);
            responseImpl.setError(ped);
            responseImpl.setTimesCalled(0);
            return;
        }
        if (responseImpl == null) {
            throw new InvalidParameterException(
                    "Response parameter can not be null");
        }
        responseImpl.setError(null);
        responseImpl.setTimesCalled(responseImpl.getTimesCalled() + 1);

        long ourTime = generateCurrentUtcTime();

        ourTime += timeOffset;

        String saasQuery = "";

        final Collection<KeyValue> theParms
                = requestImpl.getRequestParameters();

        addLibIdInfoToQuery(theParms, libMode);
        saasQuery = requestImpl.toQueryString();

        final String url
                = completeUrl(requestImpl.getServiceName(), saasQuery, ourTime);

        getLog().trace("Final URL: '{}'", url);

        // See http://www.baeldung.com/httpclient4,and
        // https://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/client/config/RequestConfig.html
        final RequestConfig reqConf = RequestConfig.custom()
                .setConnectionRequestTimeout((int) (timeout))
                .setConnectTimeout((int) (timeout))
                .setSocketTimeout((int) timeout).build();

        final HttpGet getter = new HttpGet(url);
        getter.setConfig(reqConf);

        addHeaderItems(getter);
        InputStream fin = null;
        try {
            getLog().debug("Making HTTP request...");
            final long start = System.currentTimeMillis();
            @SuppressWarnings("resource")
            final HttpResponse response = httpClient.execute(getter);
            final long responseReceivedDiff
                    = System.currentTimeMillis() - start;
            getLog().debug("Received response after {} millis ({} seconds)",
                    responseReceivedDiff,
                    responseReceivedDiff / ONE_SEC_MILLIS_AS_DOUBLE);

            final StatusLine stat = response.getStatusLine();
            final HttpEntity entity = response.getEntity();
            fin = entity.getContent();

            responseImpl.consume(fin, stat.getStatusCode());

            if (getUseSaasTime()) {
                long serverTime = 0;

                for (Header head : response.getHeaders(X_SERVER_TIME)) {
                    if (head.getName().equalsIgnoreCase(X_SERVER_TIME)) {
                        serverTime = Long.parseLong(head.getValue());
                        break;
                    }
                }

                if (serverTime != 0) {
                    getLog().warn(
                            "Time difference found between server and system, adjusting for future calls");
                    if (ourTime > serverTime) {
                        timeOffset = serverTime - ourTime;
                    } else {
                        timeOffset = ourTime - serverTime;
                    }
                    getLog().debug("time difference {}", timeOffset);
                }
            }

            try {
                if (responseImpl.getError() != null
                        && responseImpl.getTimesCalled() < 2) {
                    final ParsedErrorData error = responseImpl.getError();
                    if (error.getStatusCode() == TEA_POT) {
                        getLog().debug(
                                "Adjusted for time difference, calling again.");
                        execute(requestImpl, responseImpl);
                    }
                }
            } catch (NullPointerException e) {
                getLog().debug(
                        "No error exists (error is null), continuing on. But this may mean that something is wrong...");
            }
            responseImpl.setTimesCalled(responseImpl.getTimesCalled() - 1);

            if (stat.getStatusCode() != HttpStatus.SC_OK) {

                getLog().warn(
                        "Non-OK status code received ({}). The url utilized was: '{}'",
                        stat.getStatusCode(), url);

                throw new AfriGISServicesException(
                        "Received unexpected status code from Server : "
                        + stat.getStatusCode());

            }

        } catch (Exception e) {
            getLog().error(
                    "SAAS CALL TO '{}' RAISED AN UNEXPECTED EXCEPTION",
                    url, e);

        } finally {
            IOUtils.closeQuietly(fin);

        }

    }
    // CHECKSTYLE:ON: JavaNCSS
    // CHECKSTYLE:ON: CyclomaticComplexity

    /**
     * Adds some header info, like library version etc. This information is
     * currently primarily added to the GET URL, which is UNBELIEVABLY annoying
     * to me personally, so I am ALSO adding it to the HTTP headers, where they
     * SHOULD be, in the hope we can utilize this in future.
     *
     * @param getter the HttpGet to be executed for a result
     */
    private void addHeaderItems(HttpGet getter) {
        getter.addHeader(X_LIBMODE, "sync");
        getter.addHeader(X_LIBPLAT, JAVA);
        getter.addHeader(X_LIBVER, Version.getVersion());
        getter.addHeader(new String(
                Base64.decodeBase64("WC1DbGFja3MtT3ZlcmhlYWQ="),
                Charset.forName("UTF-8")),
                new String(
                        Base64.decodeBase64("R05VIFRlcnJ5IFByYXRjaGV0dA=="),
                        Charset.forName("UTF-8")));
    }

    /**
     * <p>
     * Appends some library meta data to the request.
     * </p>
     *
     * @param params the current set of parameters
     * @param libMode the mode of the library
     * @see LibMode
     */
    protected void addLibIdInfoToQuery(Collection<KeyValue> params,
            LibMode libMode) {
        params.add(new KeyValue(LIBMODE, libMode.toString()));
        params.add(new KeyValue(LIBPLAT, JAVA));
        params.add(new KeyValue(LIBVER, Version.getVersion()));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.afrigis.services.internal.saas.api2.ServicesProxy#completeUrl(java.
     * lang.String)
     */
    @Override
    public String completeUrl(String saasService, String saasQuery,
            long nonce) {
        String url = getRealGwBaseUrl();

        final String saasAuth = buildHmac(saasService, saasQuery, nonce);
        if (!url.endsWith("/")) {
            url = url + "/";
        }

        final StringBuilder strBuilder = new StringBuilder(url);

        // https://saas.afrigis.co.za/rest/2/saasService/saasClient/saasAuth/saasTime/?saasQuery
        strBuilder.append(saasService).append('/').append(saasClient);
        if (!isTrial) {
            strBuilder.append('/').append(saasAuth).append('/');
        }

        if (useSaasTime) {

            strBuilder.append(nonce).append('/');
        }

        strBuilder.append("?").append(saasQuery);

        url = strBuilder.toString();

        lastRequestedUrl = url;
        return url;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.afrigis.services.internal.saas.api2.ServicesProxy#buildHmac(java.lang
     * .String)
     */
    @Override
    public String buildHmac(String serviceName, String saasQuery, long nonce) {
        String saasMessage = saasQuery + "/" + serviceName + "/" + saasClient;
        if (getUseSaasTime()) {
            saasMessage += "/" + nonce;
        }

        String saasAuth = getHmac(saasMessage);
        saasAuth = fixHmac(saasAuth);
        return saasAuth;
    }

    /**
     * Fixes up the HMAC String by replacing / and + with _ and - respectively.
     * Also removes pointless padding =
     *
     * @param base64Hmac The HMAC String to fix up
     * @return Fixed HMAC
     */
    private String fixHmac(String base64Hmac) {
        String hmac2 = base64Hmac;

        hmac2 = hmac2.replace("/", "_");
        hmac2 = hmac2.replace("+", "-");
        hmac2 = hmac2.replace("=", "");

        getLog().trace("HMAC is {}", hmac2);

        return hmac2;
    }

    /**
     *
     * @return the last, FULL url used by this client.
     */
    public String getLastRequestedUrl() {
        return lastRequestedUrl;
    }

    @Override
    public void setExecService(ExecutorService execService) {
        this.executorService = execService;
    }

    /**
     *
     * @return the current {@link ExecutorService}
     */
    protected ExecutorService getExecutorService() {
        return this.executorService;
    }

    @Override
    public void setServer(String server) {

        this.realGwBaseUrl = server;
    }

    @Override
    public String buildUrl(String serviceName, Collection<KeyValue> params) {
        String saasQuery = "";

        addLibIdInfoToQuery(params, LibMode.url);
        saasQuery = GenericRequest.build(serviceName, params).toQueryString();

        final String url
                = completeUrl(serviceName, saasQuery, generateCurrentUtcTime());

        return url;
    }

    @Override
    public <R extends Response> Future<R> executeAsync(Request req,
            Class<?> responseType, boolean completeBuild) {
        try {
            final R rep = (R) responseType.newInstance();
            return executeAsync(req, rep, completeBuild);
        } catch (Exception e) {
            getLog().error("Failed to instantiante instace of type {}",
                    responseType, e);
            return null;
        }
    }

    @Override
    public void setTimeout(long theTimeout) {
        this.timeout = theTimeout;
    }

    @Override
    public void setUseSaasTime(boolean onOff) {
        // Does nothing. You will use saastime
    }

    @Override
    public void setSaasOffsetInSeconds(int secs) {
        this.timeOffset = secs;

    }

    @Override
    public int getSaasOffsetInSeconds() {
        return (int) timeOffset;
    }
}
