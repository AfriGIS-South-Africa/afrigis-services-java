package com.afrigis.services.token;

import com.afrigis.services.Response;

/**
 * <p>
 * {@link Response} implementation produced when making a {@link TokenRequest}-based request.
 * </p>
 * @author hendrikc
 *
 */
public interface TokenResponse extends Response {
    
    /**
     * <p>
     * Returns the token that can be used for auto complete requests.
     * </p>
     * @return the token
     */
    String getToken();
}
