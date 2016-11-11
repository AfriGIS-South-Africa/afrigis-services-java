package com.afrigis.services.geocode;

import java.security.InvalidParameterException;
import java.util.Collection;

import com.afrigis.services.AfriGISService;
import com.afrigis.services.KeyValue;
import com.afrigis.services.Response;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.geocode.impl.GeocodeDetailsResponseImpl;

/**
 * Represents a request for
 * <a href="https://developers.afrigis.co.za/portfolio/search/#details">details.
 * </a>
 * 
 * @author hendrikc
 *
 */
public class DetailsRequest extends AddressRequest {

    private static final String ILS_REFERENCE = "ils_reference";
    private String detailID;

    /**
     * Return Reference to obtain details of.
     * @return Reference to obtain details of
     */
    public String getDetailId() {
        return detailID;
    }

    /**
     * Constructor.
     * @param detailIDIn the id for which we need details.
     */
    public DetailsRequest(String detailIDIn) {
        super();
        this.setDetailID(detailIDIn);
    }

    /**
     * 
     * @param reference
     *            (Required) Reference to obtain details of
     */
    protected void setDetailID(String reference) {
        if (reference == null || reference.trim().length() <= 0) {
            throw new InvalidParameterException(
                    "Please provide a non-null, non-empty string as detailID");
        }
        this.detailID = reference;
    }

    @Override
    public String getServiceName() {
        return AfriGISService.geocodeServiceDetails.toString();
    }

    @Override
    protected void completeRequestParamList(Collection<KeyValue> input) {
        super.completeRequestParamList(input);
        
        KeyValue keyVal = new KeyValue(ILS_REFERENCE, getDetailId());
        if(!input.contains(keyVal)) {
            input.add(keyVal);
        }
    }

    @Override
    public void validate() throws AfriGISServicesException {
        if (detailID == null || detailID.trim().length() <= 0) {
            throw new AfriGISServicesException(
                    "Please provide a valid detailID for Detail requests");
        }

    }

    @Override
    public Class<? extends Response> getResponseType() {
        return GeocodeDetailsResponseImpl.class;
    }

}
