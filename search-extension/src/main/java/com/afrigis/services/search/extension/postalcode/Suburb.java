package com.afrigis.services.search.extension.postalcode;

/**
 * <p>
 * Represents Suburb obtained from AfriGIS Postal Code Service call
 * </p>
 *
 * @author Takalani
 */
public class Suburb {

    private String SuburbName;

    public String getSuburbName() {
        return this.SuburbName;
    }

    public void setSuburbName(String SuburbName) {
        this.SuburbName = SuburbName;
    }

    private Object StreetCode;

    public Object getStreetCode() {
        return this.StreetCode;
    }

    public void setStreetCode(Object StreetCode) {
        this.StreetCode = StreetCode;
    }

    private double AverageHouseholdIncome;

    public double getAverageHouseholdIncome() {
        return this.AverageHouseholdIncome;
    }

    public void setAverageHouseholdIncome(double AverageHouseholdIncome) {
        this.AverageHouseholdIncome = AverageHouseholdIncome;
    }

    private int Population;

    public int getPopulation() {
        return this.Population;
    }

    public void setPopulation(int Population) {
        this.Population = Population;
    }

    private double RoadsInKM;

    public double getRoadsInKM() {
        return this.RoadsInKM;
    }

    public void setRoadsInKM(double RoadsInKM) {
        this.RoadsInKM = RoadsInKM;
    }

    private int SectionalSchemeCount;

    public int getSectionalSchemeCount() {
        return this.SectionalSchemeCount;
    }

    public void setSectionalSchemeCount(int SectionalSchemeCount) {
        this.SectionalSchemeCount = SectionalSchemeCount;
    }

    private double CentroidX;

    public double getCentroidX() {
        return this.CentroidX;
    }

    public void setCentroidX(double CentroidX) {
        this.CentroidX = CentroidX;
    }

    private double CentroidY;

    public double getCentroidY() {
        return this.CentroidY;
    }

    public void setCentroidY(double CentroidY) {
        this.CentroidY = CentroidY;
    }

    private HouseholdIncome HouseholdIncome;

    public HouseholdIncome getHouseholdIncome() {
        return this.HouseholdIncome;
    }

    public void setHouseholdIncome(HouseholdIncome HouseholdIncome) {
        this.HouseholdIncome = HouseholdIncome;
    }
}
