/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrigis.services.internal.saas.api2.dataCorrectionSubmit.paresdObjects;

/**
 *
 * @author Pieterv
 */
public class SubmissionResult {

    private String clientID;
    private String ticketNumber;

    /**
     *
     * @return Client ID
     */
    public final String getClientID() {
        return clientID;
    }
    /**
     * 
     * @return Ticket Number
     */
    public final String getTicketNumber() {
        return ticketNumber;
    }
    /**
     * 
     * @return To String Client ID and Ticket Number
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("clientID=");
        builder.append(clientID);
        builder.append(", ticketNumber=");
        builder.append(ticketNumber);
        return builder.toString();
    }

}
