package com.afrigis.services.search.extension.intiendoLS.api2.params;

import com.afrigis.services.KeyValue;
import com.afrigis.services.Response;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.internal.saas.api2.AbstractParams;
import com.afrigis.services.search.extension.CensusGetType;
import com.afrigis.services.search.extension.impl.CensusResponseDownloadImpl;
import com.afrigis.services.search.extension.impl.CensusResponseImpl;
import java.util.Collection;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * Object contains service specific parameters for Census service call
 * </p>
 *
 * @author Takalani
 */
public class CensusParams extends SeoidLatLongAbstractParams {

    private CensusGetType censusGetType;

    public void setCensusGetType(CensusGetType censusGetType) {
        this.censusGetType = censusGetType;
    }

    public CensusGetType getCensusGetType() {
        return this.censusGetType;
    }

    /**
     * <p>
     * Get Census report using seoid
     * </p>
     *
     * @param email AfriGIS service client email making service call
     * @param seoid location identifier
     * @param censusGetType get JSON or PDF report
     */
    public CensusParams(String email, String seoid, CensusGetType censusGetType) {
        super(email, seoid);
        this.censusGetType = censusGetType;
    }

    /**
     *
     * <p>
     * Get Census report using latitude and longitude
     * </p>
     *
     * @param email AfriGIS service client email making service call
     * @param latitude identify location
     * @param longitude identify location
     * @param censusGetType get JSON or PDF report
     */
    public CensusParams(String email, String latitude, String longitude, CensusGetType censusGetType) {
        super(email, latitude, longitude);
        this.censusGetType = censusGetType;
    }

    /**
     * <p>
     * Service to call, this based on censusGetType
     * </p>
     *
     * @return String service to call
     */
    @Override
    public String getServiceName() {
        return censusGetType.toString();
    }

    @Override
    public Class<? extends Response> getResponseType() {
        return censusGetType == CensusGetType.JSON ? CensusResponseImpl.class : CensusResponseDownloadImpl.class;
    }

}
