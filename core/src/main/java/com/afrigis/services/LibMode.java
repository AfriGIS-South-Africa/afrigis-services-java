package com.afrigis.services;

/**
 * <p>
 * Small enum to encode the possible values for the <code>libmode</code> meta
 * info we have to add.
 * </p>
 * 
 * @author hendrikc
 *
 */
public enum LibMode {
    /**
     * <p>
     * Indicates the library calls are being used in synchronous mode.
     * </p>
     */
    sync,

    /**
     * <p>
     * Indicates the library calls are being used in asynchronous mode.
     * </p>
     */
    async,

    /**
     * <p>
     * Indicates that the library was just used to generate a URL. An external code base executed the URL.
     * </p>
     */
    url;
}
