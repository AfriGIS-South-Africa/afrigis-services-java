package com.afrigis.services.internal.saas.api2.intiendoLS.params;

import java.security.InvalidParameterException;
import java.util.Collection;

import com.afrigis.services.AfriGISService;
import com.afrigis.services.KeyValue;
import com.afrigis.services.Response;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.geocode.impl.GeocodeResponseImpl;
import com.afrigis.services.internal.saas.api2.AbstractParams;

/**
 * <p>
 * Object that contains service specific parameters for the search call.
 * </p>
 * 
 * @author hendrikc
 * @author Sydney
 * 
 */
public class SearchParams extends AbstractParams {
    private static final String ILS_RESULT_COUNT = "ils_result_count";
    private static final String ILS_RESULT_START = "ils_result_start";
    private static final String ILS_LOCATION = "ils_location";
    private String searchText;
    private Integer resultStart = null;
    private Integer resultCount = null;

    /**
     * Return LocationResult to be searched for.
     * @return LocationResult to be searched for
     */
    public String getSearchText() {
        return searchText;
    }

    /**
     * 
     * @param searchTermText
     *            (Required) LocationResult to search
     */
    protected void setSearchText(String searchTermText) {
        if (searchTermText == null || searchTermText.trim().length() <= 0) {
            throw new InvalidParameterException(
                    "Missing mandatory parameter (SearchText)");
        }
        this.searchText = searchTermText;
    }

    /**
     * Return starting position from where results should be retrieved in the
     * whole result set. Typically used in results paging.
     * 
     * @return starting position for results
     */
    public Integer getFrom() {
        return resultStart;
    }

    /**
     * 
     * @param resultStartPosition
     *            (Required) Starting position from where results should be
     *            retrieved in the whole result set. Typically used in results
     *            paging
     */
    public void setFrom(int resultStartPosition) {
        this.resultStart = resultStartPosition;
    }

    /**
     * Return The maximum number of results to return per call.
     * 
     * @return The maximum number of results to return per call
     */
    public Integer getNumberOfRecords() {
        return resultCount;
    }

    /**
     * 
     * @param resultCountIn
     *            (Required) The maximum number of results to return per call
     */
    public void setNumberOfRecords(int resultCountIn) {
        this.resultCount = resultCountIn;
    }

    @Override
    public String getServiceName() {
        return AfriGISService.geocodeServiceAddress.toString();
    }

    @Override
    protected void completeRequestParamList(Collection<KeyValue> input) {
        addKeyValParam(ILS_LOCATION, getSearchText(), input);
        if (getFrom() != null) {
            addKeyValParam(ILS_RESULT_START, String.valueOf(getFrom()), input);
        }

        if (getNumberOfRecords() != null) {
            addKeyValParam(ILS_RESULT_COUNT,
                    String.valueOf(getNumberOfRecords()), input);
        }
    }

    @Override
    public void validate() throws AfriGISServicesException {
        if (getSearchText() == null || getSearchText().trim().length() <= 0) {
            throw new AfriGISServicesException(
                    "Exceptions - missing mandatory parameter");
        }

    }

    @Override
    public Class<? extends Response> getResponseType() {
        return GeocodeResponseImpl.class;

    }

}
