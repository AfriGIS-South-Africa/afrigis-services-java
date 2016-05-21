package com.afrigis.services.ext;

/**
 * <p>
 * Services that required auth should implement this to signal to the factory
 * that it needs to feed credentials in.
 * </p>
 * <p>
 * Hint: this should be all the services
 * </p>
 * 
 * <p>
 * Credentials can be obtained from the
 * <a href="https://developers.afrigis.co.za/sign-up/">AfriGIS Developers
 * Website</a>
 * </p>
 * 
 * @author hendrikc
 *
 */
public interface AuthenticatedService {

    /**
     * <p>
     * Method by which implementors receive credentials.
     * </p>
     * 
     * @param key
     *            the account key
     * @param secret
     *            the account secret.
     */
    void setCredentials(String key, byte[] secret);
}
