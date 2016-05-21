package com.afrigis.services.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

/**
 * <p>
 * Carefully and safely extracts the library version if available.
 * </p>
 * 
 * @author hendrikc
 *
 */
public final class Version {

    private Version() {
    }

    /**
     * <p>
     * Extracts and returns the semantic version of this lib.
     * </p>
     * 
     * @return the version of this library
     */
    public static String getVersion() {
        final String path = "/version.prop";
        InputStream stream = null;

        final Properties props = new Properties();
        try {
            stream = Version.class.getResourceAsStream(path);

            props.load(stream);

            return (String) props.get("version");
        } catch (IOException e) {
            return "UNKNOWN";
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }
}
