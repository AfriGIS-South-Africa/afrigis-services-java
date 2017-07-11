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

    public double getTotalRisk();
}
