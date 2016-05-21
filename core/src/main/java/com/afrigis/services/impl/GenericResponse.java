package com.afrigis.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.afrigis.services.exceptions.AfriGISServicesException;

/**
 * <p>
 * Default "dumb" response.
 * </p>
 * <p>
 * It will essentially slurp in the server response, and store it as a byte
 * array. Retrieve it with {@link #getByteArray()}
 * </p>
 * <p>
 * No further attempt is made to interpret or parse the receive response entity.
 * </p>
 * 
 * @author hendrikc
 * @see GenericRequest
 *
 */
public class GenericResponse extends AbstractResponse {

    /**
     * <p>
     * This object has no specific entity object associated with it, so we have nothing to return.
     * </p>
     * @return an empty list
     */
    @Override
    public List listResults() {
        return new ArrayList<>();
    }

    @Override
    protected void completeBuild(byte[] input) {
       //Empty impl, we only give you bytes and a string
        if (isError()) { 
            throw new AfriGISServicesException(getError());
        }
        
    }

}
