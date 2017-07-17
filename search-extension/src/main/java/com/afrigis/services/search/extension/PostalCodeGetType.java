package com.afrigis.services.search.extension;

/**
 *
 * Report types for postal code service
 *
 */
public enum PostalCodeGetType {

    /**
     * <p>
     * Enum for the <code>intiendols.extn.postalcode</code> call to get Postal
     * Code json response
     * <br> Please see
     * https://developers.afrigis.co.za/portfolio/afrigis-postal-codes-report/
     * </p>
     */
    JSON("intiendols.extn.postalcode"),
    /**
     * <p>
     * Enum for the <code>intiendols.extn.postalcodedownload</code> call to get
     * pdf byte[]
     * <br> Please see
     * https://developers.afrigis.co.za/portfolio/afrigis-postal-codes-report/
     * </p>
     */
    PDF("intiendols.extn.postalcodedownload");

    private final String serviceId;

    PostalCodeGetType(String id) {
        serviceId = id;
    }

    @Override
    public String toString() {
        return serviceId;
    }
}
