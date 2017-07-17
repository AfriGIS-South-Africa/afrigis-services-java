package com.afrigis.services.search.extension;

import com.afrigis.services.Response;
import com.afrigis.services.search.extension.risk.SuburbRiskProfile;

/**
 * <p>
 * Response produced by service call to AfriGIS Service call
 * </p>
 *
 * @author Takalani
 */
public interface SuburbRiskProfileResponse extends Response {

    public SuburbRiskProfile getResult();

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
