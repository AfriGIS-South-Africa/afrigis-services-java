package com.afrigis.services.reversegeocoding;

/**
 * <p>
 * Enumeration of available layers for
 * <a href="https://developers.afrigis.co.za/portfolio/reverse-geocoding/">
 * Reverse Geocoding</a>.
 * </p>
 * 
 * @author hendrikc
 *
 */
public enum Layer {

    /**
     * AG_NAD.
     */
    NAD("AG_NAD"),

    /**
     * AG_CROSSING_STREETS.
     */
    CROSSING_STREETS("AG_CROSSING_STREETS"),

    /**
     * AG_STREETS.
     */
    STREETS("AG_STREETS"),

    /**
     * AG_SUBURBS.
     */
    SUBURBS("AG_SUBURBS"),

    /**
     * AG_TOWNS.
     */
    TOWNS("AG_TOWNS"),

    /**
     * AG_SUBTOWN.
     */
    SUBTOWNS("AG_SUBTOWN"),

    /**
     * AG_SECTIONAL_SCHEMES.
     */
    SECTIONAL_SCHEMES("AG_SECTIONAL_SCHEMES"),

    /**
     * AG_POINTS.
     */
    POINTS_OF_INTEREST("AG_POINTS"),

    /**
     * AG_CAD.
     */
    AG_CAD("AG_CAD"),

    /**
     * AG_CAD_ERVEN.
     */
    AG_CAD_ERVEN("AG_CAD_ERVEN"),

    /**
     * AG_CAD_FARMS.
     */
    AG_CAD_FARMS("AG_CAD_FARMS"),

    /**
     * AG_CAD_HOLDINGS.
     */
    AG_CAD_HOLDINGS("AG_CAD_HOLDINGS"),

    /**
     * AG_CAD_PARKS.
     */
    AG_CAD_PARKS("AG_CAD_PARKS");

    private String docID;

    Layer(String dId) {
        this.docID = dId;
    }

    /**
     * @return the AG DocID, which we can use as value for the layer parameter
     *         when reverse geocoding
     */
    @Override
    public String toString() {
        return docID;
    }

}
