/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrigis.services.search.extension.impl;

import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.impl.AbstractResponse;
import com.afrigis.services.search.extension.Census;
import com.afrigis.services.search.extension.CensusResponse;
import com.google.gson.Gson;
import java.util.List;
import org.apache.commons.codec.binary.StringUtils;

/**
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

    @Override
    public <T> List<T> listResults() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Census getResult() {
        return data.result;
    }

    private class CensusResponsePojo {

        private Census result;
        private Integer code;
        private String source;
    }

}
