package com.afrigis.services;

/**
 * <p>
 * Enumerates the known AfriGIS Services.
 * </p>
 *
 * @author hendrikc
 *
 */
public enum AfriGISService {
    /**
     * Enum for the <code>intiendols.basic.geocode.address.2</code> service.
     */
    geocodeServiceAddress("intiendols.basic.geocode.address.2"),
    /**
     * Enum for the <code>intiendols.basic.geocode.details.2</code> service.
     */
    geocodeServiceDetails("intiendols.basic.geocode.details.2"),
    /**
     * Please see https://developers.afrigis.co.za/portfolio/reverse-geocoding/
     * .
     */
    reverseGeocodeService("reverseGeocode.reverseGeocode"),
    /**
     * Please see https://developers.afrigis.co.za/portfolio/auto-complete-api/
     * .
     */
    tokenService("saas.getToken"),
    /**
     * Please see
     * https://developers.afrigis.co.za/portfolio/dropdown-search-api/ .
     */
    getProvinces("aghs.getProvinces"),
    /**
     * Please see
     * https://developers.afrigis.co.za/portfolio/dropdown-search-api/ .
     */
    getTowns("aghs.getTowns"),
    /**
     * <p>
     * Please see
     * https://developers.afrigis.co.za/portfolio/dropdown-search-api/ .
     * </p>
     */
    getSuburbs("aghs.getSuburbs"),
    /**
     * <p>
     * Enum for the <code>saas.getCredits</code> call.
     * </p>
     */
    getCredits("saas.getCredits"),
    /**
     * Please see https://developers.afrigis.co.za/portfolio/submit-address-api/
     * .
     */
    dataCorrectionsSubmit("data.corrections.submit");

    private final String serviceId;

    /**
     * <p>
     * Outputs the service id.
     * </p>
     *
     * @return the service id of this enum
     */
    public String toString() {
        return serviceId;
    }

    AfriGISService(String id) {
        serviceId = id;
    }

}
