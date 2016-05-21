package com.afrigis.services.test.util;

import org.slf4j.LoggerFactory;

/**
 * A Utility class shared between unit tests.
 * 
 *
 * @author hendrikc
 *
 */
public final class TestUtil {

    /**
     * <p>
     * The key for the client id to use for testing.
     * </p>
     */
    private static final String AG_SERVICES_TEST_KEY =
            "ag.services.test.clientId";

    private static final String AG_SERVICES_TEST_KEY2 = "ag.services.test.key";

    /**
     * <p>
     * The key for the shared secret.
     * </p>
     */
    private static final String AG_SERVICES_TEST_SECRET =
            "ag.services.test.secret";

    /**
     * <p>
     * Private constructor. Does nada.
     * </p>
     */
    private TestUtil() {
    }

    /**
     * <p>
     * Credentials to the tests should be passed from outside via environment
     * variables or system properties.
     * </p>
     * 
     * @return the shared secret located under environment key
     *         <code>ag.services.test.secret</code>
     */
    public static String getSecret() {
        return extractValue(AG_SERVICES_TEST_SECRET,
                "PLEASE SET SECRET FOR TESTING AS ENV VALUE UNDER KEY "
                        + "'ag.services.test.secret'");
    }

    /**
     * <p>
     * Credentials to the tests should be passed from outside via environment
     * variables or system properties.
     * </p>
     * 
     * @return the client key located under environment key
     *         <code>ag.services.test.key</code>
     */
    public static String getKey() {
        final String errMsg =
                "PLEASE SET CLIENT ID FOR TESTING AS ENV VALUE UNDER KEY"
                        + " 'ag.services.test.key'";
        final String ret = extractValue(AG_SERVICES_TEST_KEY, null);

        if (ret != null) {
            return ret;
        }

        return extractValue(AG_SERVICES_TEST_KEY2, errMsg);
    }

    /**
     * <p>
     * Searches the environment and system properties for the provided key, and
     * returns the found value, or the default value if nothing found).
     * </p>
     * 
     * @param key
     *            the key of the item we are looking for
     * @param defaultValue
     *            the default value to return if we can't find the key
     * @return the found value (or default value if nothing found)
     */
    private static String extractValue(final String key,
            final String defaultValue) {
        String val = null;
        val = System.getenv(key);

        if (val == null) {
            val = System.getProperty(key);
        }

        if (val == null) {

            LoggerFactory.getLogger(TestUtil.class)
                    .warn("No value found in environent/properties under key '{}'. "
                            + "Tests will fail.", key);

            val = defaultValue;

        }

        return val;
    }

    public static String getZeroCreditKey() {
        final String errMsg =
                "PLEASE SET CLIENT ID FOR TESTING AS ENV VALUE UNDER KEY"
                        + " 'ag.services.test.zero.key'";
        final String ret = extractValue("ag.services.test.zero.key", errMsg);
        
        return ret;

//        if (ret != null) {
//            return ret;
//        }
//
//        return extractValue(AG_SERVICES_TEST_KEY2, errMsg);
    }

    public static String getZeroCreditSecret() {
        return extractValue("ag.services.test.zero.secret",
                "PLEASE SET SECRET FOR TESTING AS ENV VALUE UNDER KEY "
                        + "'ag.services.test.zero.secret'");
    }
}
