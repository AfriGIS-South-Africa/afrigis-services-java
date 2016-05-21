package com.afrigis.services.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afrigis.services.Response;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.internal.saas.api2.impl.ParsedErrorData;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <p>
 * Abstract implementation for {@link Response}.
 * </p>
 * 
 * @author hendrikc
 *
 */
public abstract class AbstractResponse implements Response {
    private static final int OK_200 = 200;
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private byte[] rawData;
    private int httpStatusCode;
    private String errMsg;

    private ParsedErrorData error;
    private int timesCalled;

    @Override
    public byte[] getByteArray() {
        return rawData != null ? rawData.clone() : null;
    }

    /**
     * 
     * @return the raw data array direct (NOT a copy)
     */
    protected byte[] getByteArrayInternal() {
        return rawData;
    }

    /**
     * <p>
     * Essentially returns TRUE if we received any suspect http status code.
     * </p>
     * <p>
     * Note that the SaaS server, at time of writing, does not seem to honour
     * HTTP status codes for response. For example, it will happily return 200
     * while authentication failed. SO just be aware this method might require
     * some more intelligence or something.
     * </p>
     * 
     * @return true if this is an error response
     */
    public boolean isError() {
        boolean ret = false;
        switch (httpStatusCode) {
            case HttpStatus.SC_ACCEPTED:
            case HttpStatus.SC_OK:
            case HttpStatus.SC_CREATED:
            case 0:
                ret = false;
                break;
            default:
                ret = true;
                break;

        }

        // Actual HTTP status code is not accurate reflection of response error
        // status
        return ret | error != null;
    }

    @Override
    public void consume(InputStream fin, int realHttpStatusCode) {
        this.httpStatusCode = realHttpStatusCode;
        final ByteArrayOutputStream fout = new ByteArrayOutputStream();
        try {
            IOUtils.copy(fin, fout);
            IOUtils.closeQuietly(fout);
            final String rawString = fout.toString(UTF8.name());
            rawData = fout.toByteArray();

            error = checkForErrorCondition(rawString);

            log().trace("Received from server:\n" + rawString);
            log().trace("Result: {}", realHttpStatusCode);

        } catch (Exception e) {
            realHttpStatusCode = HttpStatus.SC_INTERNAL_SERVER_ERROR;
            errMsg = e.getMessage();
            log().error(
                    "Unexpected exception caught while consuming server response",
                    e);
        }

    }

    /**
     * <p>
     * Complets the parsing of the received response.
     * </p>
     * 
     * @param input
     *            the input as received from server.
     */
    protected abstract void completeBuild(byte[] input);

    @Override
    public void completeBuild() {
        completeBuild(rawData);
    }

    /**
     * <p>
     * Attempts to deserialize the received server response.
     * </p>
     * 
     * @param <T>
     *            a class that implements {@link Response}
     * @param input
     *            a json string received from server side services
     * @param type
     *            the type of the {@link Response} implementation
     * @return the deserialized object
     */
    public static <T extends Response> T build(String input, Class<T> type) {
        final ParsedErrorData error = checkForErrorCondition(input);
        if (error != null) {
            throw new AfriGISServicesException(error);

        } else {
            final Gson gson = new Gson();
            final JsonParser parser = new JsonParser();
            try {

                final JsonObject jsonObject = (JsonObject) parser.parse(input);

                return gson.fromJson(jsonObject, type);
            } catch (Exception e) {
                LoggerFactory.getLogger(type)
                        .error("Error encountered in build", e);
                return null;
            }
        }
    }

    private static ParsedErrorData checkForErrorCondition(String rawString) {
        JSONObject parsed = null;
        try {
            parsed = new JSONObject(rawString);
        } catch (Exception e) {
            LoggerFactory.getLogger(AbstractResponse.class).warn(
                    "Failed to parse response as JSON - this is not expected. The received content is\n{}\n",
                    rawString, e);
        }
        try {
            if (parsed != null) {
                int httpStatusCode = 0;
                String errMsg = "";
                ParsedErrorData error;
                if (parsed.has("statusCode") && parsed.getInt("statusCode") != 200) {
                    httpStatusCode = parsed.getInt("statusCode");
                    errMsg = parsed.optString("message","No Message Available");
                }

                if (httpStatusCode != OK_200 && httpStatusCode != 0) {
                    error = new ParsedErrorData();
                    error.setMessage(errMsg);
                    error.setSource(parsed.has("source")
                            ? parsed.getString("source") : "Unknown");
                    error.setStatusCode(httpStatusCode);
                    return error;
                }
            }
        } catch (Exception e) {
            LoggerFactory.getLogger(AbstractResponse.class).warn(
                    "Treating the response as JSON failed, assuming there is much wrong",
                    e);
            return new ParsedErrorData();
        }
        return null;
    }

    /**
     * <p>
     * Retrieves error message if available.
     * </p>
     * 
     * @return the error message if available, otherwise empty string (
     *         <code>""</code>)
     */
    public String getErrorMessage() {
        return errMsg;
    }

    /**
     * <p>
     * Extracts the the HTTP status code if possible.
     * </p>
     * 
     * @return the HTTP status code if possible, otherwise returns 0 (zero)
     */
    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    @Override
    public ParsedErrorData getError() {

        return error;
    }

    @Override
    public void setError(ParsedErrorData receivedErr) {
        this.error = receivedErr;
    }

    @Override
    public void setTimesCalled(int timesCalledIn) {
        this.timesCalled = timesCalledIn;
    }

    @Override
    public int getTimesCalled() {
        return timesCalled;
    }

    /**
     * <p>
     * Give you the response as received from the server, unmodified.
     * </p>
     * <p>
     * Note, however, we construct the string using the raw byte array received
     * from the server, with UTF-8 encoding. This MIGHT screw up if the server
     * is not actually talking UTF-8
     * </p>
     * 
     * @return the response received from the server as a string, UTF-8 encoded.
     * @see String#String(byte[], Charset)
     * @see StringUtils#newStringUtf8(byte[])
     */
    @Override
    public String toString() {
        return StringUtils
                .newStringUtf8(rawData != null ? rawData : new byte[0]);
    }

    /**
     * 
     * @return {@link Logger} instance
     */
    protected Logger log() {
        return LoggerFactory.getLogger(getClass());
    }

}
