package com.afrigis.services.search.extension.risk;

/**
 *
 * @author Takalani
 */
public class Accessibility {

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

    private double travelTimeToPoliceStation;

    public double getTravelTimeToPoliceStation() {
        return this.travelTimeToPoliceStation;
    }

    public void setTravelTimeToPoliceStation(double travelTimeToPoliceStation) {
        this.travelTimeToPoliceStation = travelTimeToPoliceStation;
    }

    private double travelTimeToFireStation;

    public double getTravelTimeToFireStation() {
        return this.travelTimeToFireStation;
    }

    public void setTravelTimeToFireStation(double travelTimeToFireStation) {
        this.travelTimeToFireStation = travelTimeToFireStation;
    }

    private double total;

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
