package com.afrigis.services.geocode;

/**
 * <p>
 * Defines a
 * <a href="https://developers.afrigis.co.za/portfolio/search/">Viewport</a>.
 * </p>
 * 
 * @author hendrikc
 *
 */
public class Viewport {
    private Location southwest;
    private Location northeast;

    /**
     * Return south west {@link Location}
     * @return south west {@link Location}
     */
    public Location getSouthwest() {
        return southwest;
    }

    /**
     * Sets the south west {@link Location}.
     * @param southwestIn south west {@link Location}
     */
    public void setSouthwest(Location southwestIn) {
        this.southwest = southwestIn;
    }

    /**
     * Return north east {@link Location}.
     * @return north east {@link Location}
     */
    public Location getNortheast() {
        return northeast;
    }

    /**
     * Sets the north east {@link Location}.
     * @param northeastIn north east {@link Location}
     */
    public void setNortheast(Location northeastIn) {
        this.northeast = northeastIn;
    }

}
