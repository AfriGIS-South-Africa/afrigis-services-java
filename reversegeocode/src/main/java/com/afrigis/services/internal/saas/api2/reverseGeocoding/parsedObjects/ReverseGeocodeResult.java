package com.afrigis.services.internal.saas.api2.reverseGeocoding.parsedObjects;

import com.afrigis.services.Coordinate;

/**
 * A single record returned by the query. Query response will contain an array
 * of these.
 * 
 * @author sydney
 *
 */
public class ReverseGeocodeResult {
    private double latitude;
    private double longitude;
    private String docID;
    private String description;
    private String dataset;
    private long datasetID;
    private double distance;

    /**
     * 
     * @return Latitude of the found location
     */
    public final double getLatitude() {
        return latitude;
    }

    /**
     * 
     * @return Longitude of the found location
     */
    public final double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ReverseGeocodeResult [latitude=");
        builder.append(latitude);
        builder.append(", longitude=");
        builder.append(longitude);
        builder.append(", docID=");
        builder.append(docID);
        builder.append(", description=");
        builder.append(description);
        builder.append(", dataset=");
        builder.append(dataset);
        builder.append(", datasetID=");
        builder.append(datasetID);
        builder.append(", distance=");
        builder.append(distance);
        builder.append("]");
        return builder.toString();
    }

    /**
     * 
     * @return Description of the location
     */
    public final String getDescription() {
        return description;
    }

    /**
     * 
     * @return The dataset of the result
     */
    public final String getDataset() {
        return dataset;
    }

    /**
     * 
     * @return The dataset ID
     */
    public final long getDatasetID() {
        return datasetID;
    }

    /**
     * 
     * @return The distance from the co-ordinate point
     */
    public final double getDistanceAsDouble() {
        return distance;
    }

    /**
     * 
     * @return the document id of the retrieved address
     */
    public final String getDocid() {
        return docID;
    }

    /**
     * 
     * @return get the distance to centroid as a double.
     */
    public final Double getDistance() {
        return getDistanceAsDouble();
    }

    /**
     * 
     * @return a {@link Coordinate} object that wraps {@link #getLatitude()} and
     *         {@link #getLongitude()}
     */
    public Coordinate getLocation() {
        final ReverseGeocodeResult me = this;
        final Coordinate coord = new Coordinate(
                Double.valueOf(me.getLatitude()),
                Double.valueOf(me.getLongitude()));
        return coord;
    }

}
