package com.afrigis.services.internal.saas.api2.impl;

import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.internal.saas.api2.ParsedData;

/**
 * <p>
 * Object containing parsed errors.
 * </p>
 * <p>
 * Since the server returns 200 for error messages, recommend use of this HTTP
 * code rather than that returned from the server.
 * </p>
 * 
 * @author sydney
 * 
 */
public class ParsedErrorData implements ParsedData {

    private int statusCode;
    private String message;
    private String source;
    private AfriGISServicesException cause;

    /**
     * 
     * @return Status code of the error
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * 
     * @return The error message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 
     * @return Source of the message
     */
    public String getSource() {
        return source;
    }

    /**
     * 
     * @param statusCodeIn
     *            HTTP status code
     */
    public void setStatusCode(int statusCodeIn) {
        this.statusCode = statusCodeIn;
    }

    /**
     * 
     * @param errSauce
     *            Source of the error
     */
    public void setSource(String errSauce) {
        this.source = errSauce;
    }

    /**
     * 
     * @param errMsg
     *            Error message
     */
    public void setMessage(String errMsg) {
        this.message = errMsg;

    }

    /**
     * 
     * @param e1 the exception cause
     */
    public void setCause(AfriGISServicesException e1) {
        this.cause = e1;
    }

    /**
     * 
     * @return the cause of the exception
     */
    public AfriGISServicesException getCause() {
        return cause;
    }
}
