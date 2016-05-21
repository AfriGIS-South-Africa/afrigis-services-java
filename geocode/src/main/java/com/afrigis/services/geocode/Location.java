package com.afrigis.services.geocode;

/**
 * <p>
 * Defines a
 * <a href="https://developers.afrigis.co.za/portfolio/search/">Location</a>.
 * </p>
 * 
 * @author sydney
 *
 */
public class Location {
    private static final int ONE_WORD = 32;
    private Double lat;
    private Double lng;

    /**
     * Return decimal latitude.
     * @return decimal latitude
     */
    public Double getLatitude() {
        return lat;
    }

    /**
     * Return decimal longitude.
     * @return decimal longitude
     */
    public Double getLongitude() {
        return lng;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(lat);
        result = prime * result + (int) (temp ^ (temp >>> ONE_WORD));
        temp = Double.doubleToLongBits(lng);
        result = prime * result + (int) (temp ^ (temp >>> ONE_WORD));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat)) {
            return false;
        }
        if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng)) {
            return false;
        }
        return true;
    }
}
