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

    public int getCode();

    public String getMessage();

    public String getSource();
}
