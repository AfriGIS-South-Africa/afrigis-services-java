package com.afrigis.services.addresssubmission.impl;

import com.afrigis.services.internal.saas.api2.dataCorrectionSubmit.paresdObjects.SubmissionResult;

/**
 *
 * @author Pieterv
 */
public class AddressSubmissionResultAdapter implements com.afrigis.services.addresssubmission.AddressSubmissionResult {

    private final SubmissionResult source;

    public AddressSubmissionResultAdapter(SubmissionResult theSource) {
        super();
        this.source = theSource;
    }

    @Override
    public String getClientID() {
        return source.getClientID();
    }

    @Override
    public String getTicketNumber() {
        return source.getTicketNumber();
    }

}
