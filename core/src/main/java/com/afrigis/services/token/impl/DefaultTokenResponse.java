package com.afrigis.services.token.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.codec.binary.StringUtils;

import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.impl.AbstractResponse;
import com.afrigis.services.internal.saas.api2.intiendoLS.parsedData.ParsedTokenData;
import com.afrigis.services.token.Token;
import com.afrigis.services.token.TokenResponse;
import com.google.gson.Gson;

/**
 * <p>
 * Default implementation of {@link TokenResponse}.
 * </p>
 * @author hendrikc
 *
 */
public class DefaultTokenResponse extends AbstractResponse
        implements TokenResponse {

    private ParsedTokenData results;

    @Override
    public List<Token> listResults() {
        final Token toks = getParsedToken();
        final List<Token> tmpList = Arrays.asList(toks);
        return tmpList;
    }

    /**
     * 
     * @return Object containing the result of the query, IF there was no error
     */
    public ParsedTokenData getParsedToken() {
        return results;
    }

    @Override
    public String getToken() {
        return getParsedToken().getToken();
    }

    @Override
    protected void completeBuild(byte[] input) {
        if (isError()) {
            throw new AfriGISServicesException(getError());
        }
        final Gson gson = new Gson();

        try {
            results = gson.fromJson(StringUtils.newStringUtf8(input),
                    ParsedTokenData.class);
        } catch (Exception e) {
            log().debug("Error in fromJson {}", e);
        }

    }

}
