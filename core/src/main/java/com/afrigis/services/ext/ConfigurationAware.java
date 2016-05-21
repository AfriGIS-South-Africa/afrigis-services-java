package com.afrigis.services.ext;

/**
 * <p>
 * Interface that defines some optional configuration options that might be
 * applicable to service factory implementors.
 * </p>
 * 
 * @author hendrikc
 *
 */
public interface ConfigurationAware {
    /**
     * <p>
     * Allows the override of service end point url.
     * </p>
     * 
     * @param url
     *            the full, correct and valid url of the service end point.
     */
    void setServer(String url);

    /**
     * <p>
     * Connection and connection request timeout, in milliseconds.
     * </p>
     * 
     * @param timeout
     *            milliseconds until we give up trying to connect
     * @see <a href=
     *      "https://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/client/config/RequestConfig.html">
     *      HTTPClient Configuration</a>
     */
    void setTimeout(long timeout);

}
