package com.afrigis.services.geocode.impl;

import java.util.Arrays;

import com.afrigis.services.geocode.Bounds;
import com.afrigis.services.geocode.Geometry;
import com.afrigis.services.geocode.Location;
import com.afrigis.services.geocode.Viewport;

/**
 * <p>
 * Default implementation of {@link Geometry}.
 * </p>
 * 
 * @author sydney
 * 
 */
public class GeometryImpl extends com.afrigis.services.Coordinate
        implements Geometry {
    private Location location;
    private String[] types;

    private Viewport viewport;

    private Bounds bounds;

    /*
     * (non-Javadoc)
     * 
     * @see com.afrigis.services.geocode.impl.Geometry#getLocation()
     */
    @Override
    public Location getLocation() {
        return location;
    }

    /**
     * Sets the {@link Location}.
     * 
     * @param loc
     *            the {@link Location} to set
     */
    public void setLocation(Location loc) {
        this.location = loc;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.afrigis.services.geocode.impl.Geometry#getTypes()
     */
    @Override
    public String[] getTypes() {
        return types != null ? types.clone() : null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.afrigis.services.geocode.impl.Geometry#getLatitude()
     */
    @Override
    public Double getLatitude() {
        return location.getLatitude();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.afrigis.services.geocode.impl.Geometry#getLongitude()
     */
    @Override
    public Double getLongitude() {
        return location.getLongitude();
    }

    /**
     * Set the types.
     * 
     * @param typesIn
     *            the types to set.
     */
    public void setTypes(String[] typesIn) {
        this.types = typesIn != null ? typesIn.clone() : null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((location == null) ? 0 : location.hashCode());
        result = prime * result + Arrays.hashCode(types);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final GeometryImpl other = (GeometryImpl) obj;
        if (location == null) {
            if (other.location != null) {
                return false;
            }
        } else if (!location.equals(other.location)) {
            return false;
        }
        if (!Arrays.equals(types, other.types)) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.afrigis.services.geocode.impl.Geometry#getViewport()
     */
    @Override
    public Viewport getViewport() {
        return viewport;
    }

    /**
     * Sets the viewport.
     * 
     * @param viewportIn
     *            the viewport to set
     */
    public void setViewport(Viewport viewportIn) {
        this.viewport = viewportIn;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.afrigis.services.geocode.impl.Geometry#getBounds()
     */
    @Override
    public Bounds getBounds() {
        return bounds;
    }

    /**
     * Sets the bounds. Not intended for direct use - these objects are usually
     * deserialized from server response.
     * 
     * @param boundsIn
     *            the bounds to set.
     */
    public void setBounds(Bounds boundsIn) {
        this.bounds = boundsIn;
    }
}
