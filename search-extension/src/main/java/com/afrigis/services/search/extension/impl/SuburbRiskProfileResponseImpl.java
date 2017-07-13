package com.afrigis.services.search.extension.impl;

import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.impl.AbstractResponse;
import com.afrigis.services.search.extension.SuburbRiskProfileResponse;
import com.afrigis.services.search.extension.risk.SuburbRiskProfile;
import com.google.gson.Gson;
import java.util.List;
import org.apache.commons.codec.binary.StringUtils;

/**
 * <p>
 * SuburbRiskProfileResponseImpl implementation for SuburbRiskProfileResponse
 * </p>
 *
 * @author Takalani
 */
public class SuburbRiskProfileResponseImpl extends AbstractResponse implements SuburbRiskProfileResponse {

    private SuburbRiskProfileResponsePojo data;

    @Override
    protected void completeBuild(byte[] input) {
        if (isError()) {
            throw new AfriGISServicesException(getError());
        }
        final String utf8Str = StringUtils.newStringUtf8(input);
//        System.err.println("somwhere: " + utf8Str);

        data = new Gson().fromJson(utf8Str, SuburbRiskProfileResponsePojo.class);
        if(data.result.getSuburbLevel().getNaturalDisasterRisk()!= null) {
            System.err.println("again and again");
        }
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

    @Override
    public SuburbRiskProfile getResult() {
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
     * JSON from SuburbRiskProfile AfriGIS service call returns parameters
     * specified in this POJO
     * </p>
     */
    private class SuburbRiskProfileResponsePojo {

        private SuburbRiskProfile result;
        private int code;
        private String message;
        private String source;
    }

}
