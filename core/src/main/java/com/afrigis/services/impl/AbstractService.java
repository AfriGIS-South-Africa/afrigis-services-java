package com.afrigis.services.impl;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afrigis.services.KeyValue;
import com.afrigis.services.Request;
import com.afrigis.services.Response;
import com.afrigis.services.Service;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.ext.AsyncCapable;
import com.afrigis.services.ext.AuthenticatedService;
import com.afrigis.services.ext.ConfigurationAware;
import com.afrigis.services.ext.SaasTimeAware;
import com.afrigis.services.internal.saas.ServicesProxy;
import com.afrigis.services.internal.saas.api2.SaasClient;

/**
 * <p>
 * Abstract {@link Service} implementation that provides some re-usable code to
 * subclass implementations.
 * </p>
 * 
 * @author hendrikc
 *
 */
public abstract class AbstractService implements Service, ConfigurationAware,
        AuthenticatedService, AsyncCapable, SaasTimeAware {

    private volatile ServicesProxy saasClient;
    private ExecutorService exeService;

    @Override
    public String getString(Request params) {
        final GenericResponse defResp = new GenericResponse();
        getSaasClient().execute(params, defResp);
        return defResp.toString();
    }

    @Override
    public String getString(String serviceName, String queryParameters) {
        return getString(GenericRequest.build(serviceName, queryParameters));
    }

    private SaasClient getSaasClient() {

        if (this.saasClient == null) {
            synchronized (AbstractService.class) {
                if (this.saasClient == null) {

                    this.saasClient = new SaasClient();
                }
            }

        }
        return (SaasClient) saasClient;
    }

    @Override
    public byte[] getByteArray(Request params) {
        final GenericResponse defResp = new GenericResponse();
        getSaasClient().execute(params, defResp);
        return defResp.getByteArray();
    }

    @Override
    public String buildUrl(Request params) {
        return getSaasClient().buildUrl(params.getServiceName(),
                params.getRequestParameters());
    }

    @Override
    public void setCredentials(String clientId, byte[] sharedSecret) {
        getSaasClient().setSaasClient(clientId);
        getSaasClient().setSharedKey(sharedSecret);

    }

    @Override
    public void setTimeout(long timeout) {
        getSaasClient().setTimeout(timeout);
    }

    @Override
    public void setServer(String url) {
        getSaasClient().setServer(url);
    }

    @Override
    public void setExecService(ExecutorService execService) {
        ((AsyncCapable) getSaasClient()).setExecService(execService);
        this.exeService = execService;
    }

    /**
     * Executes request synchronously.
     * 
     * @param request
     *            the {@link Request} parameters
     * @param response
     *            the {@link Response} implementation
     */
    public void execute(Request request, Response response) {
        getSaasClient().execute(request, response);
    }

    /**
     * Executes request asynchronously.
     * 
     * @param <R> the implementation type of {@link Response}
     * @param request
     *            the {@link Request} parameters
     * @param completeBuild
     *            true if we should call {@link Response#completeBuild()} before
     *            handing it over
     * @return a {@link Future} promise wrapping the {@link Response}
     */
    public <R extends Response> Future<R> executeAsync(Request request,
            boolean completeBuild) {
        return getSaasClient().executeAsync(request, request.getResponseType(),
                completeBuild);
    }

    @Override
    public Future<String> getStringAsync(final Request req) {

        return exeService.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                final GenericResponse genResponse = new GenericResponse();
                getSaasClient().execute(req, genResponse);
                return genResponse.toString();

            }
        });
    }

    @Override
    public Future<byte[]> getByteArrayAsync(final Request request) {
        return exeService.submit(new Callable<byte[]>() {

            @Override
            public byte[] call() throws Exception {
                final GenericResponse genResponse = new GenericResponse();
                getSaasClient().execute(request, genResponse);
                return genResponse.getByteArray();

            }
        });
    }

    /**
     * Builds a correct and valid URL.
     * @param serviceName the desired service
     * @param requestParameters the request parameters
     * @return a valid URL (URL DOES expire after a server configured time)
     */
    public String buildUrl(String serviceName,
            Collection<KeyValue> requestParameters) {
        return getSaasClient().buildUrl(serviceName, requestParameters);
    }

    /**
     * 
     * @return {@link Logger} instance
     */
    protected Logger log() {
        return LoggerFactory.getLogger(getClass());
    }

    @Override
    public <T extends Response> T get(Request params)
            throws AfriGISServicesException {
        final Class<? extends Response> responseType = params.getResponseType();
        Response response;
        try {
            response = responseType.newInstance();
        } catch (Exception e) {
            throw new AfriGISServicesException(
                    "Failed to instantiate Response type '" + responseType
                            + "'",
                    e);
        }

        execute(params, response);

        if (response.getError() != null) {
            final AfriGISServicesException exp =
                    response.getError().getCause() != null
                            ? response.getError().getCause()
                            : new AfriGISServicesException(
                                    response.getError().getMessage());
            throw exp;
        }

        response.completeBuild();

        return (T) response;
    }

    @Override
    public <T extends Response> Future<T> getAsync(Request params) {
        final Future<T> future = executeAsync(params, true);

        return future;
    }

    /**
     * Does nothing.
     */
    @Override
    public void setUseSaasTime(boolean onOff) {
        // Does nothing

    }

    @Override
    public void setSaasOffsetInSeconds(int secs) {
        getSaasClient().setSaasOffsetInSeconds(secs);

    }

    @Override
    public int getSaasOffsetInSeconds() {
        return getSaasClient().getSaasOffsetInSeconds();
    }

    /**
     * 
     * @return default instance of {@link Service} implementor.
     */
    public static Service defaultInstance() {
        return new AbstractService() {

            @Override
            public boolean canHandle(Class<?> requestType) {
                return true;
            }

        };
    }

}
