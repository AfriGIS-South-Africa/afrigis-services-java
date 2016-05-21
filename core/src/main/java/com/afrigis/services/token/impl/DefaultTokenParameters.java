package com.afrigis.services.token.impl;

import java.util.Collection;

import com.afrigis.services.AfriGISService;
import com.afrigis.services.KeyValue;
import com.afrigis.services.Response;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.internal.saas.api2.AbstractParams;
import com.afrigis.services.token.TokenRequest;

/**
 * <p>
 * Default implementation of {@link TokenRequest}.
 * </p>
 * 
 * @author hendrikc
 *
 */
public class DefaultTokenParameters extends AbstractParams implements TokenRequest {

    @Override
    public String getServiceName() {
        return AfriGISService.tokenService.toString();
    }

    @Override
    public void validate() throws AfriGISServicesException {
    }

    @Override
    protected void completeRequestParamList(Collection<KeyValue> input) {
    }

    @Override
    public Class<? extends Response> getResponseType() {
        return DefaultTokenResponse.class;
    }

}
