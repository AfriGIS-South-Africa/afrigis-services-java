package com.afrigis.services.search.extension.risk;

/**
 *
 * @author Takalani
 */
public class NadLevel {

    private Accessibility Accessibility;

    public Accessibility getAccessibility() {
        return this.Accessibility;
    }

    public void setAccessibility(Accessibility Accessibility) {
        this.Accessibility = Accessibility;
    }

    private NaturalDisasterRisk naturalDisasterRisk;

    public NaturalDisasterRisk getNaturalDisasterRisk() {
        return this.naturalDisasterRisk;
    }

    public void setNaturalDisasterRisk(NaturalDisasterRisk naturalDisasterRisk) {
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
