package com.afrigis.services.impl;

import java.util.ArrayList;
import java.util.Collection;

import com.afrigis.services.KeyValue;
import com.afrigis.services.Request;
import com.afrigis.services.Response;
import com.afrigis.services.exceptions.AfriGISServicesException;

/**
 * <p>
 * General use implementation of {@link Request}.
 * </p>
 * 
 * @author hendrikc
 *
 */
//CHECKSTYLE:OFF: AbstractClassName
public abstract class GenericRequest extends AbstractRequest
        implements Request {
    // CHECKSTYLE:ON: AbstractClassName

    /**
     * <p>
     * Method that will build a {@link Request} implementation for you.
     * </p>
     * 
     * @param serviceName
     *            the service name that you need to access
     * @return a {@link Request} implementation
     * @see com.afrigis.services.AfriGISService
     */
    public static Request build(final String serviceName) {
        return new GenericRequest() {

            @Override
            public String getServiceName() {
                return serviceName;
            }

            /**
             * Does nothing
             */
            @Override
            public void validate() throws AfriGISServicesException {
            }

            @Override
            protected
                    void completeRequestParamList(Collection<KeyValue> input) {
                // Does nothing.

            }

        };
    }

    /**
     * <p>
     * Method that will build a {@link Request} implementation for you.
     * </p>
     * 
     * @param serviceName
     *            the service name that you need to access
     * @param params
     *            a {@link Collection} of {@link KeyValue} objects
     * @return a {@link Request} implementation
     * 
     * @see com.afrigis.services.AfriGISService
     */
    public static Request build(final String serviceName,
            final Collection<KeyValue> params) {
        return new GenericRequest() {

            @Override
            public Collection<KeyValue> getRequestParameters() {
                return params;
            }

            @Override
            public String getServiceName() {
                return serviceName;
            }

            /**
             * Does nothing.
             */
            @Override
            public void validate() throws AfriGISServicesException {
            }

            @Override
            protected
                    void completeRequestParamList(Collection<KeyValue> input) {
                // Does nothing

            }
        };
    }

    /**
     * <p>
     * Builds a {@link Request} object from the provided service name and HTTP
     * query string.
     * </p>
     * <p>
     * I strongly urge you to rather look at {@link #build(String, Collection)},
     * in order to prevent unintended foot shootings.
     * </p>
     * 
     * @param serviceName
     *            the name of the service
     * @param params
     *            the query string parameter, NOT URL encoded
     * @return a valid {@link Request} object
     * @see com.afrigis.services.AfriGISService
     * @see <a href="https://en.wikipedia.org/wiki/Query_string">Query
     *      String</a>
     */
    public static Request build(final String serviceName, final String params) {
        return new GenericRequest() {

            @Override
            public Collection<KeyValue> getRequestParameters() {
                return goFish(params);
            }

            /**
             * <p>
             * Breaks up provided query string on <code>&amp;</code> character,
             * and then on <code>=</code> character in order to produce a result
             * that is digestable for the rest of the system.
             * </p>
             * 
             * @param params
             *            the query string
             * @return the processed key-value items
             */
            private Collection<KeyValue> goFish(String params) {
                final Collection<KeyValue> retList = new ArrayList<>();
                /*
                 * I suspect many things can go wrong here.
                 */
                final String[] keyVal = params.split("[&]");
                for (int i = 0; i < keyVal.length; i++) {
                    try {
                        log().trace("Generic thing adding: {}", keyVal[i]);
                        final String[] splitted = keyVal[i].split("[=]");
                        final String key = splitted[0];
                        final String val = splitted[1];
                        retList.add(new KeyValue(key, val));
                    } catch (Exception e) {
                        log().warn(
                                "Exception encountered while breaking up the query string",
                                e);
                    }
                }
                return retList;
            }

            @Override
            public String getServiceName() {
                return serviceName;
            }

            /**
             * Does nothing.
             */
            @Override
            public void validate() throws AfriGISServicesException {
            }

            @Override
            protected
                    void completeRequestParamList(Collection<KeyValue> input) {
                // Does nothting

            }
        };
    }

    @Override
    public Class<? extends Response> getResponseType() {
        return GenericResponse.class;
    }

}
