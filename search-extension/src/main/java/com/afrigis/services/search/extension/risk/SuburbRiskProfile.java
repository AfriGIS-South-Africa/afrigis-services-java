package com.afrigis.services.search.extension.risk;

/**
 *
 * @author Takalani
 */
public class SuburbRiskProfile {

    private NadLevel nadLevel;

    public NadLevel getNadLevel() {
        return this.nadLevel;
    }

    public void setNadLevel(NadLevel nadLevel) {
        this.nadLevel = nadLevel;
    }

    private SuburbLevel suburbLevel;

    public SuburbLevel getSuburbLevel() {
        return this.suburbLevel;
    }

    public void setSuburbLevel(SuburbLevel suburbLevel) {
        this.suburbLevel = suburbLevel;
    }

    private Suburb suburb;

    public Suburb getSuburb() {
        return this.suburb;
    }

    public void setSuburb(Suburb suburb) {
        this.suburb = suburb;
    }

    private String address;

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
