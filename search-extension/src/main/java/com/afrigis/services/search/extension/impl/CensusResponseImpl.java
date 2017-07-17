package com.afrigis.services.search.extension.impl;

import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.impl.AbstractResponse;
import com.afrigis.services.search.extension.census.Census;
import com.afrigis.services.search.extension.CensusResponse;
import com.google.gson.Gson;
import java.util.List;
import org.apache.commons.codec.binary.StringUtils;

/**
 * <p>
 * CensusResponseImpl implementation for CensusResponse
 * </p>
 *
 * @author Takalani
 */
public class CensusResponseImpl extends AbstractResponse implements CensusResponse {

    private CensusResponsePojo data;

    @Override
    protected void completeBuild(byte[] input) {
        if (isError()) {
            throw new AfriGISServicesException(getError());
        }
        final String utf8Str = StringUtils.newStringUtf8(input);

        data = new Gson().fromJson(utf8Str, CensusResponsePojo.class);
    }

    /**
     * <p>
     * Not supported for Census as it returns single object that has other
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
    public Census getResult() {
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
     * JSON from Census AfriGIS service call returns parameters specified in
     * this POJO
     * </p>
     */
    private class CensusResponsePojo {

        private Census result;
        private int code;
        private String message;
        private String source;
    }

}
