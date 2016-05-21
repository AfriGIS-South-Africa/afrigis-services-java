package com.afrigis.services.ext;

/**
 * <p>
 * Interface for implementors aware of the "saas time" feature.
 * </p>
 * 
 * @author hendrikc
 *
 */
public interface SaasTimeAware {

    /**
     * <p>
     * Tells implementors to use saas time or not.
     * </p>
     * <p>
     * SaaS time SHOULD be used by all.
     * </p>
     * 
     * @param onOff
     *            true to use it, false to ignore it.
     */
    void setUseSaasTime(boolean onOff);

    /**
     * Sets the current time offset.
     * 
     * @param secs
     *            offset in seconds.
     */
    void setSaasOffsetInSeconds(int secs);

    /**
     * Retrieves the current offset (in seconds).
     * 
     * @return the offset in seconds.
     */
    int getSaasOffsetInSeconds();
}
