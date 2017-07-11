package com.afrigis.services.search.extension.census;

/**
 * <p>
 * Represents PopulationGroupDetails obtained from AfriGIS Census Service call
 * </p>
 *
 * @author Takalani
 */
public class PopulationGroupDetails {

    private int BlackAfrican;

    public int getBlackAfrican() {
        return this.BlackAfrican;
    }

    public void setBlackAfrican(int BlackAfrican) {
        this.BlackAfrican = BlackAfrican;
    }

    private int Coloured;

    public int getColoured() {
        return this.Coloured;
    }

    public void setColoured(int Coloured) {
        this.Coloured = Coloured;
    }

    private int IndianOrAsian;

    public int getIndianOrAsian() {
        return this.IndianOrAsian;
    }

    public void setIndianOrAsian(int IndianOrAsian) {
        this.IndianOrAsian = IndianOrAsian;
    }

    private int Other;

    public int getOther() {
        return this.Other;
    }

    public void setOther(int Other) {
        this.Other = Other;
    }

    private int TotalPopulation;

    public int getTotalPopulation() {
        return this.TotalPopulation;
    }

    public void setTotalPopulation(int TotalPopulation) {
        this.TotalPopulation = TotalPopulation;
    }

    private int White;

    public int getWhite() {
        return this.White;
    }

    public void setWhite(int White) {
        this.White = White;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("PopulationGroupDetails{BlackAfrican=");
        builder.append(BlackAfrican);
        builder.append(", Coloured=");
        builder.append(Coloured);
        builder.append(", IndianOrAsian=");
        builder.append(IndianOrAsian);
        builder.append(", Other=");
        builder.append(Other);
        builder.append(", TotalPopulation=");
        builder.append(TotalPopulation);
        builder.append(", White=");
        builder.append(White);
        builder.append("}");
        return builder.toString();
    }
}
