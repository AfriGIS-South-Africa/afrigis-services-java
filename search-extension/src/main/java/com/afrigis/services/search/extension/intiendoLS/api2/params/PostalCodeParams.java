package com.afrigis.services.search.extension.intiendoLS.api2.params;

import com.afrigis.services.KeyValue;
import com.afrigis.services.Response;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.internal.saas.api2.AbstractParams;
import com.afrigis.services.search.extension.PostalCodeGetType;
import com.afrigis.services.search.extension.impl.PostalCodeResponseDownloadImpl;
import com.afrigis.services.search.extension.impl.PostalCodeResponseImpl;
import java.util.Collection;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * Object contains service specific parameters for Postal Code service call
 * </p>
 *
 * @author Takalani
 */
public class PostalCodeParams extends AbstractParams {

    private static final String SEOID = "id";
    private static final String EMAIL = "email";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String EMAIL_REGEX = "(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-zA-Z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private String seoid;
    private String email;
    private String latitude;
    private String longitude;
    /**
     * <p>
     * Specify what kind of report to pull from the service call, JSON or PDF(in
     * the form of byte array)
     * </p>
     */
    private PostalCodeGetType postalCodeGetType;

    /**
     *
     * @return String seoid to identify location to get postal code for
     */
    public String getSeoid() {
        return seoid;
    }

    /**
     *
     * @param seoid identify location to get postal code for
     */
    public void setSeoid(String seoid) {
        this.seoid = seoid;
    }

    /**
     * <p>
     * Email of client making AfriGIS service call
     * </p>
     *
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email set client email making AfriGIS service call
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <p>
     * Latitude to identify location, used in conjunction with Longitude, an
     * alternative to using seoid
     * </p>
     *
     * @return String
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * <p>
     * Set latitude to identify location
     * </p>
     *
     * @param latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * <p>
     * Latitude to identify location, used in conjunction with Latitude, an
     * alternative to using seoid
     * </p>
     *
     * @return String
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * <p>
     * Set longitude to identify location
     * </p>
     *
     * @param longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
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
        this.email = email;
        this.seoid = seoid;
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
        this.latitude = latitude;
        this.longitude = longitude;
        this.email = email;
        this.postalCodeGetType = postalCodeGetType;
    }

    /**
     * <p>
     * Add AfriGIS service specific parameters
     * </p>
     *
     * @param input
     */
    @Override
    protected void completeRequestParamList(Collection<KeyValue> input) {
        addKeyValParam(EMAIL, getEmail(), input);

        if (getSeoid() != null && getSeoid().trim().length() > 0) {
            addKeyValParam(SEOID, getSeoid(), input);
        } else {
            addKeyValParam(LATITUDE, getLatitude(), input);
            addKeyValParam(LONGITUDE, getLongitude(), input);
        }
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

    /**
     * <p>
     * Verify all required service parameters and their format
     * </p>
     *
     * @throws AfriGISServicesException
     */
    @Override
    public void validate() throws AfriGISServicesException {
        if (StringUtils.isBlank(getEmail())) {
            throw new AfriGISServicesException(
                    "Exceptions - missing mandatory parameter (email)");
        }
        // Valid email?
        if (!getEmail().matches(EMAIL_REGEX)) {
            throw new AfriGISServicesException(
                    "Exceptions - invalid email");
        }

        if (StringUtils.isBlank(getSeoid()) && (StringUtils.isBlank(getLatitude()) || StringUtils.isBlank(getLongitude()))) {
            throw new AfriGISServicesException(
                    "Exceptions - missing mandatory parameter (" + (StringUtils.isBlank(getSeoid()) ? "seoid" : "latitude or longitude") + ")");
        }
    }

    @Override
    public Class<? extends Response> getResponseType() {
        return postalCodeGetType == PostalCodeGetType.JSON ? PostalCodeResponseImpl.class : PostalCodeResponseDownloadImpl.class;
    }

}
