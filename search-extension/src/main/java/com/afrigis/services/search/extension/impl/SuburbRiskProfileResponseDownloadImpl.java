package com.afrigis.services.search.extension.impl;

import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.search.extension.risk.SuburbRiskProfile;

/**
 ** <p>
 * SuburbRiskProfileResponseDownloadImpl extension of PostalCodeResponseImpl,
 * only makes getResult method not supported since download only deals with
 * byte[]
 * </p>
 *
 * @author Takalani
 */
public class SuburbRiskProfileResponseDownloadImpl extends SuburbRiskProfileResponseImpl {

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
    public SuburbRiskProfile getResult() {
        throw new UnsupportedOperationException("Method not supported for download.");
    }
}
