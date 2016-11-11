package com.afrigis.services;

/**
 * <p>
 * Object used to store key/value pairs in the parameter list of SaasClient.
 * </p>
 * 
 * @author sydney
 *
 */
public class KeyValue {
    private String key;
    private String value;

    /**
     * <p>
     * Instantiate a key/value pair with values set.
     * </p>
     * 
     * @param theKey
     *            The key name
     * @param theValue
     *            The key value
     */
    public KeyValue(String theKey, String theValue) {
        this.key = theKey;
        this.value = theValue;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        KeyValue other = (KeyValue) obj;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    /**
     * <p>
     * Create an empty key/value pair, if values are to be determined later.
     * </p>
     */
    public KeyValue() {
        this.key = "";
        this.value = "";
    }

    /**
     * <p>
     * Retrieves teh key name.
     * </p>
     * 
     * @return The key name
     */
    public String getKey() {
        return key;
    }

    /**
     * <p>
     * Sets the key name.
     * </p>
     * 
     * @param theKey
     *            The key name
     */
    public void setKey(String theKey) {
        this.key = theKey;
    }

    /**
     * <p>
     * Retrieves the value.
     * </p>
     * 
     * @return The key value
     */
    public String getValue() {
        return value;
    }

    /**
     * <p>
     * Sets the value for this key.
     * </p>
     * 
     * @param theVal
     *            The key value
     */
    public void setValue(String theVal) {
        this.value = theVal;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("KeyValue [key=");
        builder.append(key);
        builder.append(", value=");
        builder.append(value);
        builder.append("]");
        return builder.toString();
    }
}
