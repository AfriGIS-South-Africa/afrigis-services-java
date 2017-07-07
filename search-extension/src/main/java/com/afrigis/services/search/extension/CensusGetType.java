/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrigis.services.search.extension;

/**
 *
 * Report types for census
 *
 */
public enum CensusGetType {

    /**
     * <p>
     * Enum for the <code>intiendols.extn.census</code> call to get Census json
     * response
     * <br> Please see https://developers.afrigis.co.za/portfolio/census/
     * </p>
     */
    JSON("intiendols.extn.census"),
    /**
     * <p>
     * Enum for the <code>intiendols.extn.census.download</code> call to get pdf
     * byte[]
     * <br> Please see https://developers.afrigis.co.za/portfolio/census/
     * </p>
     */
    PDF("intiendols.extn.census.download");

    private final String serviceId;

    CensusGetType(String id) {
        serviceId = id;
    }

    @Override
    public String toString() {
        return serviceId;
    }
}
