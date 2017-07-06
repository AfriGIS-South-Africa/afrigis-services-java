/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrigis.services.search.extension.impl;

import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.search.extension.Census;

/**
 *
 * @author Takalani
 */
public class CensusResponseDownloadImpl extends CensusResponseImpl {

    @Override
    protected void completeBuild(byte[] input) {
        if (isError()) {
            throw new AfriGISServicesException(getError());
        }
    }

    @Override
    public Census getResult() {
        throw new UnsupportedOperationException("Method not supported for download.");
    }
}
