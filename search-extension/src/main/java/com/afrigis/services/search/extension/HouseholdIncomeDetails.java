package com.afrigis.services.search.extension;

/**
 * <p>
 * Represents HouseholdIncomeDetails obtained from AfriGIS Census Service call
 * </p>
 *
 * @author Takalani
 */
public class HouseholdIncomeDetails {

    private int NoIncome;

    public int getNoIncome() {
        return this.NoIncome;
    }

    public void setNoIncome(int NoIncome) {
        this.NoIncome = NoIncome;
    }

    private int LessThan4800;

    public int getLessThan4800() {
        return this.LessThan4800;
    }

    public void setLessThan4800(int LessThan4800) {
        this.LessThan4800 = LessThan4800;
    }

    private int MoreThan4800LessThan9600;

    public int getMoreThan4800LessThan9600() {
        return this.MoreThan4800LessThan9600;
    }

    public void setMoreThan4800LessThan9600(int MoreThan4800LessThan9600) {
        this.MoreThan4800LessThan9600 = MoreThan4800LessThan9600;
    }

    private int MoreThan9600LessThan19600;

    public int getMoreThan9600LessThan19600() {
        return this.MoreThan9600LessThan19600;
    }

    public void setMoreThan9600LessThan19600(int MoreThan9600LessThan19600) {
        this.MoreThan9600LessThan19600 = MoreThan9600LessThan19600;
    }

    private int MoreThan19600LessThan38200;

    public int getMoreThan19600LessThan38200() {
        return this.MoreThan19600LessThan38200;
    }

    public void setMoreThan19600LessThan38200(int MoreThan19600LessThan38200) {
        this.MoreThan19600LessThan38200 = MoreThan19600LessThan38200;
    }

    private int MoreThan38200LessThan76400;

    public int getMoreThan38200LessThan76400() {
        return this.MoreThan38200LessThan76400;
    }

    public void setMoreThan38200LessThan76400(int MoreThan38200LessThan76400) {
        this.MoreThan38200LessThan76400 = MoreThan38200LessThan76400;
    }

    private int MoreThan76400LessThan153800;

    public int getMoreThan76400LessThan153800() {
        return this.MoreThan76400LessThan153800;
    }

    public void setMoreThan76400LessThan153800(int MoreThan76400LessThan153800) {
        this.MoreThan76400LessThan153800 = MoreThan76400LessThan153800;
    }

    private int MoreThan153800LessThan307600;

    public int getMoreThan153800LessThan307600() {
        return this.MoreThan153800LessThan307600;
    }

    public void setMoreThan153800LessThan307600(int MoreThan153800LessThan307600) {
        this.MoreThan153800LessThan307600 = MoreThan153800LessThan307600;
    }

    private int MoreThan307600LessThan614400;

    public int getMoreThan307600LessThan614400() {
        return this.MoreThan307600LessThan614400;
    }

    public void setMoreThan307600LessThan614400(int MoreThan307600LessThan614400) {
        this.MoreThan307600LessThan614400 = MoreThan307600LessThan614400;
    }

    private int MoreThan614400LessThan1228800;

    public int getMoreThan614400LessThan1228800() {
        return this.MoreThan614400LessThan1228800;
    }

    public void setMoreThan614400LessThan1228800(int MoreThan614400LessThan1228800) {
        this.MoreThan614400LessThan1228800 = MoreThan614400LessThan1228800;
    }

    private int MoreThan1228800LessThan2457600;

    public int getMoreThan1228800LessThan2457600() {
        return this.MoreThan1228800LessThan2457600;
    }

    public void setMoreThan1228800LessThan2457600(int MoreThan1228800LessThan2457600) {
        this.MoreThan1228800LessThan2457600 = MoreThan1228800LessThan2457600;
    }

    private int MoreThan2457600;

    public int getMoreThan2457600() {
        return this.MoreThan2457600;
    }

    public void setMoreThan2457600(int MoreThan2457600) {
        this.MoreThan2457600 = MoreThan2457600;
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
        builder.append("HouseholdIncomeDetails{NoIncome=");
        builder.append(NoIncome);
        builder.append(", LessThan4800=");
        builder.append(LessThan4800);
        builder.append(", MoreThan4800LessThan9600=");
        builder.append(MoreThan4800LessThan9600);
        builder.append(", MoreThan9600LessThan19600=");
        builder.append(MoreThan9600LessThan19600);
        builder.append(", MoreThan19600LessThan38200=");
        builder.append(MoreThan19600LessThan38200);
        builder.append(", MoreThan38200LessThan76400=");
        builder.append(MoreThan38200LessThan76400);
        builder.append(", MoreThan76400LessThan153800=");
        builder.append(MoreThan76400LessThan153800);
        builder.append(", MoreThan153800LessThan307600=");
        builder.append(MoreThan153800LessThan307600);
        builder.append(", MoreThan307600LessThan614400=");
        builder.append(MoreThan307600LessThan614400);
        builder.append(", MoreThan614400LessThan1228800=");
        builder.append(MoreThan614400LessThan1228800);
        builder.append(", MoreThan1228800LessThan2457600=");
        builder.append(MoreThan1228800LessThan2457600);
        builder.append(", MoreThan2457600=");
        builder.append(MoreThan2457600);
        builder.append(", Unspecified=");
        builder.append(Unspecified);
        builder.append("}");
        return builder.toString();
    }

}
