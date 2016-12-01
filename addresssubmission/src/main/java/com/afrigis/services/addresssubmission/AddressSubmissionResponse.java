package com.afrigis.services.addresssubmission;

import com.afrigis.services.Response;

/**
 *
 * @author Pieterv
 */
public interface AddressSubmissionResponse extends Response {

    /**
     *
     * @return Client ID your AfriGIS key.
     */
    String getClientID();

    /**
     *
     * @return Ticket number the reference number in the internal AfriGIS
     * ticketing system with which you can track the progress of the Address
     * Submission.
     */
    String getTicketNumber();
   
  
}
