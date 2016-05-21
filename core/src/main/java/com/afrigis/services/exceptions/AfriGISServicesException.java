/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.afrigis.services.exceptions;

import com.afrigis.services.internal.saas.api2.impl.ParsedErrorData;

/**
 * <p>
 * Main Exception type that can be raised by normal operation of this system.
 * </p>
 * <p>
 * It extends {@link RuntimeException} because to force the user to build
 * <code>try-catch</code> blocks everywhere is just stupid. Also more in line
 * with .Net efforts.
 * </p>
 * 
 * @author hendrikc
 * @author inarie
 */
public class AfriGISServicesException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = -8860642873566731606L;
    private int errorCode;
    private String errorMessage;
    private String errorSource;

    /**
     * Null constructor.
     */
    public AfriGISServicesException() {
        super();
    }

    /**
     * <p>
     * Constructor that accepts error details.
     * </p>
     * 
     * @param errorData
     *            the {@link ParsedErrorData} detailing the failure.
     */
    public AfriGISServicesException(ParsedErrorData errorData) {
        super(errorData.getMessage());
        this.errorCode = errorData.getStatusCode();
        this.errorMessage = errorData.getMessage();
        this.errorSource = errorData.getSource();
    }

    /**
     * <p>
     * See {@link RuntimeException#RuntimeException(String) RuntimeException}.
     * </p>
     * 
     * @param errorMes
     *            the error message
     */
    public AfriGISServicesException(String errorMes) {
        super(errorMes);
        this.errorMessage = errorMes;
    }

    /**
     * See {@link RuntimeException#RuntimeException(String, Throwable) RuntimeException}.
     * 
     * @param errorMes
     *            the error message
     * @param cause
     *            the cause of the error
     */
    public AfriGISServicesException(String errorMes, Throwable cause) {
        super(errorMes, cause);
        this.errorMessage = errorMes;
    }

    /**
     * @return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCodeIn
     *            the errorCode to set
     */
    public void setErrorCode(int errorCodeIn) {
        this.errorCode = errorCodeIn;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessageIn
     *            the errorMessage to set
     */
    public void setErrorMessage(String errorMessageIn) {
        this.errorMessage = errorMessageIn;
    }

    /**
     * @return the errorSource
     */
    public String getErrorSource() {
        return errorSource;
    }

    /**
     * @param errorSourceIn
     *            the errorSource to set
     */
    public void setErrorSource(String errorSourceIn) {
        this.errorSource = errorSourceIn;
    }

}
