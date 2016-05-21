package com.afrigis.services;

import java.util.concurrent.Future;

/**
 * <p>
 * Implementing classes are responsible for producing various service objects,
 * that in turn implement the services provided by AfriGIS.
 * </p>
 * 
 * @author hendrikc
 *
 * 
 */
public interface ServiceCallFactory {

    /**
     * <p>
     * Allows overriding of the service end point URL to be used.
     * </p>
     * 
     * <p>
     * If you provide a URL via this method, we assume you know what you are
     * doing. So we will use this URL as the base for our calls AS-IS.
     * </p>
     * 
     * @param server
     *            the server hostname,and optionally protocol
     * 
     */
    void setServiceEndpoint(String server);

    /**
     * 
     * @return the base server url
     */
    String getServiceEndpoint();

    /**
     * <p>
     * Allows user to hint at a connection, connection request, and socket
     * timeout.
     * </p>
     * <p>
     * Default should be 30seconds.
     * </p>
     * 
     * @param timeoutInSec
     *            essentially HTTP/TCP/IP timeout, specified in seconds
     */
    void setTimeout(int timeoutInSec); // units = seconds

    /**
     * <p>
     * Fetches the remaining credits for the account.
     * </p>
     * 
     * @return remaining credit balance for the account
     */
    int getCreditBalance();

    /**
     * <p>
     * Async version of {@link #getCreditBalance()}.
     * </p>
     * 
     * @return a {@link Future} promise that should contain the remaining
     *         balance.
     */
    Future<Integer> getCreditBalanceAsync();

    /**
     * <p>
     * Fetches a deserialized object from the server. The Response object
     * returned will extend/implement {@link Response} super class.
     * </p>
     * 
     * @param <T>
     *            the specific type of the service request. Must implement
     *            {@link Request}
     * @param <R>
     *            the specific type of the request object. Must implement
     *            {@link Response}
     * @param request
     *            the implementation of {@link Request} appropriate to the
     *            desired service
     * @return an implementation of {@link Response} appropriate for the desired
     *         service
     */
    <T extends Request, R extends Response> R get(T request);

    /**
     * <p>
     * Async version of {@link #get(Request)}.
     * </p>
     * 
     * @param <T>
     *            the specific type of the service request. Must implement
     *            {@link Request}
     * @param <R>
     *            the specific type of the request object. Must implement
     *            {@link Response}
     * @param request
     *            the implementation of {@link Request} appropriate to the
     *            desired service
     * @return an implementation of {@link Response} appropriate for the desired
     *         service, wrapped in a {@link Future} promise
     */
    <T extends Request, R extends Response> Future<R> getAsync(T request);

    /**
     * <p>
     * Fetches a response from the server, as a String.
     * </p>
     * 
     * @param <T>
     *            the specific type of the service request. Must implement
     *            {@link Request}
     * @param request
     *            the implementation of {@link Request} appropriate to the
     *            desired service
     * @return the response of the server, converted to a UTF-8 String
     */
    <T extends Request> String getString(T request);

    /**
     * <p>
     * Fetches a response from the server, as a String, asynchronously.
     * </p>
     * 
     * @param <T>
     *            the specific type of the service request. Must implement
     *            {@link Request}
     * @param request
     *            the implementation of {@link Request} appropriate to the
     *            desired service
     * @return the response of the server, converted to a UTF-8 String
     * @see #getString(Request)
     */
    <T extends Request> Future<String> getStringAsync(T request);

    /**
     * <p>
     * Fetches a response from the server, as a byte array.
     * </p>
     * 
     * @param <T>
     *            the specific type of the service request. Must implement
     *            {@link Request}
     * @param request
     *            the implementation of {@link Request} appropriate to the
     *            desired service
     * @return the response of the server, as a byte array
     */
    <T extends Request> byte[] getByteArray(T request);

    /**
     * <p>
     * Asynchronous version of {@link #getByteArray(Request)}.
     * </p>
     * 
     * @param <T>
     *            the specific type of the service request. Must implement
     *            {@link Request}
     * @param request
     *            the implementation of {@link Request} appropriate to the
     *            desired service
     * @return the response of the server, as a byte array
     */
    <T extends Request> Future<byte[]> getByteArrayAsync(T request);

    /**
     * <p>
     * Produces a full valid url that can be used by an external call, while it
     * is valid.
     * </p>
     * <p>
     * URLs are valid for server configured amount of time. At time of writing,
     * that is 1 minute.
     * </p>
     * 
     * @param request
     *            the implementation of {@link Request} appropriate to the
     *            desired service
     * @return a URL that can be used to query the desired AfriGIS Services
     *         (while valid)
     */
    String buildUrl(Request request);

    /**
     * <p>
     * THis method allows the user to provide a service name, and a pre-built
     * query parameter string.
     * </p>
     * <p>
     * THe query parameters must not be encoded - the lib will attempt to do
     * that for you.
     * </p>
     * 
     * @param serviceName
     *            the valid AfriGIS Services service name
     * @param queryString
     *            the pre-build (UNENCODED) query string
     * @return the server response, as a UTF-8 encoded String.
     */
    String getString(String serviceName, String queryString);

}
