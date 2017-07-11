package com.afrigis.services.search.extension.postalcode;

import java.util.ArrayList;

/**
 * <p>
 * Represents Postal Code obtained from AfriGIS Postal Code Service call. Root
 * object from JSON response, contains other typed class object from JSON
 * response as variables.
 * </p>
 */
public class PostalCode {

    private String StreetCode;

    public String getStreetCode() {
        return this.StreetCode;
    }

    public void setStreetCode(String StreetCode) {
        this.StreetCode = StreetCode;
    }

    private String JsonGeometry;

    public String getJsonGeometry() {
        return this.JsonGeometry;
    }

    public void setJsonGeometry(String JsonGeometry) {
        this.JsonGeometry = JsonGeometry;
    }

    private double TotalArea;

    public double getTotalArea() {
        return this.TotalArea;
    }

    public void setTotalArea(double TotalArea) {
        this.TotalArea = TotalArea;
    }

    private double AverageHouseholdIncome;

    public double getAverageHouseholdIncome() {
        return this.AverageHouseholdIncome;
    }

    public void setAverageHouseholdIncome(double AverageHouseholdIncome) {
        this.AverageHouseholdIncome = AverageHouseholdIncome;
    }

    private int TotalPopulation;

    public int getTotalPopulation() {
        return this.TotalPopulation;
    }

    public void setTotalPopulation(int TotalPopulation) {
        this.TotalPopulation = TotalPopulation;
    }

    private int HouseHoldCount;

    public int getHouseHoldCount() {
        return this.HouseHoldCount;
    }

    public void setHouseHoldCount(int HouseHoldCount) {
        this.HouseHoldCount = HouseHoldCount;
    }

    private CommercialActivities CommercialActivities;

    public CommercialActivities getCommercialActivities() {
        return this.CommercialActivities;
    }

    public void setCommercialActivities(CommercialActivities CommercialActivities) {
        this.CommercialActivities = CommercialActivities;
    }

    private ArrayList<Suburb> Suburbs;

    public ArrayList<Suburb> getSuburbs() {
        return this.Suburbs;
    }

    public void setSuburbs(ArrayList<Suburb> Suburbs) {
        this.Suburbs = Suburbs;
    }
}
