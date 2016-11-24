/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrigis.services.addresssubmission;

import com.afrigis.services.Response;

/**
 *
 * @author Pieterv
 */


public interface AddressSubmissionResponse extends Response {

    /**
     * 
     * @return Descriptive message for the response code (String). Example: Invalid attribute.
     */
    String getResponseMessage();
    
    /**
     * 
     * @return Source of the data call.
     */
    String getSource();
    
   /**
     * 
     * @return Integer result code. 0 = success, error codes.
     */
    Integer getResponseCode();

}
