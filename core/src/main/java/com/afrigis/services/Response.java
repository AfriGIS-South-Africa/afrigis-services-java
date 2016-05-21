package com.afrigis.services;

import java.io.InputStream;
import java.util.List;

import com.afrigis.services.internal.saas.api2.impl.ParsedErrorData;

/**
 * <p>
 * Main interface for objects that act as response handlers.
 * </p>
 * 
 * @author hendrikc
 *
 */
public interface Response {

    /**
     * <p>
     * Returns a copy of the entire raw byte stream as received from the server.
     * </p>
     * 
     * @return a copy of the entire raw byte stream as received from the server 
     */
    byte[] getByteArray();

    /**
     * <p>
     * A list of deserialized objects based on the results obtained from the
     * service.
     * </p>
     * 
     * @param <T>
     *            the type of the parsed objects returned in the list
     * @return a list of objects of type T, deserialized from the service
     *         response
     */
    <T> List<T> listResults();

    /**
     * <p>
     * Used when re-trying requests under certain conditions.
     * </p>
     * TODO WHY is this in the response objects? Why not {@link Request}?
     * 
     * @param i
     *            the number of times called
     */
    void setTimesCalled(int i);

    /**
     * <p>
     * If the server responded with something that looks like an error, this method will receive the {@link ParsedErrorData}.
     * </p>
     * @param ped the processed error data
     */
    void setError(ParsedErrorData ped);

    /**
     * <p>
     * Used when we have to retry requests under certain conditions.
     * </p>
     * TODO WHY is this in the response objects? Why not {@link Request}?
     * 
     * @return the number of times the request has been called
     */
    int getTimesCalled();

    /**
     * <p>
     * Receives the input stream from the server, and is responsible for copying
     * data into local memory, checking for error conditions and so forth.
     * </p>
     * <p>
     * After calling this method, clients should be able to rely on the
     * following post conditions:
     * </p>
     * <ul>
     * <li>{@link #getByteArray()} should return non-empty, non-null array</li>
     * <li>{@link #getError()} will return NULL only if no errror condition was
     * detected in the response (NOT only based on the HTTP status line code)
     * </li>
     * </ul>
     * 
     * @param fin
     *            input stream to read from
     * @param statusCode
     *            the HTTP Status code as received
     */
    void consume(InputStream fin, int statusCode);

    /**
     * <p>
     * If things have gone wrong is an understandable way, this field will be
     * populated.
     * </p>
     * 
     * @return information about the error encountered.
     * @see ParsedErrorData
     */
    ParsedErrorData getError();

    /**
     * <p>
     * Called to finalize the parsing of the response and so forth.
     * </p>
     */
    void completeBuild();
}
