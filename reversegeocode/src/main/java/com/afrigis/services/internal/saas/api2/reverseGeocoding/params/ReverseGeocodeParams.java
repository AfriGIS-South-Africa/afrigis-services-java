package com.afrigis.services.internal.saas.api2.reverseGeocoding.params;

import java.security.InvalidParameterException;
import java.util.Collection;

import com.afrigis.services.AfriGISService;
import com.afrigis.services.KeyValue;
import com.afrigis.services.Response;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.internal.saas.api2.AbstractParams;
import com.afrigis.services.internal.saas.api2.reverseGeocoding.response.ReverseGeocodeResponseSaaSImpl;

/**
 * Contains the service specific query parameters for the reverseGeocode call.
 *
 * @author sydney
 *
 */
public class ReverseGeocodeParams extends AbstractParams {

    private static final String NUM_RESULTS = "numResults";
    private static final String LONGITUDE = "longitude";
    private static final String LATITUDE = "latitude";
    private static final String LAYER = "layer";
    private static final String LEVEL = "level";
    private static final String RADIUS = "radius";

    private Double latitude;
    private Double longitude;
    private Integer numResults = 1;
    private String layer;
    private Double radius;
    private Integer level;

    /**
     *
     * @return Latitude part of the coordinate
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     *
     * @param d (Required) Latitude part of the coordinate
     */
    public void setLatitude(Double d) {
        if (d == null || d.isNaN()) {
            throw new InvalidParameterException(
                    "Latitude may not be null or NaN ");
        }
        this.latitude = d;
    }

    /**
     *
     * @return Longitude part of the coordinate
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     *
     * @param d (Required) Longitude part of the coordinate
     */
    public void setLongitude(Double d) {
        if (d == null || d.isNaN()) {
            throw new InvalidParameterException(
                    "Longitude may not be null or NaN ");
        }
        this.longitude = d;
    }

    /**
     *
     * @return The maximum number of results to return per call.
     */
    public Integer getNumResults() {
        return numResults;
    }

    /**
     * Default if not set is 1, maximum value 10. Count more than 10 will be
     * ignored.
     *
     * @param numberOfResults (Optional) The maximum number of results to return
     * per call.
     *
     */
    public void setNumResults(Integer numberOfResults) {
        this.numResults = numberOfResults;
    }

    /**
     *
     * @return The layer to reverse geocode on.
     */
    public String getLayer() {
        return layer;
    }

    /**
     * When the layer is defined, the level parameter is ignored.
     *
     * @param reverseGeocodeLayer (Optional) The layer to reverse geocode on.
     * Example: AG_STREETS
     */
    public void setLayer(String reverseGeocodeLayer) {
        this.layer = reverseGeocodeLayer;
    }

    /**
     *
     * @return Unit: kilometer. Maximum range to search.
     */
    public Double getRadius() {
        return radius;
    }

    /**
     * When layer is not defined, radius is ignored.
     *
     * @param searchRadius (Optional) Unit: kilometer. Maximum range to search.
     */
    public void setRadius(double searchRadius) {
        this.radius = searchRadius;
    }

    /**
     *
     * @return Level 0 – 19 corresponding to AfriGIS’ Tile levels.
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * When level is defined, and either layer or radius then that parameter
     * will be ignored and an intelligent match is performed.
     *
     * @param tileLevel (Optional) Level 0 – 19 corresponding to AfriGIS’ Tile
     * levels.
     */
    public void setLevel(int tileLevel) {
        this.level = tileLevel;
    }

    @Override
    public String getServiceName() {
        return AfriGISService.reverseGeocodeService.toString();
    }

    @Override
    public void validate() throws AfriGISServicesException {
        if (getLatitude() == null || getLatitude().isNaN()) {
            throw new AfriGISServicesException(
                    "Exceptions - missing mandatory parameter");
        }

        if (getLongitude() == null || getLongitude().isNaN()) {
            throw new AfriGISServicesException(
                    "Exceptions - missing mandatory parameter");
        }

    }

    @Override
    protected void completeRequestParamList(Collection<KeyValue> parameterMap) {
        parameterMap.add(new KeyValue(LATITUDE, String.valueOf(getLatitude())));
        parameterMap
                .add(new KeyValue(LONGITUDE, String.valueOf(getLongitude())));

        if (getNumResults() != null && getNumResults() != 0) {
            parameterMap.add(new KeyValue(
                    NUM_RESULTS, String.valueOf(Math.abs(getNumResults()))));
        }

        if (getLayer() != null) {
            parameterMap.add(new KeyValue(LAYER, getLayer()));
        }

        if (getRadius() != null && getRadius() != 0) {
            parameterMap.add(new KeyValue(
                    RADIUS, String.valueOf(Math.abs(getRadius()))));
        }

        if (getLevel() != null && getLevel() >= 0) {
            parameterMap.add(new KeyValue(LEVEL, String.valueOf(getLevel())));
        }

    }

    @Override
    public Class<? extends Response> getResponseType() {
        return ReverseGeocodeResponseSaaSImpl.class;
    }
}
