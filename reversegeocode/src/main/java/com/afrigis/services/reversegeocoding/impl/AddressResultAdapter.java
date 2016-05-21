package com.afrigis.services.reversegeocoding.impl;

import com.afrigis.services.Coordinate;
import com.afrigis.services.internal.saas.api2.reverseGeocoding.parsedObjects.ReverseGeocodeResult;
import com.afrigis.services.reversegeocoding.AddressResult;

/**
 * Adapter class to make legacy code digestible for the new style.
 * 
 * @author hendrikc
 * @see AddressResult
 *
 */
public class AddressResultAdapter implements AddressResult {

    private final ReverseGeocodeResult source;

    /**
     * <p>
     * Constructor.
     * </p>
     * 
     * @param theSource
     *            the source object to create from.
     */
    public AddressResultAdapter(ReverseGeocodeResult theSource) {
        super();
        this.source = theSource;
    }

    @Override
    public String getDocId() {
        return source.getDocid();
    }

    @Override
    public String getDescription() {
        return source.getDescription();
    }

    @Override
    public Double getDistance() {
        return source.getDistance();
    }

    /**
     * @return a new {@link Coordinate} object, that carries the latitude and
     *         longitude of this result
     */
    @Override
    public Coordinate getLocation() {
        return new Coordinate(
                Double.valueOf(source.getLatitude()),
                Double.valueOf(source.getLongitude()));

    }

    @Override
    public String getDataset() {
        return source.getDataset();
    }

    @Override
    public Long getDatasetId() {
        return source.getDatasetID();
    }

    @Override
    public Double getLongitude() {
        return source.getLongitude();
    }

    @Override
    public Double getLatitude() {
        return source.getLatitude();
    }

}
