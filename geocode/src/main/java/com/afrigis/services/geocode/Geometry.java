package com.afrigis.services.geocode;

/**
 * <p>
 * Encodes a Geometry as defined <a href="https://developers.afrigis.co.za/portfolio/search/">here.</a>
 * </p>
 * @author hendrikc
 *
 */
public interface Geometry {

    /**
     * Return the {@link Location}.
     * @return the {@link Location}. Might be null.
     */
    Location getLocation();

    /**
     * Return array of types.
     * @return array of types. Might be null.
     */
    String[] getTypes();

    /**
     * Return the decimal latitude.
     * @return the decimal latitude
     */
    Double getLatitude();

    /**
     * Return the decimal longitude.
     * @return the decimal longitude
     */
    Double getLongitude();

    /**
     * Return the {@link Viewport}.
     * @return the {@link Viewport}.Might be null.
     */
    Viewport getViewport();

    /**
     * Return the {@link Bounds}.
     * @return the {@link Bounds}. Might be null.
     */
    Bounds getBounds();

}

