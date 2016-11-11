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
     * @deprecated replaced by {@link #getCode()}
     * @return the status
     */
    @Deprecated
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
    
    /**
     * Please see https://developers.afrigis.co.za/ .
     * 
     * @return the code
     */
    Integer getCode();
    
    /**
     * Please see https://developers.afrigis.co.za/ .
     * 
     * @return the message
     */
    String getMessage();
    
    /**
     * Please see https://developers.afrigis.co.za/ .
     * 
     * @return the source
     */
    String getSource();

    @Override
    List<LocationResult> listResults();

}
