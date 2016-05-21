package com.afrigis.services;

/**
 * <p>
 * Gives an indication of how fine grained a geocoding response is (i.e. how
 * accurate).
 * </p>
 * 
 * @author hendrikc
 *
 */
public enum ConfidenceLevel {
    /**
     * <p>
     * Unknown confidence.
     * </p>
     */
    unknown,

    /**
     * <p>
     * Accurate.
     * </p>
     */
    accurate,

    /**
     * <p>
     * Accurate to erf level.
     * </p>
     */
    erf,

    /**
     * <p>
     * Accurate to sreet corner level.
     * </p>
     */
    streetCorner,

    /**
     * <p>
     * Accurate to within 5 numbers on the same street.
     * </p>
     */
    withinFiveOfStreetNumber,

    /**
     * <p>
     * Accurate to street name and suburb level.
     * </p>
     */
    streetNameAndSuburb,

    /**
     * <p>
     * Accurate to SG Town level.
     * </p>
     */
    sgTown,

    /**
     * <p>
     * Accurate to suburb level.
     * </p>
     */
    suburb,

    /**
     * <p>
     * Accurate to Town level.
     * </p>
     */
    town,

    /**
     * <p>
     * Accurate to municipality level.
     * </p>
     */
    municipalityOrDistrict,

    /**
     * <p>
     * Accurate to province level.
     * </p>
     */
    province;

    /**
     * <p>
     * Returns the level of the confidence.
     * </p>
     * 
     * @return the confidence level as an {@link Integer}
     */
    public Integer getLevel() {
        return this.ordinal();
    }

}
