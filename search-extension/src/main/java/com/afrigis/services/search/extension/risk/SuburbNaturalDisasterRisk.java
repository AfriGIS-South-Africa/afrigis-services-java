package com.afrigis.services.search.extension.risk;

/**
 *
 * @author Takalani
 */
public class SuburbNaturalDisasterRisk {

    private double floodingRisk;

    public double getFloodingRisk() {
        return this.floodingRisk;
    }

    public void setFloodingRisk(double floodingRisk) {
        this.floodingRisk = floodingRisk;
    }

    private double positionToFloodLines;

    public double getPositionToFloodLines() {
        return this.positionToFloodLines;
    }

    public void setPositionToFloodLines(double positionToFloodLines) {
        this.positionToFloodLines = positionToFloodLines;
    }

    private double lightningRisk;

    public double getLightningRisk() {
        return this.lightningRisk;
    }

    public void setLightningRisk(double lightningRisk) {
        this.lightningRisk = lightningRisk;
    }

    private double lightningFlashDensityPerHundredSquareMeter;

    public double getLightningFlashDensityPerHundredSquareMeter() {
        return this.lightningFlashDensityPerHundredSquareMeter;
    }

    public void setLightningFlashDensityPerHundredSquareMeter(double lightningFlashDensityPerHundredSquareMeter) {
        this.lightningFlashDensityPerHundredSquareMeter = lightningFlashDensityPerHundredSquareMeter;
    }

    private double hailRisk;

    public double getHailRisk() {
        return this.hailRisk;
    }

    public void setHailRisk(double hailRisk) {
        this.hailRisk = hailRisk;
    }

    private double HailOccurancePerYear;

    public double getHailOccurancePerYear() {
        return this.HailOccurancePerYear;
    }

    public void setHailOccurancePerYear(double HailOccurancePerYear) {
        this.HailOccurancePerYear = HailOccurancePerYear;
    }

    private double soilRisk;

    public double getSoilRisk() {
        return this.soilRisk;
    }

    public void setSoilRisk(double soilRisk) {
        this.soilRisk = soilRisk;
    }

    private double total;

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
