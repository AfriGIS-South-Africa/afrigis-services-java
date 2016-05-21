package com.afrigis.services;

/**
 * <p>
 * Represents a decimal GPS coordinate.
 * </p>
 * 
 * @author hendrikc
 *
 */
public class Coordinate {

    private Double latitude;

    private Double longitude;

    /**
     * <p>
     * Null constructor.
     * </p>
     */
    public Coordinate() {
        super();
    }

    /**
     * <p>Constructor.</p>
     * @param latitudeIn the latitude
     * @param longitudeIn the longitude
     */
    public Coordinate(Double latitudeIn, Double longitudeIn) {
        super();
        this.latitude = latitudeIn;
        this.longitude = longitudeIn;
    }

    /**
     * 
     * @return the decimal latitude of the coordinate.
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * <p>
     * Sets the decimal latitude.
     * </p>
     * @param latitudeIn the decimal latitude
     */
    public final void setLatitude(Double latitudeIn) {
        this.latitude = latitudeIn;
    }

    /**
     * <p>
     * Sets the decimal longitude.
     * </p>
     * @param longitudeIn the decimal longitude
     */
    public final void setLongitude(Double longitudeIn) {
        this.longitude = longitudeIn;
    }

    /**
     * 
     * @return the decimal longitude of the coordinate.
     */
    public Double getLongitude() {

        return longitude;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((latitude == null) ? 0 : latitude.hashCode());
        result = prime * result
                + ((longitude == null) ? 0 : longitude.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordinate other = (Coordinate) obj;
        if (latitude == null) {
            if (other.latitude != null) {
                return false;
            }
        } else if (!latitude.equals(other.latitude)) {
            return false;
        }
        if (longitude == null) {
            if (other.longitude != null) {
                return false;
            }
        } else if (!longitude.equals(other.longitude)) {
            return false;
        }
        return true;
    }

}
