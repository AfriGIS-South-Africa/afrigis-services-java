package com.afrigis.services.search.extension;

/**
 * <p>
 * Represents LandUseDetails obtained from AfriGIS Census Service call
 * </p>
 *
 * @author Takalani
 */
public class LandUseDetails {

    private int Collective;

    public int getCollective() {
        return this.Collective;
    }

    public void setCollective(int Collective) {
        this.Collective = Collective;
    }

    private int Commercial;

    public int getCommercial() {
        return this.Commercial;
    }

    public void setCommercial(int Commercial) {
        this.Commercial = Commercial;
    }

    private int Farms;

    public int getFarms() {
        return this.Farms;
    }

    public void setFarms(int Farms) {
        this.Farms = Farms;
    }

    private int FormalResidential;

    public int getFormalResidential() {
        return this.FormalResidential;
    }

    public void setFormalResidential(int FormalResidential) {
        this.FormalResidential = FormalResidential;
    }

    private int Industrial;

    public int getIndustrial() {
        return this.Industrial;
    }

    public void setIndustrial(int Industrial) {
        this.Industrial = Industrial;
    }

    private int InformalResidential;

    public int getInformalResidential() {
        return this.InformalResidential;
    }

    public void setInformalResidential(int InformalResidential) {
        this.InformalResidential = InformalResidential;
    }

    private int ParksAndRecreation;

    public int getParksAndRecreation() {
        return this.ParksAndRecreation;
    }

    public void setParksAndRecreation(int ParksAndRecreation) {
        this.ParksAndRecreation = ParksAndRecreation;
    }

    private int SmallHoldings;

    public int getSmallHoldings() {
        return this.SmallHoldings;
    }

    public void setSmallHoldings(int SmallHoldings) {
        this.SmallHoldings = SmallHoldings;
    }

    private int TradionalResidential;

    public int getTradionalResidential() {
        return this.TradionalResidential;
    }

    public void setTradionalResidential(int TradionalResidential) {
        this.TradionalResidential = TradionalResidential;
    }

    private int Vacant;

    public int getVacant() {
        return this.Vacant;
    }

    public void setVacant(int Vacant) {
        this.Vacant = Vacant;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("LandUseDetails{Collective=");
        builder.append(Collective);
        builder.append(", Commercial=");
        builder.append(Commercial);
        builder.append(", Farms=");
        builder.append(Farms);
        builder.append(", FormalResidential=");
        builder.append(FormalResidential);
        builder.append(", Industrial=");
        builder.append(Industrial);
        builder.append(", InformalResidential=");
        builder.append(InformalResidential);
        builder.append(", ParksAndRecreation=");
        builder.append(ParksAndRecreation);
        builder.append(", SmallHoldings=");
        builder.append(SmallHoldings);
        builder.append(", TradionalResidential=");
        builder.append(TradionalResidential);
        builder.append(", Vacant=");
        builder.append(Vacant);
        builder.append("}");
        return builder.toString();
    }
}
