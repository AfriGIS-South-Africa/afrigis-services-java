package com.afrigis.services.internal.saas.api2.intiendoLS.parsedData;

import com.afrigis.services.internal.saas.api2.ParsedData;
import com.afrigis.services.token.Token;

/**
 * <p>
 * Token object, containing the token for use in auto complete calls.
 * </p>
 * <p>
 * Token lasts for 50 calls, or 10 minutes.
 * </p>
 * 
 * @author sydney
 *
 */
public class ParsedTokenData implements ParsedData, Token {
    private String token;

    /**
     * 
     * @return Token for use with auto complete
     */
    public String getToken() {
        return token;
    }
}
