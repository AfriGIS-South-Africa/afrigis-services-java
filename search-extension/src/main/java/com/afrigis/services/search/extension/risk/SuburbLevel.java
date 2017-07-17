package com.afrigis.services.search.extension.risk;

/**
 *
 * @author Takalani
 */
public class SuburbLevel {

    private SuburbAccessibility accessibility;

    public SuburbAccessibility getAccessibility() {
        return this.accessibility;
    }

    public void setAccessibility(SuburbAccessibility accessibility) {
        this.accessibility = accessibility;
    }

    private CrimeRisk crimeRisk;

    public CrimeRisk getCrimeRisk() {
        return this.crimeRisk;
    }

    public void setCrimeRisk(CrimeRisk crimeRisk) {
        this.crimeRisk = crimeRisk;
    }

    private SuburbNaturalDisasterRisk naturalDisasterRisk;

    public SuburbNaturalDisasterRisk getNaturalDisasterRisk() {
        return this.naturalDisasterRisk;
    }

    public void setNaturalDisasterRisk(SuburbNaturalDisasterRisk naturalDisasterRisk) {
        this.naturalDisasterRisk = naturalDisasterRisk;
    }

    private double total;

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
