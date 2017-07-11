package com.afrigis.services.search.extension;

/**
 * <p>
 * Represents IndividualIncomeDetails obtained from AfriGIS Census Service call
 * </p>
 *
 * @author Takalani
 */
public class IndividualIncomeDetails {

    private int NoIncome;

    public int getNoIncome() {
        return this.NoIncome;
    }

    public void setNoIncome(int NoIncome) {
        this.NoIncome = NoIncome;
    }

    private int LessThan400;

    public int getLessThan400() {
        return this.LessThan400;
    }

    public void setLessThan400(int LessThan400) {
        this.LessThan400 = LessThan400;
    }

    private int MoreThan400LessThan800;

    public int getMoreThan400LessThan800() {
        return this.MoreThan400LessThan800;
    }

    public void setMoreThan400LessThan800(int MoreThan400LessThan800) {
        this.MoreThan400LessThan800 = MoreThan400LessThan800;
    }

    private int MoreThan800LessThan1600;

    public int getMoreThan800LessThan1600() {
        return this.MoreThan800LessThan1600;
    }

    public void setMoreThan800LessThan1600(int MoreThan800LessThan1600) {
        this.MoreThan800LessThan1600 = MoreThan800LessThan1600;
    }

    private int MoreThan1600LessThan3200;

    public int getMoreThan1600LessThan3200() {
        return this.MoreThan1600LessThan3200;
    }

    public void setMoreThan1600LessThan3200(int MoreThan1600LessThan3200) {
        this.MoreThan1600LessThan3200 = MoreThan1600LessThan3200;
    }

    private int MoreThan3200LessThan6400;

    public int getMoreThan3200LessThan6400() {
        return this.MoreThan3200LessThan6400;
    }

    public void setMoreThan3200LessThan6400(int MoreThan3200LessThan6400) {
        this.MoreThan3200LessThan6400 = MoreThan3200LessThan6400;
    }

    private int MoreThan6400LessThan12800;

    public int getMoreThan6400LessThan12800() {
        return this.MoreThan6400LessThan12800;
    }

    public void setMoreThan6400LessThan12800(int MoreThan6400LessThan12800) {
        this.MoreThan6400LessThan12800 = MoreThan6400LessThan12800;
    }

    private int MoreThan12800LessThan25600;

    public int getMoreThan12800LessThan25600() {
        return this.MoreThan12800LessThan25600;
    }

    public void setMoreThan12800LessThan25600(int MoreThan12800LessThan25600) {
        this.MoreThan12800LessThan25600 = MoreThan12800LessThan25600;
    }

    private int MoreThan25600LessThan51200;

    public int getMoreThan25600LessThan51200() {
        return this.MoreThan25600LessThan51200;
    }

    public void setMoreThan25600LessThan51200(int MoreThan25600LessThan51200) {
        this.MoreThan25600LessThan51200 = MoreThan25600LessThan51200;
    }

    private int MoreThan51200LessThan102400;

    public int getMoreThan51200LessThan102400() {
        return this.MoreThan51200LessThan102400;
    }

    public void setMoreThan51200LessThan102400(int MoreThan51200LessThan102400) {
        this.MoreThan51200LessThan102400 = MoreThan51200LessThan102400;
    }

    private int MoreThan102400LessThan204800;

    public int getMoreThan102400LessThan204800() {
        return this.MoreThan102400LessThan204800;
    }

    public void setMoreThan102400LessThan204800(int MoreThan102400LessThan204800) {
        this.MoreThan102400LessThan204800 = MoreThan102400LessThan204800;
    }

    private int MoreThan204800;

    public int getMoreThan204800() {
        return this.MoreThan204800;
    }

    public void setMoreThan204800(int MoreThan204800) {
        this.MoreThan204800 = MoreThan204800;
    }

    private int Unspecified;

    public int getUnspecified() {
        return this.Unspecified;
    }

    public void setUnspecified(int Unspecified) {
        this.Unspecified = Unspecified;
    }

    private int NotApplicable;

    public int getNotApplicable() {
        return this.NotApplicable;
    }

    public void setNotApplicable(int NotApplicable) {
        this.NotApplicable = NotApplicable;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("IndividualIncomeDetails{NoIncome=");
        builder.append(NoIncome);
        builder.append(", LessThan400=");
        builder.append(LessThan400);
        builder.append(", MoreThan400LessThan800=");
        builder.append(MoreThan400LessThan800);
        builder.append(", MoreThan800LessThan1600=");
        builder.append(MoreThan800LessThan1600);
        builder.append(", MoreThan1600LessThan3200=");
        builder.append(MoreThan1600LessThan3200);
        builder.append(", MoreThan3200LessThan6400=");
        builder.append(MoreThan3200LessThan6400);
        builder.append(", MoreThan6400LessThan12800=");
        builder.append(MoreThan6400LessThan12800);
        builder.append(", MoreThan12800LessThan25600=");
        builder.append(MoreThan12800LessThan25600);
        builder.append(", MoreThan25600LessThan51200=");
        builder.append(MoreThan25600LessThan51200);
        builder.append(", MoreThan51200LessThan102400=");
        builder.append(MoreThan51200LessThan102400);
        builder.append(", MoreThan102400LessThan204800=");
        builder.append(MoreThan102400LessThan204800);
        builder.append(", MoreThan204800=");
        builder.append(MoreThan204800);
        builder.append(", Unspecified=");
        builder.append(Unspecified);
        builder.append(", NotApplicable=");
        builder.append(NotApplicable);
        builder.append("}");
        return builder.toString();
    }

}
