package com.afrigis.services.search.extension.risk;

/**
 *
 * @author Takalani
 */
public class SuburbAccessibility {

    private double policeStationAccessibilityRisk;

    public double getPoliceStationAccessibilityRisk() {
        return this.policeStationAccessibilityRisk;
    }

    public void setPoliceStationAccessibilityRisk(double policeStationAccessibilityRisk) {
        this.policeStationAccessibilityRisk = policeStationAccessibilityRisk;
    }

    private double fireStationAccessibilityRisk;

    public double getFireStationAccessibilityRisk() {
        return this.fireStationAccessibilityRisk;
    }

    public void setFireStationAccessibilityRisk(double fireStationAccessibilityRisk) {
        this.fireStationAccessibilityRisk = fireStationAccessibilityRisk;
    }

    private double averageTravelTimeToPoliceStationInMinutes;

    public double getAverageTravelTimeToPoliceStationInMinutes() {
        return this.averageTravelTimeToPoliceStationInMinutes;
    }

    public void setAverageTravelTimeToPoliceStationInMinutes(double averageTravelTimeToPoliceStationInMinutes) {
        this.averageTravelTimeToPoliceStationInMinutes = averageTravelTimeToPoliceStationInMinutes;
    }

    private double averageTravelTimeToFireStationInMinutes;

    public double getAverageTravelTimeToFireStationInMinutes() {
        return this.averageTravelTimeToFireStationInMinutes;
    }

    public void setAverageTravelTimeToFireStationInMinutes(double averageTravelTimeToFireStationInMinutes) {
        this.averageTravelTimeToFireStationInMinutes = averageTravelTimeToFireStationInMinutes;
    }

    private double total;

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
