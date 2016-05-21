package com.afrigis.services;

import java.util.Collection;

import com.afrigis.services.exceptions.AfriGISServicesException;

/**
 * <p>
 * Interface for object acting as request object to {@link Service} objects.
 * </p>
 * @author hendrikc
 * @see com.afrigis.services.impl.GenericRequest
 * @see Service
 */
public interface Request {
    /**
     * <p>
     * Returns the current request parameters as a {@link Collection}. Note this should
     * NOT return a copy of the underlying data structure.
     * </p>
     * @return the current request parameters
     */
    Collection<KeyValue> getRequestParameters();

    /**
     * <p>
     * Builds up a query parameter string (properly URL encoded).
     * </p>
     * <p>
     * THIS IS NOT HTTP QUERY PARAMATERS.
     * </p>
     * <p>
     * Well, it IS, BUT these parameters are very very specific to the service
     * sitting behind the SaaS wall.
     * </p>
     * 
     * @return a string that can (and should) be used as a query parameter
     *         string in a HTTP URL. All keys and values will be properly URL
     *         encoded
     */
    String toQueryString();

    /**
     * <p>
     * Provides the name of the service this request is accessing.
     * </p>
     * @return the name of the requested service
     * 
     */
    String getServiceName();

    /**
     * <p>
     * Validates the provided parameters.
     * </p>
     * 
     * @throws AfriGISServicesException
     *             if not all required parameters have been supplied, or if
     *             something is picked up as invalid
     */
    void validate() throws AfriGISServicesException;
    
    /**
     * <p>
     * Must supply the class of a {@link Response} implementation. The implementing class must
     * supply a null constructor.
     * </p>
     * <p>
     * Because of type erasure, we can not programmatically determine declared types at runtime.
     * </p> 
     * <p>
     * For easy of use, we want ONE {@link ServiceCallFactory} at run time to handle multiple
     * types of requests and responses.
     * </p>
     * <p>
     * For alignment with .Net implementation, we can't supply the Response object via argument list to 
     * the {@link ServiceCallFactory}. 
     * </p>
     * <p>
     * Which brings us to this work-a-round.
     * </p>
     * @return the class of the {@link Response} subclass associated with this request
     */
    Class<? extends Response> getResponseType ();

    /**
     * <p>
     * Allows overriding of the reported library mode.
     * </p>
     * <p>
     * Primarily provided for internal purposes.
     * </p>
     * @param libMode the lib mode supposed to be reported
     * @see LibMode
     */
    void setLibMode(LibMode libMode);

    /**
     * <p>
     * Retrieves the library mode that will be reported. Default is {@link LibMode#sync}
     * </p>
     * @return the lib mode that should be reported. Defaults to {@link LibMode#sync}
     */
    LibMode getLibMode();
    
    /**
     * <p>
     * Allows user to provide additional parameters to the service request that might
     * not be catered for via programmatic API.
     * 
     * </p>
     * @param extraParam the list of additional parameters. The list contents is copied into internal data structure. 
     */
    void setExtraParameters (Collection<KeyValue> extraParam);

    /**
     * <p>
     * Usefull when the library is being used as a pass-through between server and browser-based clients, where
     * JSONP techniques are required.
     * </p>
     * <p>
     * Essentially this will request the server to wrap the JSON response in a javascript function as required by JSONP.
     * </p>
     * @param callBack the javascript function to be pre-pended to the JSON response.
     */
    void setCallBack(String callBack);

    /**
     * <p>
     * Request the server to format the json response.
     * </p>
     *  
     * @param indent true if the json response should be formatted. 
     */
    void setIndent(boolean indent);
}
