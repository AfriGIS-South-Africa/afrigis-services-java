package com.afrigis.services.search.extension.impl;

import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.search.extension.postalcode.PostalCode;

/**
 ** <p>
 * PostalCodeResponseDownloadImpl extension of PostalCodeResponseImpl, only
 * makes getResult method not supported since download only deals with byte[]
 * </p>
 *
 * @author Takalani
 */
public class PostalCodeResponseDownloadImpl extends PostalCodeResponseImpl {

    @Override
    protected void completeBuild(byte[] input) {
        if (isError()) {
            throw new AfriGISServicesException(getError());
        }
    }

    /**
     * <p>
     * Not supported since the response is only byte[]
     * </p>
     *
     * @return throws UnsupportedOperationException
     */
    @Override
    public PostalCode getResult() {
        throw new UnsupportedOperationException("Method not supported for download.");
    }
}
