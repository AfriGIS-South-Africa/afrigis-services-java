package com.afrigis.services.search.extension.intiendoLS.api2.params;

import com.afrigis.services.Response;
import com.afrigis.services.search.extension.PostalCodeGetType;
import com.afrigis.services.search.extension.impl.PostalCodeResponseDownloadImpl;
import com.afrigis.services.search.extension.impl.PostalCodeResponseImpl;

/**
 * <p>
 * Object contains service specific parameters for Postal Code service call
 * </p>
 *
 * @author Takalani
 */
public class PostalCodeParams extends SeoidLatLongAbstractParams {

    /**
     * <p>
     * Specify what kind of report to pull from the service call, JSON or PDF(in
     * the form of byte array)
     * </p>
     */
    private PostalCodeGetType postalCodeGetType;

    public void setPostalCodeGetType(PostalCodeGetType postalCodeGetType) {
        this.postalCodeGetType = postalCodeGetType;
    }

    public PostalCodeGetType getPostalCodeGetType() {
        return this.postalCodeGetType;
    }

    /**
     * <p>
     * Get postal code report using seoid
     * </p>
     *
     * @param email AfriGIS service client email making service call
     * @param seoid location identifier
     * @param postalCodeGetType get JSON or PDF report
     */
    public PostalCodeParams(String email, String seoid, PostalCodeGetType postalCodeGetType) {
        super(email, seoid);
        this.postalCodeGetType = postalCodeGetType;
    }

    /**
     *
     * <p>
     * Get postal code report using latitude and longitude
     * </p>
     *
     * @param email AfriGIS service client email making service call
     * @param latitude identify location
     * @param longitude identify location
     * @param postalCodeGetType get JSON or PDF report
     */
    public PostalCodeParams(String email, String latitude, String longitude, PostalCodeGetType postalCodeGetType) {
        super(email, latitude, longitude);
        this.postalCodeGetType = postalCodeGetType;
    }

    /**
     * <p>
     * Service to call, this based on postalCodeGetType
     * </p>
     *
     * @return String service to call
     */
    @Override
    public String getServiceName() {
        return postalCodeGetType.toString();
    }

    @Override
    public Class<? extends Response> getResponseType() {
        return postalCodeGetType == PostalCodeGetType.JSON ? PostalCodeResponseImpl.class : PostalCodeResponseDownloadImpl.class;
    }

}
