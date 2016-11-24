package com.afrigis.services.addresssubmission;

import com.afrigis.services.Request;
import com.afrigis.services.Response;
import com.afrigis.services.addresssubmission.impl.AddressSubmissionResponseImplAdapter;
import com.afrigis.services.internal.saas.api2.dataCorrectionSubmit.params.AddressSubmissionParams;

/**
 *
 * @author Pieterv
 */
public class AddressSubmissionRequest extends AddressSubmissionParams
        implements Request {
/**
 * 
 * @param clientID  your AfriGIS key.
 * @param address the address that could not be correctly located.
 * @param additionalInfomation additional information that will help the data team locate and verify the address.
 */
    public AddressSubmissionRequest(String clientID, String address,
            String additionalInfomation) {
        super();
        setAddress(address);
        setClientID(clientID);
        setAdditionalInfomation(additionalInfomation);
    }
/**
 * 
 * @return 
 */
    @Override
    public final Class<? extends Response> getResponseType() {
        return AddressSubmissionResponseImplAdapter.class;
    }
}
