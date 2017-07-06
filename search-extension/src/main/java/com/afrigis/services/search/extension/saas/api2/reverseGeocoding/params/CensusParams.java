/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrigis.services.search.extension.saas.api2.reverseGeocoding.params;

import com.afrigis.services.KeyValue;
import com.afrigis.services.Response;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.internal.saas.api2.AbstractParams;
import com.afrigis.services.search.extension.CensusGetType;
import com.afrigis.services.search.extension.impl.CensusResponseDownloadImpl;
import com.afrigis.services.search.extension.impl.CensusResponseImpl;
import java.util.Collection;

/**
 *
 * @author Takalani
 */
public class CensusParams extends AbstractParams {

    private static final String SEOID = "id";
    private static final String EMAIL = "email";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private String seoid;
    private String email;
    private String latitude;
    private String longitude;
    private CensusGetType censusGetType;

    public String getSeoid() {
        return seoid;
    }

    public void setSeoid(String seoid) {
        this.seoid = seoid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public CensusParams(String email, String seoid, CensusGetType censusGetType) {
        this.email = email;
        this.seoid = seoid;
        this.censusGetType = censusGetType;
    }

    public CensusParams(String email, String latitude, String longitude, CensusGetType censusGetType) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.email = email;
        this.censusGetType = censusGetType;
    }

    @Override
    protected void completeRequestParamList(Collection<KeyValue> input) {
        addKeyValParam(EMAIL, getEmail(), input);

        if (getSeoid() != null && getSeoid().trim().length() > 0) {
            addKeyValParam(SEOID, getSeoid(), input);
        } else {
            addKeyValParam(LATITUDE, getLatitude(), input);
            addKeyValParam(LONGITUDE, getLongitude(), input);
        }
    }

    @Override
    public String getServiceName() {
        return censusGetType == CensusGetType.JSON ? "intiendols.extn.census" : "intiendols.extn.census.download";
    }

    @Override
    public void validate() throws AfriGISServicesException {
        if (getEmail() == null || getEmail().trim().length() <= 0) {
            throw new AfriGISServicesException(
                    "Exceptions - missing mandatory parameter (email)");
        }
        // Valid email?
        if (!getEmail().matches("(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-zA-Z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
            throw new AfriGISServicesException(
                    "Exceptions - invalid email");
        }

        boolean missingSeoid = (getSeoid() == null || getSeoid().trim().length() <= 0);
        boolean missingLatitudeOrLongitude = (getLatitude() == null || getLatitude().trim().length() <= 0 || getLongitude() == null || getLongitude().trim().length() <= 0);
        if (missingSeoid && missingLatitudeOrLongitude) {
            throw new AfriGISServicesException(
                    "Exceptions - missing mandatory parameter (" + (missingSeoid ? "seoid" : "latitude or longitude") + ")");
        }
    }

    @Override
    public Class<? extends Response> getResponseType() {
        return censusGetType == CensusGetType.JSON ? CensusResponseImpl.class : CensusResponseDownloadImpl.class;
    }

}
