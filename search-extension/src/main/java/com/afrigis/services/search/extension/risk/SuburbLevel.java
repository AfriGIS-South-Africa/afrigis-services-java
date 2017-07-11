package com.afrigis.services.search.extension.risk;

/**
 *
 * @author Takalani
 */
public class SuburbLevel {

    private SuburbAccessibility suburbAccessibility;

    public SuburbAccessibility getSuburbAccessibility() {
        return this.suburbAccessibility;
    }

    public void setSuburbAccessibility(SuburbAccessibility suburbAccessibility) {
        this.suburbAccessibility = suburbAccessibility;
    }

    private CrimeRisk crimeRisk;

    public CrimeRisk getCrimeRisk() {
        return this.crimeRisk;
    }

    public void setCrimeRisk(CrimeRisk crimeRisk) {
        this.crimeRisk = crimeRisk;
    }

    private SuburbNaturalDisasterRisk suburbNaturalDisasterRisk;

    public SuburbNaturalDisasterRisk getNaturalDisasterRisk() {
        return this.suburbNaturalDisasterRisk;
    }

    public void setSuburbNaturalDisasterRisk(SuburbNaturalDisasterRisk suburbNaturalDisasterRisk) {
        this.suburbNaturalDisasterRisk = suburbNaturalDisasterRisk;
    }

    private double total;

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
