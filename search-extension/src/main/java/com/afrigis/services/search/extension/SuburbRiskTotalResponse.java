package com.afrigis.services.search.extension;

import com.afrigis.services.Response;

/**
 * <p>
 * Response produced by service call to AfriGIS Service call
 * </p>
 *
 * @author Takalani
 */
public interface SuburbRiskTotalResponse extends Response {

    /**
     * Get totalRisk from AfriGIS service call
     *
     * @return double
     * @throws java.lang.Exception in case the service call was invalid
     * according to the internal AfriGIS service API, cannot return 0 as this
     * would mean the service call was a success
     */
    public double getTotalRisk() throws Exception;

    /**
     * AfriGIS service call response, indicates status of service call
     *
     * @return code
     */
    public int getCode();

    /**
     * AfriGIS service call response message
     *
     * @return message from AfriGIS service call, null if request success
     */
    public String getMessage();

    /**
     * AfriGIS service call resource used
     *
     * @return name of API method used in AfriGIS services
     */
    public String getSource();
}
