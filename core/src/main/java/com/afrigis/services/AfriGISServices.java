package com.afrigis.services;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.codec.binary.StringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.ext.AsyncCapable;
import com.afrigis.services.ext.AuthenticatedService;
import com.afrigis.services.ext.ConfigurationAware;
import com.afrigis.services.ext.SaasTimeAware;
import com.afrigis.services.ext.ServiceFactoryAware;
import com.afrigis.services.impl.AbstractService;
import com.afrigis.services.impl.GenericRequest;

/**
 * <p>
 * Default provider of service implementations.
 * </p>
 * 
 * @author hendrikc
 *
 */
public class AfriGISServices implements ServiceCallFactory {
    private static final int MILLIS_IN_A_SECOND = 1000;

    private static final int DEFAULT_HTTP_TIMEOUT = 30000;

    private static final String DEFAULT_SERVICE_BASE_URL =
            "https://saas.afrigis.co.za/rest/2/";

    private String clientId;
    private byte[] clientSecret;

    private String baseServiceEndpointUrl = DEFAULT_SERVICE_BASE_URL;
    private static final Logger LOG =
            LoggerFactory.getLogger(AfriGISServices.class);

    private Integer saasTimeOffset = null;
    private Boolean useSaasTime = Boolean.TRUE;

    private long timeout = DEFAULT_HTTP_TIMEOUT;

    private static final Map<String, ServiceCallFactory> FACTORY_CACHE =
            new HashMap<>();

    // private static final Map<Class, Service> serviceCache = new HashMap<>();

    /*
     * Not ideal - this should be provided from outside (IoC anybody?)
     */
    private static final ExecutorService EXEC_SERVICE =
            Executors.newCachedThreadPool();

    private static final Service FALL_BACK_SERVICE =
            AbstractService.defaultInstance();

    /**
     * 
     * @param desiredInterface
     *            the interface class of the desired service
     * @return the service instance, if found
     * @deprecated superseded by the SPI implementation.
     */
    protected Service getServiceInternal(final Class<?> desiredInterface) {
        try {
            final Class<?> theImplClass = getDefaultImplClass(desiredInterface);
            final Service service = (Service) theImplClass.newInstance();
            postProcess(service);
            return service;
        } catch (Exception e) {
            LOG.error("Failed to instantiate service of class {}",
                    desiredInterface, e);
        }

        return null;
    }

    /**
     * <p>
     * Examines the received object for certain criteria, and if a match is
     * found, performs additional configuration on the object.
     * </p>
     * <p>
     * This method is only applicable to custom implementors.
     * </p>
     * 
     * @param service
     *            the service instance
     * @see ServiceFactoryAware
     * @see AuthenticatedService
     * @see AsyncCapable
     * @see ConfigurationAware
     * @see SaasTimeAware
     */
    protected void postProcess(final Object service) {
        if (service instanceof ServiceFactoryAware) {
            ((ServiceFactoryAware) service).setServiceFactory(this);
        }

        if (service instanceof AuthenticatedService) {
            ((AuthenticatedService) service).setCredentials(clientId,
                    clientSecret);
        }

        if (service instanceof AsyncCapable) {
            ((AsyncCapable) service).setExecService(EXEC_SERVICE);
        } else {
            log().warn("Service is not AsyncCapable, Async methods will fail!");
        }

        if (service instanceof ConfigurationAware) {
            ((ConfigurationAware) service).setServer(baseServiceEndpointUrl);
            ((ConfigurationAware) service).setTimeout(timeout);

        }

        if (service instanceof SaasTimeAware) {
            ((SaasTimeAware) service).setUseSaasTime(useSaasTime);
            if (getServerTimeOffset() != null) {
                ((SaasTimeAware) service)
                        .setSaasOffsetInSeconds(getServerTimeOffset());
            }
        }
    }

    private Logger log() {
        return LoggerFactory.getLogger(getClass());
    }

    /**
     * <p>
     * Allows caller to completely specify the service end point.
     * </p>
     * <p>
     * CAUTION: we assume you know what you are doing if you take control of the
     * end point URL.
     * </p>
     */
    @Override
    public void setServiceEndpoint(String server) {
        this.baseServiceEndpointUrl = server;

    }

    /**
     * <p>
     * Attempts to load default implementation class.
     * </p>
     * 
     * @deprecated replaced by use of SPI mechanisms
     * @param serviceClass2
     *            interface class that we want an implementation for
     * @return the load default implementation of provided interface class
     * @throws ClassNotFoundException
     *             when we can't find the default implementation class
     */
    private Class<?> getDefaultImplClass(final Class<?> serviceClass2)
            throws ClassNotFoundException {
        final StringBuffer className = new StringBuffer();

        className.append(serviceClass2.getPackage().getName())
                .append(".impl.Default").append(serviceClass2.getSimpleName());
        final Class<?> realClass = Class.forName(className.toString());
        return (Class<?>) realClass;
    }

    /**
     * <p>
     * Underlying HTTP client implementation dependent.
     * </p>
     * <p>
     * IF the internal HTTP client implementation supports a timeout setting,
     * then we will use it.
     * </p>
     * 
     * @param timeoutInSec
     *            timeout in seconds to apply to HTTPS calls.
     */
    public void setTimeout(int timeoutInSec) {
        this.timeout = Math.abs(timeoutInSec * MILLIS_IN_A_SECOND);

    }

    /**
     * 
     * @param key
     *            the key obtained from AfriGIS
     * @param serviceSecret
     *            the secret obtained from AfriGIS
     */
    protected AfriGISServices(String key, String serviceSecret) {
        this.clientId = key;

        this.clientSecret = StringUtils.getBytesUtf8(serviceSecret);

    }

    @Override
    public Future<Integer> getCreditBalanceAsync() {
        log().trace("In getCreditBalanceAsync");
        return EXEC_SERVICE.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                log().trace("Making creditBalance call from async");
                return Integer.valueOf(getCreditBalance(LibMode.async));
            }
        });
    }

    /**
     * 
     * @param libMode
     *            the mode we are supposed to be executing in
     * @return the credit balance for the account
     */
    protected int getCreditBalance(LibMode libMode) {
        log().trace("In getCreditBalance");

        int balance = -1;

        final Request request = (Request) GenericRequest
                .build(AfriGISService.getCredits.toString());
        request.setLibMode(libMode);
        final String response = getString(request);

        try {

            final JSONObject obj = new JSONObject(response);
            final JSONObject result = obj.getJSONObject("result");
            balance = result.getInt("creditBalance");
        } catch (Exception e) {
            LOG.trace("Server responded with\n {}", response);
            throw new AfriGISServicesException(
                    "Unexpected response received from server (full output logged at trace level)",
                    e);
        }

        return balance;
    }

    @Override
    public int getCreditBalance() {
        return getCreditBalance(LibMode.sync);
    }

    /**
     * <p>
     * The current offset to be applied to local time (based on server time).
     * </p>
     * 
     * @return the current offset to be applied to local time (based on server
     *         time).
     */
    public Integer getServerTimeOffset() {
        return saasTimeOffset;
    }

    /**
     * <p>
     * Finds and instantiates a viable {@link Service} object.
     * </p>
     * 
     * @param <S>
     *            the specific type of the {@link Service}
     * @param <T>
     *            the specific type of the {@link Request}
     * @param requestType
     *            the type of the request object
     * @return a {@link Service} instance
     */
    protected <S extends Service, T extends Request> S getService(
            Class<T> requestType) {

        postProcess(FALL_BACK_SERVICE);
        return (S) FALL_BACK_SERVICE;
    }

    /**
     * <p>
     * Null constructor.
     * </p>
     */
    public AfriGISServices() {
        super();
    }

    /**
     * <p>
     * Instantiates (and caches) factory objects.
     * </p>
     * <p>
     * The purposes of a {@link ServiceCallFactory} is to give the caller access
     * to {@link Service} implementations, that in turn give the caller
     * programmatic access to services provided by AfriGIS.
     * </p>
     * 
     * @param key
     *            a valid AfriGIS key
     * @param secret
     *            a valid secret
     * @return a {@link ServiceCallFactory} instance that utilizes the provided
     *         credentials
     */
    public static ServiceCallFactory instance(String key, String secret) {
        final StringBuffer keyBuff =
                new StringBuffer(Integer.toHexString(key.hashCode()));
        keyBuff.append(Integer.toHexString(secret.hashCode()));

        ServiceCallFactory retVal = FACTORY_CACHE.get(keyBuff.toString());
        if (retVal == null) {
            synchronized (AfriGISServices.class) {
                if (retVal == null) {
                    retVal = new AfriGISServices(key, secret);
                    FACTORY_CACHE.put(keyBuff.toString(), retVal);
                }
            }

        }
        return retVal;
    }

    @Override
    public String getServiceEndpoint() {
        return baseServiceEndpointUrl;
    }

    @Override
    public <T extends Request, R extends Response> R get(T request) {
        if (request == null) {
            throw new AfriGISServicesException("Request can not be null");
        }
        final Service s = getService(request.getClass());
        return s.get(request);
    }

    @Override
    public <T extends Request, R extends Response> Future<R> getAsync(
            T request) {
        if (request == null) {
            throw new AfriGISServicesException("Request can not be null");
        }
        final Service s = getService(request.getClass());
        return s.getAsync(request);
    }

    @Override
    public <T extends Request> String getString(T request) {
        if (request == null) {
            throw new AfriGISServicesException("Request can not be null");
        }
        final Service s = getService(request.getClass());

        return s.getString(request);
    }

    @Override
    public <T extends Request> Future<String> getStringAsync(T request) {
        if (request == null) {
            throw new AfriGISServicesException("Request can not be null");
        }
        final Service s = getService(request.getClass());
        return s.getStringAsync(request);
    }

    @Override
    public <T extends Request> byte[] getByteArray(T request) {
        if (request == null) {
            throw new AfriGISServicesException("Request can not be null");
        }
        final Service s = getService(request.getClass());
        return s.getByteArray(request);
    }

    @Override
    public <T extends Request> Future<byte[]> getByteArrayAsync(T request) {
        if (request == null) {
            throw new AfriGISServicesException("Request can not be null");
        }
        final Service s = getService(request.getClass());
        return s.getByteArrayAsync(request);
    }

    @Override
    public String buildUrl(Request request) {
        if (request == null) {
            throw new AfriGISServicesException("Request can not be null");
        }
        final Service s = getService(GenericRequest.class);
        return s.buildUrl(request);
    }

    @Override
    public String getString(String serviceName, String queryString) {

        final Service s = getService(GenericRequest.class);
        return s.getString(serviceName, queryString);
    }

}
