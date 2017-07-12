package com.afrigis.services.search.extension.impl;

import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.impl.AbstractResponse;
import com.afrigis.services.search.extension.SuburbRiskTotalResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.List;
import org.apache.commons.codec.binary.StringUtils;

/**
 * <p>
 * SuburbRiskProfileResponseImpl implementation for SuburbRiskProfileResponse
 * </p>
 *
 * @author Takalani
 */
public class SuburbRiskTotalResponseImpl extends AbstractResponse implements SuburbRiskTotalResponse {

    private SuburbRiskTotalResponsePojo data;

    @Override
    protected void completeBuild(byte[] input) {
        if (isError()) {
            throw new AfriGISServicesException(getError());
        }
        final String utf8Str = StringUtils.newStringUtf8(input);

        data = new Gson().fromJson(utf8Str, SuburbRiskTotalResponsePojo.class);
    }

    /**
     * <p>
     * Not supported for SuburbRiskProfile as it returns single object that has
     * other objects
     * </p>
     *
     * @param <T>
     * @return
     */
    @Override
    public <T> List<T> listResults() {
        throw new UnsupportedOperationException("Not supported.");
    }

    /**
     *
     * @return @throws Exception if there is no result or AfriGIS service call
     * response had any error
     */
    @Override
    public double getTotalRisk() throws Exception {
        try {
            return data.result.get("totalRisk").getAsDouble();
        } catch (NullPointerException e) {
            throw new Exception(getMessage());
        }
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
     * JSON from SuburbRiskProfile AfriGIS service call returns parameters
     * specified in this POJO
     * </p>
     */
    private class SuburbRiskTotalResponsePojo {

        private JsonObject result;
        private int code;
        private String message;
        private String source;
    }

}
