package com.afrigis.services.reversegeocoding;

/**
 * <p>
 * Available levels for
 * <a href="https://developers.afrigis.co.za/portfolio/reverse-geocoding/">
 * Reverse Geocoding</a>.
 * </p>
 * 
 * @author hendrikc
 *
 */
public enum Level {

    /**
     * COUNTRY_0.
     */
    COUNTRY_0,

    /**
     * COUNTRY_1.
     */
    COUNTRY_1,

    /**
     * COUNTRY_2.
     */
    COUNTRY_2,

    /**
     * TOWN_3.
     */
    TOWN_3,

    /**
     * TOWN_4.
     */
    TOWN_4,

    /**
     * TOWN_5.
     */
    TOWN_5,

    /**
     * TOWN_6.
     */
    TOWN_6,

    /**
     * TOWN_7.
     */
    TOWN_7,

    /**
     * SUBURB_8.
     */
    SUBURB_8,

    /**
     * SUBURB_9.
     */
    SUBURB_9,

    /**
     * SUBURB_10.
     */
    SUBURB_10,

    /**
     * STREETS_11.
     */
    STREETS_11,

    /**
     * CROSSING_STREET_12.
     */
    CROSSING_STREET_12,

    /**
     * CROSSING_STREET_13.
     */
    CROSSING_STREET_13,

    /**
     * CROSSING_STREET_14.
     */
    CROSSING_STREET_14,

    /**
     * NAD_15.
     */
    NAD_15,

    /**
     * CAD_16.
     */
    CAD_16,

    /**
     * CAD_17.
     */
    CAD_17,

    /**
     * CAD_18.
     */
    CAD_18,

    /**
     * CAD_19.
     */
    CAD_19;

    /**
     * <p>
     * Valid levels are 1 to 20.
     * </p>
     * 
     * @return the numeric value of this level
     */
    public int level() {
        return ordinal() + 1;
    }

}
