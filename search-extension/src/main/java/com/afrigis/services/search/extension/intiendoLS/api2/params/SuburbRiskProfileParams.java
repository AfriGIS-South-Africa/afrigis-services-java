package com.afrigis.services.search.extension.intiendoLS.api2.params;

import com.afrigis.services.Response;
import com.afrigis.services.search.extension.RiskGetType;
import com.afrigis.services.search.extension.impl.SuburbRiskProfileResponseDownloadImpl;
import com.afrigis.services.search.extension.impl.SuburbRiskProfileResponseImpl;
import com.afrigis.services.search.extension.impl.SuburbRiskTotalResponseImpl;

/**
 * <p>
 * Object contains service specific parameters for SuburbRiskProfile service
 * call
 * </p>
 *
 * @author Takalani
 */
public class SuburbRiskProfileParams extends SeoidLatLongAbstractParams {

    private RiskGetType riskGetType;

    public void setRiskGetType(RiskGetType riskGetType) {
        this.riskGetType = riskGetType;
    }

    public RiskGetType getRiskGetType() {
        return this.riskGetType;
    }

    /**
     * <p>
     * Get SuburbRiskProfile report using seoid
     * </p>
     *
     * @param email AfriGIS service client email making service call
     * @param seoid location identifier
     * @param riskGetType get JSON or PDF report
     */
    public SuburbRiskProfileParams(String email, String seoid, RiskGetType riskGetType) {
        super(email, seoid);
        this.riskGetType = riskGetType;
    }

    /**
     *
     * <p>
     * Get SuburbRiskProfile report using latitude and longitude
     * </p>
     *
     * @param email AfriGIS service client email making service call
     * @param latitude identify location
     * @param longitude identify location
     * @param riskGetType get JSON or PDF report
     */
    public SuburbRiskProfileParams(String email, String latitude, String longitude, RiskGetType riskGetType) {
        super(email, latitude, longitude);
        this.riskGetType = riskGetType;
    }

    /**
     * <p>
     * Service to call, this based on riskGetType
     * </p>
     *
     * @return String service to call
     */
    @Override
    public String getServiceName() {
        return riskGetType.toString();
    }

    @Override
    public Class<? extends Response> getResponseType() {
        switch (riskGetType) {
            case PDF:
                return SuburbRiskProfileResponseDownloadImpl.class;
            case JSON_TOTAL:
                return SuburbRiskTotalResponseImpl.class;
            default:
                return SuburbRiskProfileResponseImpl.class;
        }
    }

}
