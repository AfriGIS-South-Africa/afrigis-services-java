package com.afrigis.services.geocode;

import java.util.List;

import com.afrigis.services.Response;

/**
 * <p>
 * Response object produced by {@link com.afrigis.services.ServiceCallFactory}
 * geocode service call}.
 * </p>
 * 
 * @author hendrikc
 *
 */
public interface AddressResponse extends Response {

    /**
     * Please see https://developers.afrigis.co.za/ .
     * 
     * @return the status
     */
    String getStatus();

    /**
     * Please see https://developers.afrigis.co.za/ .
     * 
     * @return the number of records
     */
    Integer getNumberOfRecords();

    /**
     * Please see https://developers.afrigis.co.za/ .
     * 
     * @return the qtime
     */
    Integer getQtime();

    @Override
    List<LocationResult> listResults();

}
