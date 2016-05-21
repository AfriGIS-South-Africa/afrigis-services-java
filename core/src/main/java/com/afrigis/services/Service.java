package com.afrigis.services;

import java.util.concurrent.Future;

import com.afrigis.services.exceptions.AfriGISServicesException;

/**
 * <p>
 * Main Interface for things that want to act as "Service clients".
 * </p> 
 * 
 * @author hendrikc
 *
 */
public interface Service {
        
    /**
     * <p>
     * Blocking (synchronous) call to fetch deserialized object.
     * </p>
     * @param <T> the specific {@link Response} type this method will return
     * @param params the request parameters
     * @return a deserialized response object
     * @throws AfriGISServicesException if problems are encountered, this is thrown
     * @see Request
     * @see com.afrigis.services.impl.GenericRequest#build(String, java.util.Collection)
     */
    <T extends Response> T get(Request params) throws AfriGISServicesException;
    
    /**
     * 
     * <p>
     * Blocking (synchronous) call to fetch server response as a UTF-8 encoded string.
     * </p>
     * 
     * @param params the request parameters
     * @return the response as a string (as received from server)
     * @see #get(Request)
     */
    String getString (Request params);
    
    /**
     * <p>
     * Fetches server response as a UTF-8 encoded String
     * </p>
     * <p>
     * Fair warning: there are many ways you can damage yourself with this.
     * I urge you to rather look at {@link #getString(Request)}
     * </p>
     * @param serviceName the name of the target service
     * @param queryParameters the HTTP Query parameters string
     * @return the Server response as received from the server
     * @see <a href="https://en.wikipedia.org/wiki/Query_string">Query String</a>
     */
    String getString (String serviceName, String queryParameters);
    
    /**
     * <p>
     * Returns a copy of the bytes received from the server.
     * </p>
     * @param params the request parameters
     * @return a copy of the byte array as received from the server
     */
    byte[] getByteArray (Request params);
        
    /**
     * <p>
     * Asynchronously executes the request against the server.
     * </p>
     * @param <T> the specific type of the {@link Response} object
     * @param params the request parameters
     * @return parsed response object, wrapped in a {@link Future} promise
     */
    <T extends Response> Future <T> getAsync(Request params);
    
    /**
     * <p>
     * Same function as {@link #getAsync(Request)}, but returns the response as a {@link String}.
     * </p>
     * @param req  the request parameters 
     * @return the server response as a {@link String}, wrapped ina {@link Future} promise
     */
    Future<String> getStringAsync(Request req);
    
    /**
     * <p>
     * Same function as {@link #getAsync(Request)}, but returns the response as a <code>byte</code> array.
     * </p>
     * @param req the request parameters 
     * @return bytes received from the server, wrapped in a Fu
     */
    Future<byte[]> getByteArrayAsync(Request req);
    
    /**
     * <p>
     * Produces a valid URL that can be used by external tools/code - for a limited time (server configured).
     * </p>
     * @param params the request parameters
     * @return a valid URL 
     */
    String buildUrl (Request params);

    /**
     * <p>
     * Used by implementors.
     * </p>
     * <p>
     * Should check if the implementing class is willing/able to handle the {@link Request} type.
     * </p>
     * @param requestType the type of the request
     * @return true if the instance is able to handle the request, false otherwise
     */
    boolean canHandle (Class<?> requestType);
    
}
