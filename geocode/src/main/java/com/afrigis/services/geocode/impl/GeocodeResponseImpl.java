package com.afrigis.services.geocode.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.StringUtils;

import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.geocode.AddressResponse;
import com.afrigis.services.geocode.LocationResult;
import com.afrigis.services.impl.AbstractResponse;
import com.afrigis.services.internal.saas.api2.intiendoLS.parsedData.SearchResult;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Default implemetnation for {@link AddressResponse}.
 * 
 * @author hendrikc
 *
 */
public class GeocodeResponseImpl extends AbstractResponse
        implements AddressResponse {

    private SearchResponsePojo data;

    @Override
    public List<LocationResult> listResults() {
        final List<LocationResult> transformed =
                new ArrayList<LocationResult>();

        final SearchResult[] results =
                getResults() != null ? getResults() : new SearchResult[0];

        for (SearchResult searchResult : results) {
            transformed.add(searchResult);
        }

        return transformed;
    }

    @Override
    public void completeBuild(byte[] input) {
        if (isError()) {
            throw new AfriGISServicesException(getError());
        }
        final String utf8Str = StringUtils.newStringUtf8(input);

        final Gson gson = new Gson();

        data = gson.fromJson(utf8Str, SearchResponsePojo.class);
    }

    /**
     * 
     * @return Array of query results
     */
    public SearchResult[] getResults() {
        return data.results != null ? data.results.clone() : null;
    }

    /**
     * 
     * @return Status of the query, e.g. OK
     */
    public String getStatus() {
        return data.status;
    }

    /**
     * 
     * @return Time taken by the query
     */
    public Integer getQtime() {
        return data.qtime;
    }

    @Override
    public Integer getNumberOfRecords() {
        return data.numberOfRecords;
    }

    private class SearchResponsePojo {
        private SearchResult[] results;
        private String status;
        @SerializedName("number_of_records")
        private Integer numberOfRecords;
        private Integer qtime;
    }

}
