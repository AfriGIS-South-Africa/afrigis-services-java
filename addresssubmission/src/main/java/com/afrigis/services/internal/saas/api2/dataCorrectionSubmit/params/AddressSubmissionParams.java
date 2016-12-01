package com.afrigis.services.internal.saas.api2.dataCorrectionSubmit.params;

import java.security.InvalidParameterException;
import java.util.Collection;
import com.afrigis.services.AfriGISService;
import com.afrigis.services.KeyValue;
import com.afrigis.services.Response;
import com.afrigis.services.addresssubmission.AddressSubmissionResponse;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.internal.saas.api2.AbstractParams;

/**
 *
 * @author Pieterv
 */
public class AddressSubmissionParams extends AbstractParams {

    private static final String CLIENTID = "clientID";
    private static final String ADDRESS = "address";
    private static final String ADDITIONALINFO = "additionalInformation";

    private String clientID;
    private String address;
    private String additionalInformation;

    /**
     * Return ClientID
     *
     * @return ClientID
     */
    public String getClientID() {
        return clientID;
    }

    /**
     *
     * @param clientID (Required) your AfriGIS key.
     */
    public void setClientID(String clientID) {
        if (clientID == null || clientID.isEmpty()) {
            throw new InvalidParameterException(
                    "Missing mandatory parameter (ClientID)");
        }
        this.clientID = clientID;
    }

    /**
     * Return address
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address (Required) the address that could not be correctly
     * located.
     */
    public void setAddress(String address) {
        if (address == null || address.isEmpty()) {
            throw new InvalidParameterException(
                    "Missing mandatory parameter (Address)");
        }
        this.address = address;
    }

    /**
     * Return additionalInformation.
     *
     * @return additionalInformation.
     */
    public String getAdditionalInfomation() {
        return additionalInformation;
    }

    /**
     *
     * @param additionalInfo (Required) additional information that will help
     * the data team locate and verify the address.
     */
    public void setAdditionalInfomation(String additionalInfo) {
        if (additionalInfo == null || additionalInfo.isEmpty()) {
            throw new InvalidParameterException(
                    "Missing mandatory parameter (AdditionalInfomation)");
        }
        this.additionalInformation = additionalInfo;
    }

    @Override
    public String getServiceName() {
        return AfriGISService.dataCorrectionsSubmit.toString();
    }

    @Override
    public void validate() throws AfriGISServicesException {
        if (getClientID() == null || getClientID().trim().length() <= 0) {
            throw new AfriGISServicesException(
                    "Exceptions - missing mandatory parameter");
        }

        if (getAddress() == null || getAddress().trim().length() <= 0) {
            throw new AfriGISServicesException(
                    "Exceptions - missing mandatory parameter");
        }

        if (getAdditionalInfomation() == null || getAdditionalInfomation().trim().length() <= 0) {
            throw new AfriGISServicesException(
                    "Exceptions - missing mandatory parameter");
        }

    }

    @Override
    protected void completeRequestParamList(Collection<KeyValue> parameterMap) {

        if (getClientID() != null) {
            parameterMap.add(new KeyValue(
                    CLIENTID, getClientID()));
        }

        if (getAddress() != null) {
            parameterMap.add(new KeyValue(
                    ADDRESS, getAddress()));
        }

        if (getAdditionalInfomation() != null) {
            parameterMap.add(new KeyValue(
                    ADDITIONALINFO, getAdditionalInfomation()));
        }

    }

    @Override
    public Class<? extends Response> getResponseType() {
        return AddressSubmissionResponse.class;

    }
}
