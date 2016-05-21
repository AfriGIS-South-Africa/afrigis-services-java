package com.afrigis.services.internal.saas.api2.reverseGeocoding.response;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afrigis.services.Response;
import com.afrigis.services.impl.AbstractResponse;
import com.afrigis.services.internal.saas.api2.reverseGeocoding.parsedObjects.ParsedReverseGeocodeData;
import com.afrigis.services.internal.saas.api2.reverseGeocoding.parsedObjects.ReverseGeocodeResult;
import com.google.gson.Gson;

/**
 * <p>
 * Response returned by search and getDetails calls. Contains a
 * parsedSearchResult and ParsedErrorData.
 * </p>
 * <p>
 * Only one of these should contain values. Use isError() to determine which
 * contains the response.
 * </p>
 * 
 * @author sydney
 * 
 */
public class ReverseGeocodeResponseSaaSImpl extends AbstractResponse
        implements Response {

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ReverseGeocodeResponseSaaSImpl [httpStatusCode=");
        builder.append(getHttpStatusCode());
        builder.append(", errMesg=");
        builder.append(getErrorMessage());
        builder.append(", results=");
        builder.append(results);
        builder.append(", error=");
        builder.append(getError());

        builder.append("]");
        return builder.toString();
    }

    private ParsedReverseGeocodeData results;
//    private ParsedErrorData error;

    /**
     * 
     * @return Object containing the result of the query, IF there was no error
     */
    public ParsedReverseGeocodeData getResults() {
        return results;
    }
   
   
    /**
     * <p>
     * Return logger instance.
     * </p>
     * 
     * @return {@link Logger} instance
     */
    protected Logger getLog() {
        return LoggerFactory.getLogger(getClass());
    }

    /**
     * <p>
     * Lists the parsed results.
     * </p>
     * 
     * @return list of parsed {@link ReverseGeocodeResult} objects.
     */
    public List<ReverseGeocodeResult> results() {
        final ReverseGeocodeResult[] retResults = getResults().getResults();
        
        if (retResults == null) {
            return new ArrayList<>();
        }
       
        final List<ReverseGeocodeResult> tmp = new ArrayList<>(retResults.length);
        for (ReverseGeocodeResult reverseGeocodeAddress : retResults) {
            tmp.add(reverseGeocodeAddress);
        }

        return tmp;
    }

    @Override
    public List<ReverseGeocodeResult> listResults() {
        return results();
    }

    @Override
    public void completeBuild() {
        this.completeBuild(getByteArrayInternal());

    }

    @Override
    protected void completeBuild(byte[] input) {
        final Gson gson = new Gson();
        try {
            results = gson.fromJson(StringUtils.newStringUtf8(input),
                    ParsedReverseGeocodeData.class);
        } catch (Exception e) {
            getLog().debug("Error in fromJson {}", e);
        }

    }

    /**
     * <p>
     * The record count.
     * </p>
     * 
     * @return the record count
     */
    public Integer getCount() {
        return results.getCount();
    }

    /**
     * <p>
     * Return the query time.
     * </p>
     * 
     * @return the query time.
     */
    public Integer getQtime() {
        // Side note.WHY are we exposing this?? We are simply giving
        // SOMEBODY out there a stick to hit us with?
        return Double.valueOf(results.getqTime()).intValue();
    }

    /**
     * <p>
     * Return teh response code.
     * </p>
     * 
     * @return the response code
     */
    public Integer getResponseCode() {
        return results.getResponseCode();
    }

    /**
     * <p>
     * Return the resposne message.
     * </p>
     * 
     * @return the response message.
     */
    public String getResponseMessage() {
        return results.getResponseMessage();
    }

}
