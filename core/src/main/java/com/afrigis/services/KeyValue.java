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
