/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrigis.services.internal.saas.api2.dataCorrectionSubmit.paresdObjects;

import com.afrigis.services.internal.saas.api2.ParsedData;

/**
 *
 * @author Pieterv
 */
public class ParsedAddressSubmissionData implements ParsedData {

    private SubmissionResult result;
    private int responseCode;
    private String responseMessage;
    private String source;

    public SubmissionResult getResults() {
        return result != null ? result : null;
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
     * @return
     */
    public String getSource() {
        return source;
    }
}
