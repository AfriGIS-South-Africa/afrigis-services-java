package com.afrigis.services.geocode;

/**
 * <p>
 * Please see
 * <a href="https://developers.afrigis.co.za/portfolio/search/#geov2">the
 * official documentation.</a>
 * </p>
 * <p>
 * Specifying the grouping will enforce the geocoder to add the grouping as part
 * of the results array.
 * </p>
 * 
 * @author hendrikc
 *
 */
public enum GeocodeGroupOption {
   
    /**
     * Requests that an array of address components be added to the response.
     */
    addressComponent,

    /**
     * Requests that the geometry containing geocoded and viewport related
     * components be added to the response.
     */
    geometry
}
