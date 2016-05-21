package com.afrigis.services.internal.saas.api2.reverseGeocoding.parsedObjects;

import com.afrigis.services.internal.saas.api2.ParsedData;

/**
 * <p>
 * Object created from the parsing of the query result.
 * </p>
 * <p>
 * Result of this format is returned by both the reverseGeocode call.
 * </p>
 * 
 * @author sydney
 * 
 */
public class ParsedReverseGeocodeData implements ParsedData {


    private ReverseGeocodeResult[] result;
    private int count;
    private int responseCode;
    private String responseMessage;
    private double qTime;

    /**
     * 
     * @return An array of query results
     */
    public ReverseGeocodeResult[] getResults() {
        return result != null ? result.clone() : null;
    }

    /**
     * 
     * @return number of results found
     */
    public int getCount() {
        return count;
    }

    /**
     * 
     * @return Response code of the query result, e.g. 0
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * 
     * @return Message returned by the query
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * 
     * @return Time taken by the query
     */
    public double getqTime() {
        return qTime;
    }

}
