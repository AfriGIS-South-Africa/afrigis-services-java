package com.afrigis.services.search.extension;

import com.afrigis.services.search.extension.census.Census;
import com.afrigis.services.Response;

/**
 * <p>
 * Response produced by service call to AfriGIS Service call
 * </p>
 *
 * @author Takalani
 */
public interface CensusResponse extends Response {

    public Census getResult();

    public int getCode();

    public String getMessage();

    public String getSource();
}
