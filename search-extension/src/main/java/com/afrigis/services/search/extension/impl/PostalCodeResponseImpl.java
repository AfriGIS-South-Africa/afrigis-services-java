package com.afrigis.services.search.extension.impl;

import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.impl.AbstractResponse;
import com.afrigis.services.search.extension.PostalCodeResponse;
import com.afrigis.services.search.extension.postalcode.PostalCode;
import com.google.gson.Gson;
import java.util.List;
import org.apache.commons.codec.binary.StringUtils;

/**
 * <p>
 * PostalCodeResponseImpl implementation for PostalCodeResponse
 * </p>
 *
 * @author Takalani
 */
public class PostalCodeResponseImpl extends AbstractResponse implements PostalCodeResponse {

    private PostalCodeResponsePojo data;

    @Override
    protected void completeBuild(byte[] input) {
        if (isError()) {
            throw new AfriGISServicesException(getError());
        }
        final String utf8Str = StringUtils.newStringUtf8(input);

        data = new Gson().fromJson(utf8Str, PostalCodeResponsePojo.class);
    }

    /**
     * <p>
     * Not supported for postal code as it returns single object that has other
     * objects
     * </p>
     *
     * @param <T>
     * @return
     */
    @Override
    public <T> List<T> listResults() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public PostalCode getResult() {
        return data.result;
    }

    @Override
    public int getCode() {
        return data.code;
    }

    @Override
    public String getMessage() {
        return data.message;
    }

    @Override
    public String getSource() {
        return data.source;
    }

    /**
     * <p>
     * JSON from Postal Code AfriGIS service call returns parameters specified
     * in this POJO
     * </p>
     */
    private class PostalCodeResponsePojo {

        private PostalCode result;
        private int code;
        private String source;
        private String message;
    }

}
