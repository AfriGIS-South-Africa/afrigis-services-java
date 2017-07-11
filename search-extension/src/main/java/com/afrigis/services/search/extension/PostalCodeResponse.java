package com.afrigis.services.search.extension;

import com.afrigis.services.Response;
import com.afrigis.services.search.extension.postalcode.PostalCode;

/**
 * <p>
 * Response produced by service call to AfriGIS Service call
 * </p>
 *
 * @author Takalani
 */
public interface PostalCodeResponse extends Response {

    public PostalCode getResult();
}
