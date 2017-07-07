package com.afrigis.services.search.extension;

/**
 * <p>
 * Represents AgeDetails obtained from AfriGIS Census Service call
 * </p>
 *
 * @author Takalani
 */
public class AgeDetails {

    private int Age0To9;

    public int getAge0To9() {
        return this.Age0To9;
    }

    public void setAge0To9(int Age0To9) {
        this.Age0To9 = Age0To9;
    }

    private int Age10To19;

    public int getAge10To19() {
        return this.Age10To19;
    }

    public void setAge10To19(int Age10To19) {
        this.Age10To19 = Age10To19;
    }

    private int Age20To29;

    public int getAge20To29() {
        return this.Age20To29;
    }

    public void setAge20To29(int Age20To29) {
        this.Age20To29 = Age20To29;
    }

    private int Age30To39;

    public int getAge30To39() {
        return this.Age30To39;
    }

    public void setAge30To39(int Age30To39) {
        this.Age30To39 = Age30To39;
    }

    private int Age40To49;

    public int getAge40To49() {
        return this.Age40To49;
    }

    public void setAge40To49(int Age40To49) {
        this.Age40To49 = Age40To49;
    }

    private int Age50To59;

    public int getAge50To59() {
        return this.Age50To59;
    }

    public void setAge50To59(int Age50To59) {
        this.Age50To59 = Age50To59;
    }

    private int Age60To60;

    public int getAge60To60() {
        return this.Age60To60;
    }

    public void setAge60To60(int Age60To60) {
        this.Age60To60 = Age60To60;
    }

    private int Age70To79;

    public int getAge70To79() {
        return this.Age70To79;
    }

    public void setAge70To79(int Age70To79) {
        this.Age70To79 = Age70To79;
    }

    private int Age80Plus;

    public int getAge80Plus() {
        return this.Age80Plus;
    }

    public void setAge80Plus(int Age80Plus) {
        this.Age80Plus = Age80Plus;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("AgeDetails{Age0To9=");
        builder.append(Age0To9);
        builder.append(", Age10To19=");
        builder.append(Age10To19);
        builder.append(", Age20To29=");
        builder.append(Age20To29);
        builder.append(", Age30To39=");
        builder.append(Age30To39);
        builder.append(", Age40To49=");
        builder.append(Age40To49);
        builder.append(", Age50To59=");
        builder.append(Age50To59);
        builder.append(", Age60To60=");
        builder.append(Age60To60);
        builder.append(", Age70To79=");
        builder.append(Age70To79);
        builder.append(", Age80Plus=");
        builder.append(Age80Plus);
        builder.append("}");
        return builder.toString();
    }

}