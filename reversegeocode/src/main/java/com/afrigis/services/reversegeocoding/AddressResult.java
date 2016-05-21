package com.afrigis.services.reversegeocoding;

import com.afrigis.services.Coordinate;

/**
 * Represents a result obtained through a
 * <a href="https://developers.afrigis.co.za/portfolio/reverse-geocoding/#S2">
 * reverse geocoding request</a>.
 * 
 * @author hendrikc
 *
 */
public interface AddressResult {

    /**
     * 
     * @return The location DocID
     */
    String getDocId();

    /**
     * 
     * @return Description of the location
     */
    String getDescription();

    /**
     * 
     * @return The distance from the co-ordinate point
     */
    Double getDistance();

    /**
     * 
     * @return the {@link Coordinate} of the location
     */
    Coordinate getLocation();

    /**
     * See https://developers.afrigis.co.za/portfolio/reverse-geocoding/ .
     * 
     * @return the name of the source dataset
     */
    String getDataset();

    /**
     * See https://developers.afrigis.co.za/portfolio/reverse-geocoding/ .
     * 
     * @return the id of the source dataset
     */
    Long getDatasetId();

    /**
     * Returns the decimal longitude of the coordinate.
     * 
     * @return the decimal longitude of the result
     * @see #getLocation()
     * @see #getLatitude()
     */
    Double getLongitude();

    /**
     * Returns the decimal latitude of the coordinate.
     * 
     * @return the decimal latitude of the result
     * @see #getLocation()
     * @see #getLongitude()
     */
    Double getLatitude();
}
