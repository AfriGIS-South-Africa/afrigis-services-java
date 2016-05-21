package com.afrigis.services.internal.saas.api2.intiendoLS.params;

import java.util.Collection;

import com.afrigis.services.AfriGISService;
import com.afrigis.services.KeyValue;
import com.afrigis.services.Response;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.internal.saas.api2.AbstractParams;

/**
 * Object that contains service specific parameters for the getDetails call.
 * 
 * @author Sydney
 * @deprecated not for external consumption, use
 *             {@link com.afrigis.services.geocode.DetailsRequest
 *             DetailsRequest} instead
 * 
 */
@Deprecated
public class DetailParams extends AbstractParams {
    private static final String ILS_REFERENCE = "ils_reference";
    private String reference;

    /**
     * 
     * @return Reference to obtain details of
     */
    public String getReference() {
        return reference;
    }

    /**
     * 
     * @param ref
     *            (Required) Reference to obtain details of
     */
    public void setReference(String ref) {
        this.reference = ref;
    }

    @Override
    public String getServiceName() {
        return AfriGISService.geocodeServiceDetails.toString();
    }

    @Override
    protected void completeRequestParamList(Collection<KeyValue> input) {
        input.add(new KeyValue(ILS_REFERENCE, getReference()));

    }

    @Override
    public void validate() throws AfriGISServicesException {
        if (reference == null || reference.trim().length() <= 0) {
            throw new AfriGISServicesException(
                    "Please provide a valid reference for Detail requests");
        }

    }

    @Override
    public Class<? extends Response> getResponseType() {
        // TODO Auto-generated method stub
        return null;
    }

}
