package com.afrigis.services.internal.saas;

import java.util.Collection;
import java.util.concurrent.Future;

import com.afrigis.services.KeyValue;
import com.afrigis.services.Request;
import com.afrigis.services.Response;

/**
 * Defines the contract for Service proxy implementations.
 * 
 * @author hendrikc
 *
 *
 */
public interface ServicesProxy {

    /**
     * Builds up the URL from the available parameters, generates the HMAC and
     * adds all the faff to make the call work.
     * 
     * @param saasQuery
     *            The string containing the SERVICE SPECIFIC query parameters
     * @param saasService
     *            the name of the service to be called.
     * @param nonce
     *            timestamp for security
     * @return The final URL to call
     */
    String completeUrl(String saasService, String saasQuery, long nonce);

    /**
     * Generates the HMAC string from built up saasMessage, and fixes the HMAC.
     * 
     * @param serviceName
     *            the name of the desired AfriGIS Service
     * @param saasQuery
     *            The string containing the SERVICE SPECIFIC query parameters
     * @param nonce
     *            supposed to be a random number, but in our case it is the
     *            current epoc time in milliseconds
     * @return the (corrected) base64 encoded HMAC
     * 
     */
    String buildHmac(String serviceName, String saasQuery, long nonce);

    /**
     * <p>
     * Executes the request synchronously.
     * </p>
     * 
     * @param req
     *            the request parameters
     * @param resp
     *            the parsed response
     */
    void execute(Request req, Response resp);

    /**
     * @param <R>
     *            the type of the {@link Response} implementation
     * @param req
     *            the {@link Request} implementation
     * @param responseType
     *            the type of the {@link Response} implementation
     * @param completeBuild
     *            if we should call {@link Response#completeBuild()} before
     *            returning
     * @return a {@link Future} object that, if all goes well, will contain the
     *         {@link Response} object
     */
    <R extends Response> Future<R> executeAsync(Request req,
            Class<?> responseType, boolean completeBuild);

    /**
     * <p>
     * Builds a valid url.
     * </p>
     * 
     * @param serviceName
     *            the name of the afrigis services to be consumed
     * @param params
     *            the parameters
     * @return a valid URL
     */
    String buildUrl(String serviceName, Collection<KeyValue> params);

    /**
     * <p>
     * Obtain a service ID from https://developers.afrigis.co.za/sign-up/ .
     * </P>
     * 
     * @param serviceId
     *            the service ID.
     */
    void setSaasClient(String serviceId);

    /**
     * <p>
     * Obtain a service ID from https://developers.afrigis.co.za/sign-up/ .
     * </P>
     * 
     * @param sharedSecret
     *            the secret key
     */
    void setSharedKey(byte[] sharedSecret);

    /**
     * <p>
     * Allows caller to override the service end point.
     * </p>
     * 
     * @param url
     *            service end point to use. Must be a full, valid URL
     */
    void setServer(String url);

    /**
     * <p>
     * Sets connection timeout in milliseconds.
     * </p>
     * 
     * @param timeOutInMillis
     *            timeout value in milliseconds
     */
    void setTimeout(long timeOutInMillis);

}
