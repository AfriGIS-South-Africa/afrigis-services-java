package com.afrigis.services.search.extension;

/**
 * <p>
 * Represents WaterDetails obtained from AfriGIS Census Service call
 * </p>
 *
 * @author Takalani
 */
public class WaterDetails {

    private int Borehole;

    public int getBorehole() {
        return this.Borehole;
    }

    public void setBorehole(int Borehole) {
        this.Borehole = Borehole;
    }

    private int DamPoolStagnantWater;

    public int getDamPoolStagnantWater() {
        return this.DamPoolStagnantWater;
    }

    public void setDamPoolStagnantWater(int DamPoolStagnantWater) {
        this.DamPoolStagnantWater = DamPoolStagnantWater;
    }

    private int Other;

    public int getOther() {
        return this.Other;
    }

    public void setOther(int Other) {
        this.Other = Other;
    }

    private int RainWaterTank;

    public int getRainWaterTank() {
        return this.RainWaterTank;
    }

    public void setRainWaterTank(int RainWaterTank) {
        this.RainWaterTank = RainWaterTank;
    }

    private int RiverStream;

    public int getRiverStream() {
        return this.RiverStream;
    }

    public void setRiverStream(int RiverStream) {
        this.RiverStream = RiverStream;
    }

    private int ServicedWater;

    public int getServicedWater() {
        return this.ServicedWater;
    }

    public void setServicedWater(int ServicedWater) {
        this.ServicedWater = ServicedWater;
    }

    private int Spring;

    public int getSpring() {
        return this.Spring;
    }

    public void setSpring(int Spring) {
        this.Spring = Spring;
    }

    private int TotalHouseholds;

    public int getTotalHouseholds() {
        return this.TotalHouseholds;
    }

    public void setTotalHouseholds(int TotalHouseholds) {
        this.TotalHouseholds = TotalHouseholds;
    }

    private int WaterTanker;

    public int getWaterTanker() {
        return this.WaterTanker;
    }

    public void setWaterTanker(int WaterTanker) {
        this.WaterTanker = WaterTanker;
    }

    private int WaterVendor;

    public int getWaterVendor() {
        return this.WaterVendor;
    }

    public void setWaterVendor(int WaterVendor) {
        this.WaterVendor = WaterVendor;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("WaterDetails{Borehole=");
        builder.append(Borehole);
        builder.append(", DamPoolStagnantWater=");
        builder.append(DamPoolStagnantWater);
        builder.append(", Other=");
        builder.append(Other);
        builder.append(", RainWaterTank=");
        builder.append(RainWaterTank);
        builder.append(", RiverStream=");
        builder.append(RiverStream);
        builder.append(", ServicedWater=");
        builder.append(ServicedWater);
        builder.append(", Spring=");
        builder.append(Spring);
        builder.append(", TotalHouseholds=");
        builder.append(TotalHouseholds);
        builder.append(", WaterTanker=");
        builder.append(WaterTanker);
        builder.append(", WaterVendor=");
        builder.append(WaterVendor);
        builder.append("}");
        return builder.toString();
    }

}
