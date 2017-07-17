package com.afrigis.services.search.extension.census;

/**
 * <p>
 * Represents DwellingDetails obtained from AfriGIS Census Service call
 * </p>
 *
 * @author Takalani
 */
public class DwellingDetails {

    private int CaravanTent;

    public int getCaravanTent() {
        return this.CaravanTent;
    }

    public void setCaravanTent(int CaravanTent) {
        this.CaravanTent = CaravanTent;
    }

    private int ClusterHouse;

    public int getClusterHouse() {
        return this.ClusterHouse;
    }

    public void setClusterHouse(int ClusterHouse) {
        this.ClusterHouse = ClusterHouse;
    }

    private int Flat;

    public int getFlat() {
        return this.Flat;
    }

    public void setFlat(int Flat) {
        this.Flat = Flat;
    }

    private int House;

    public int getHouse() {
        return this.House;
    }

    public void setHouse(int House) {
        this.House = House;
    }

    private int HouseInBackyard;

    public int getHouseInBackyard() {
        return this.HouseInBackyard;
    }

    public void setHouseInBackyard(int HouseInBackyard) {
        this.HouseInBackyard = HouseInBackyard;
    }

    private int InformalDwelling;

    public int getInformalDwelling() {
        return this.InformalDwelling;
    }

    public void setInformalDwelling(int InformalDwelling) {
        this.InformalDwelling = InformalDwelling;
    }

    private int InformalDwellingInBackyard;

    public int getInformalDwellingInBackyard() {
        return this.InformalDwellingInBackyard;
    }

    public void setInformalDwellingInBackyard(int InformalDwellingInBackyard) {
        this.InformalDwellingInBackyard = InformalDwellingInBackyard;
    }

    private int NotApplicable;

    public int getNotApplicable() {
        return this.NotApplicable;
    }

    public void setNotApplicable(int NotApplicable) {
        this.NotApplicable = NotApplicable;
    }

    private int Other;

    public int getOther() {
        return this.Other;
    }

    public void setOther(int Other) {
        this.Other = Other;
    }

    private int RoomOnAProperty;

    public int getRoomOnAProperty() {
        return this.RoomOnAProperty;
    }

    public void setRoomOnAProperty(int RoomOnAProperty) {
        this.RoomOnAProperty = RoomOnAProperty;
    }

    private int SemiDetachedHouse;

    public int getSemiDetachedHouse() {
        return this.SemiDetachedHouse;
    }

    public void setSemiDetachedHouse(int SemiDetachedHouse) {
        this.SemiDetachedHouse = SemiDetachedHouse;
    }

    private int Townhouse;

    public int getTownhouse() {
        return this.Townhouse;
    }

    public void setTownhouse(int Townhouse) {
        this.Townhouse = Townhouse;
    }

    private int TraditionalDwelling;

    public int getTraditionalDwelling() {
        return this.TraditionalDwelling;
    }

    public void setTraditionalDwelling(int TraditionalDwelling) {
        this.TraditionalDwelling = TraditionalDwelling;
    }

    private int TraditionalResidential;

    public int getTraditionalResidential() {
        return this.TraditionalResidential;
    }

    public void setTraditionalResidential(int TraditionalResidential) {
        this.TraditionalResidential = TraditionalResidential;
    }

    private int Unspecified;

    public int getUnspecified() {
        return this.Unspecified;
    }

    public void setUnspecified(int Unspecified) {
        this.Unspecified = Unspecified;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("DwellingDetails{CaravanTent=");
        builder.append(CaravanTent);
        builder.append(", ClusterHouse=");
        builder.append(ClusterHouse);
        builder.append(", Flat=");
        builder.append(Flat);
        builder.append(", House=");
        builder.append(House);
        builder.append(", HouseInBackyard=");
        builder.append(HouseInBackyard);
        builder.append(", InformalDwelling=");
        builder.append(InformalDwelling);
        builder.append(", InformalDwellingInBackyard=");
        builder.append(InformalDwellingInBackyard);
        builder.append(", NotApplicable=");
        builder.append(NotApplicable);
        builder.append(", Other=");
        builder.append(Other);
        builder.append(", RoomOnAProperty=");
        builder.append(RoomOnAProperty);
        builder.append(", SemiDetachedHouse=");
        builder.append(SemiDetachedHouse);
        builder.append(", Townhouse=");
        builder.append(Townhouse);
        builder.append(", TraditionalDwelling=");
        builder.append(TraditionalDwelling);
        builder.append(", TraditionalResidential=");
        builder.append(TraditionalResidential);
        builder.append(", Unspecified=");
        builder.append(Unspecified);
        builder.append("}");
        return builder.toString();
    }

}
