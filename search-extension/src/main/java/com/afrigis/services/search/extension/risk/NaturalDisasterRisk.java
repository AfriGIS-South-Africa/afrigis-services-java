package com.afrigis.services.search.extension.risk;

/**
 *
 * @author Takalani
 */
public class NaturalDisasterRisk {

    private double floodingRisk;

    public double getFloodingRisk() {
        return this.floodingRisk;
    }

    public void setFloodingRisk(double floodingRisk) {
        this.floodingRisk = floodingRisk;
    }

    private double soilRisk;

    public double getSoilRisk() {
        return this.soilRisk;
    }

    public void setSoilRisk(double soilRisk) {
        this.soilRisk = soilRisk;
    }

    private double withinFloodLine;

    public double getWithinFloodLine() {
        return this.withinFloodLine;
    }

    public void setWithinFloodLine(double withinFloodLine) {
        this.withinFloodLine = withinFloodLine;
    }

    private Object elevation;

    public Object getElevation() {
        return this.elevation;
    }

    public void setElevation(Object elevation) {
        this.elevation = elevation;
    }

    private double total;

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
