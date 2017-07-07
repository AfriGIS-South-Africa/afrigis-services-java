package com.afrigis.services.search.extension;

/**
 * <p>
 * Represents GenderDetails obtained from AfriGIS Census Service call
 * </p>
 *
 * @author Takalani
 */
public class GenderDetails {

    private int Male;

    public int getMale() {
        return this.Male;
    }

    public void setMale(int Male) {
        this.Male = Male;
    }

    private int Female;

    public int getFemale() {
        return this.Female;
    }

    public void setFemale(int Female) {
        this.Female = Female;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("GenderDetails{Male=");
        builder.append(Male);
        builder.append(", Female=");
        builder.append(Female);
        builder.append("}");
        return builder.toString();
    }

}
