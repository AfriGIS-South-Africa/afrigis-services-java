package com.afrigis.services.search.extension.census;

/**
 * <p>
 * Represents EmploymentStatusDetails obtained from AfriGIS Census Service call
 * </p>
 *
 * @author Takalani
 */
public class EmploymentStatusDetails {

    private int AgeLessThan15Years;

    public int getAgeLessThan15Years() {
        return this.AgeLessThan15Years;
    }

    public void setAgeLessThan15Years(int AgeLessThan15Years) {
        this.AgeLessThan15Years = AgeLessThan15Years;
    }

    private int DiscouragedWorkSeeker;

    public int getDiscouragedWorkSeeker() {
        return this.DiscouragedWorkSeeker;
    }

    public void setDiscouragedWorkSeeker(int DiscouragedWorkSeeker) {
        this.DiscouragedWorkSeeker = DiscouragedWorkSeeker;
    }

    private int Employed;

    public int getEmployed() {
        return this.Employed;
    }

    public void setEmployed(int Employed) {
        this.Employed = Employed;
    }

    private int EmploymentNotApplicable;

    public int getEmploymentNotApplicable() {
        return this.EmploymentNotApplicable;
    }

    public void setEmploymentNotApplicable(int EmploymentNotApplicable) {
        this.EmploymentNotApplicable = EmploymentNotApplicable;
    }

    private int OtherNotEconomicallyActive;

    public int getOtherNotEconomicallyActive() {
        return this.OtherNotEconomicallyActive;
    }

    public void setOtherNotEconomicallyActive(int OtherNotEconomicallyActive) {
        this.OtherNotEconomicallyActive = OtherNotEconomicallyActive;
    }

    private int Unemployed;

    public int getUnemployed() {
        return this.Unemployed;
    }

    public void setUnemployed(int Unemployed) {
        this.Unemployed = Unemployed;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("EmploymentStatusDetails{AgeLessThan15Years=");
        builder.append(AgeLessThan15Years);
        builder.append(", DiscouragedWorkSeeker=");
        builder.append(DiscouragedWorkSeeker);
        builder.append(", Employed=");
        builder.append(Employed);
        builder.append(", EmploymentNotApplicable=");
        builder.append(EmploymentNotApplicable);
        builder.append(", OtherNotEconomicallyActive=");
        builder.append(OtherNotEconomicallyActive);
        builder.append(", Unemployed=");
        builder.append(Unemployed);
        builder.append("}");
        return builder.toString();
    }

}
