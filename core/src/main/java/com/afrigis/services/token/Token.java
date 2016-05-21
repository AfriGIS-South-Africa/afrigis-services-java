package com.afrigis.services.token;

/**
 * <p>
 * Please see https://developers.afrigis.co.za/portfolio/auto-complete-api/ .
 * </p>
 * @author hendrikc
 *
 */
public interface Token {
    
    /**
     * <p>
     * Returns the actual token wrapped by this object.
     * </p>
     * @return the actual token wrapped by this object
     */
    String getToken();
}
