package com.afrigis.services.geocode.impl;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Defines optional components of an address.
 * </p>
 * @author hendrikc
 *
 */
public class AddressComponent {
    private String type;
    
    @SerializedName("administrative_type")
    private String administrativeType;
    
    @SerializedName("long_name")
    private String longName;
    
    @SerializedName("short_name")
    private String shortName;

    /**
     * 
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     * @param typeIn the type
     */
    public void setType(String typeIn) {
        this.type = typeIn;
    }

    /**
     * 
     * @return the administrative type
     */
    public String getAdministrativeType() {
        return administrativeType;
    }

    /**
     * Sets the administrative type.
     * @param administrativetype the administrative type
     */
    public void setAdministrativeType(String administrativetype) {
        this.administrativeType = administrativetype;
    }

    /**
     * 
     * @return the long name
     */
    public String getLongName() {
        return longName;
    }

    /**
     * Sets the long name.
     * @param longname the long name.
     */
    public void setLongName(String longname) {
        this.longName = longname;
    }

    /**
     * 
     * @return the short name
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets the short name.
     * @param shortname the short name.
     */
    public void setShortName(String shortname) {
        this.shortName = shortname;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("AddressComponent [\n\ttype=");
        builder.append(type);
        builder.append(", \n\tadministrative_type=");
        builder.append(administrativeType);
        builder.append(", \n\tlong_name=");
        builder.append(longName);
        builder.append(", \n\tshort_name=");
        builder.append(shortName);
        builder.append("\n]");
        return builder.toString();
    }

}
