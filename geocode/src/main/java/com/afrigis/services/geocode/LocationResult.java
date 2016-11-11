package com.afrigis.services.geocode;

import java.util.List;

import com.afrigis.services.ConfidenceLevel;
import com.afrigis.services.Coordinate;
import com.afrigis.services.geocode.impl.AddressComponent;

/**
 * <p>
 * Represents a LocationResult obtained from an AfriGIS Service.
 * </p>
 * 
 * @author hendrikc
 *
 */
public interface LocationResult {
    /**
     * Return the SEO ID of this address.
     * @return the SEO ID of this address
     */
    String getSeoId();

    /**
     * Return the document ID of this address.
     * @return the document ID of this address
     */
    String getDocId();

    /**
     * Return a textual representation of the address (this should be
     *         presentable in a user interface)
     * @return a textual representation of the address (this should be
     *         presentable in a user interface)
     */
    String getFormattedAddress();

    /**
     * Return the {@link ConfidenceLevel} for this object
     * @return the {@link ConfidenceLevel} for this object
     */
    ConfidenceLevel getConfidence();

    /**
     * Return numeric value of {@link ConfidenceLevel}
     * @return numeric value of {@link ConfidenceLevel}
     */
    Integer getLevel();

    /**
     * Return the decimal GPS coordinates of this address, as obtained from
     * AfriGIS Service.
     * @return the decimal GPS coordinates of this address, as obtained from
     *         AfriGIS Service
     */
    Coordinate getLocation();

    /**
     * Return parsed {@link Geometry} object.
     * @return parsed {@link Geometry} object.
     */
    Geometry getGeometry();

    /**
     * Return list of types received from server.
     * @return return list of types received from server.
     */
    List<String> getTypes();

    /**
     * Return list of {@link AddressComponent} objects.
     * @return list of {@link AddressComponent} objects
     */
    List<AddressComponent> getAddressComponents();

}
