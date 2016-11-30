package com.afrigis.services.addresssubmission.impl;

import com.afrigis.services.internal.saas.api2.dataCorrectionSubmit.paresdObjects.SubmissionResult;
import com.afrigis.services.addresssubmission.AddressSubmissionResult;

/**
 *
 * @author Pieterv
 */
public class AddressSubmissionResultImpl implements AddressSubmissionResult {

    private final SubmissionResult source;

    /**
     * 
     * @param theSource SubmissionResult
     */
    public AddressSubmissionResultImpl(SubmissionResult theSource) {
        super();
        this.source = theSource;
    }

    /**
     * 
     * @return Client ID
     */
    @Override
    public String getClientID() {
        return source.getClientID();
    }
    /**
     * 
     * @return Ticket Number
     */
    @Override
    public String getTicketNumber() {
        return source.getTicketNumber();
    }

}
