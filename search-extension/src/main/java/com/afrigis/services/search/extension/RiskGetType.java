package com.afrigis.services.search.extension;

/**
 *
 * Report types for address risk profile
 *
 */
public enum RiskGetType {

    /**
     * <p>
     * Enum for the <code>intiendols.extn.suburbRiskProfile</code> call to get
     * SuburbRiskProfile json response
     * <br> Please see https://developers.afrigis.co.za/portfolio/afrigis-risk/
     * </p>
     */
    JSON("intiendols.extn.suburbRiskProfile"),
    /**
     * <p>
     * Enum for the <code>intiendols.extn.suburbRiskDownload</code> call to get
     * pdf byte[]
     * <br> Please see https://developers.afrigis.co.za/portfolio/afrigis-risk/
     * </p>
     */
    PDF("intiendols.extn.suburbRiskDownload"),
    /**
     * <p>
     * Enum for the <code>intiendols.extn.suburbRiskTotal</code> call to get
     * totalRisk (double)
     * <br> Please see https://developers.afrigis.co.za/portfolio/afrigis-risk/
     * </p>
     */
    JSON_TOTAL("intiendols.extn.suburbRiskTotal");

    private final String serviceId;

    RiskGetType(String id) {
        serviceId = id;
    }

    @Override
    public String toString() {
        return serviceId;
    }
}
