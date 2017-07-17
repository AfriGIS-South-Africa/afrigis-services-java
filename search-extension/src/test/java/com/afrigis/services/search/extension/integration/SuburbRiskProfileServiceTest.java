package com.afrigis.services.search.extension.integration;

import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.search.extension.RiskGetType;
import com.afrigis.services.search.extension.SuburbRiskProfileResponse;
import com.afrigis.services.search.extension.SuburbRiskTotalResponse;
import com.afrigis.services.search.extension.intiendoLS.api2.params.SuburbRiskProfileParams;
import com.afrigis.services.search.extension.risk.SuburbRiskProfile;
import com.afrigis.services.test.util.TestUtil;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Takalani
 *
 * <p>
 * Integration test for AfriGIS SuburbRiskProfile service
 * </p>
 */
public class SuburbRiskProfileServiceTest {

    protected static final String KNOWN_SEOID = "ca155b0201010101071155_30342d4F43542d3134";

    protected static final String KNOWN_EMAIL = CensusServiceTest.extractValue("ag.services.test.search-extension.email", null);

    protected static final String INVALID_EMAIL = "HelloWorld@test";

    protected static final String KNOWN_LATITUDE = "-25.748627182067";

    protected static final String KNOWN_LONGITUDE = "28.2350855";

    private static ServiceCallFactory factory;

    private static final String SERVICE_ENDPOINT_BASE = "https://saasstaging.afrigis.co.za/rest/2/";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

        factory = AfriGISServices.instance(TestUtil.getKey(), TestUtil.getSecret());
    }

    @Before
    public void before() {
        // Just make sure the test that fiddle with endpoint url does not have side effects

        factory.setServiceEndpoint(SERVICE_ENDPOINT_BASE);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        factory = null;
    }

    @Test(expected = AfriGISServicesException.class)
    public void testMissingParamEmail() throws Exception {
        log().info("Running testMissingParamEmail");

        SuburbRiskProfileParams searchParams = new SuburbRiskProfileParams(null, KNOWN_SEOID, RiskGetType.JSON);
        factory.get(searchParams);
    }

    @Test(expected = AfriGISServicesException.class)
    public void testInvalidEmail() throws Exception {
        log().info("Running testInvalidEmail");

        SuburbRiskProfileParams searchParams = new SuburbRiskProfileParams(INVALID_EMAIL, KNOWN_LONGITUDE, null, RiskGetType.JSON);
        factory.get(searchParams);
    }

    @Test(expected = AfriGISServicesException.class)
    public void testMissingParamSeod() throws Exception {
        log().info("Running testMissingParamSeod");

        SuburbRiskProfileParams searchParams = new SuburbRiskProfileParams(KNOWN_EMAIL, null, RiskGetType.JSON);
        factory.get(searchParams);
    }

    @Test(expected = AfriGISServicesException.class)
    public void testMissingParamLatitude() throws Exception {
        log().info("Running testMissingParamLatitude");

        SuburbRiskProfileParams searchParams = new SuburbRiskProfileParams(KNOWN_EMAIL, null, KNOWN_LONGITUDE, RiskGetType.JSON);
        factory.get(searchParams);
    }

    @Test(expected = AfriGISServicesException.class)
    public void testMissingParamLongitude() throws Exception {
        log().info("Running testMissingParamLongitude");

        SuburbRiskProfileParams searchParams = new SuburbRiskProfileParams(KNOWN_EMAIL, KNOWN_LONGITUDE, null, RiskGetType.JSON);
        factory.get(searchParams);
    }

    @Test
    public void testSuburbRiskProfileGetWithSeoid() throws Exception {
        log().info("Running testSuburbRiskProfileGetWithSeoid");

        SuburbRiskProfileParams searchParams = new SuburbRiskProfileParams(KNOWN_EMAIL, KNOWN_SEOID, RiskGetType.JSON);
        SuburbRiskProfileResponse response = factory.get(searchParams);

        SuburbRiskProfile result = response.getResult();

        assertNotNull(result);
        assertNotNull(result.getSuburb());

        String rawJson = new String(response.getByteArray());

        assertNotNull(rawJson);
        assertTrue(rawJson.length() > 0);

        JSONObject obj = new JSONObject(rawJson).getJSONObject("result");
        assertNotNull(obj);

        assertTrue(obj.has("suburb"));

        verifySuburb(obj.getJSONObject("suburb"));
    }

    private void verifySuburb(JSONObject obj) {
        assertTrue(obj.has("area"));
        assertTrue(obj.has("numberOfStands"));
        assertTrue(obj.has("populationCount"));
        assertTrue(obj.has("medianIncome"));
        assertTrue(obj.has("medianIncomDropSuburbId"));
        assertTrue(obj.has("medianIncomeDistanceFromSuburb"));
        assertTrue(obj.has("medianIncomeDropDifference"));
        assertTrue(obj.has("id"));
    }

    @Test
    public void testSuburbRiskProfileGetWithLatitudeAndLongitude() throws Exception {
        log().info("Running testSuburbRiskProfileGetWithLatitudeAndLongitude");

        SuburbRiskProfileParams searchParams = new SuburbRiskProfileParams(KNOWN_EMAIL, KNOWN_LATITUDE, KNOWN_LONGITUDE, RiskGetType.JSON);
        SuburbRiskProfileResponse response = factory.get(searchParams);

        SuburbRiskProfile result = response.getResult();

        assertNotNull(result);
        assertNotNull(result.getSuburb());

        String rawJson = new String(response.getByteArray());

        assertNotNull(rawJson);
        assertTrue(rawJson.length() > 0);

        JSONObject obj = new JSONObject(rawJson).getJSONObject("result");
        assertNotNull(obj);

        assertTrue(obj.has("suburb"));

        verifySuburb(obj.getJSONObject("suburb"));
    }

    @Test
    public void testSuburbRiskProfleDownload() throws Exception {
        log().info("Running testSuburbRiskProfleDownload");

        SuburbRiskProfileParams searchParams = new SuburbRiskProfileParams(KNOWN_EMAIL, KNOWN_LATITUDE, KNOWN_LONGITUDE, RiskGetType.PDF);
        SuburbRiskProfileResponse response = factory.get(searchParams);

        assertNotNull(response.getByteArray());
        assertTrue(response.getByteArray().length > 0);
    }

    @Test
    public void testGetTotalRiskProfleDownload() throws Exception {
        log().info("Running testGetTotalRiskProfleDownload");

        SuburbRiskProfileParams searchParams = new SuburbRiskProfileParams(KNOWN_EMAIL, KNOWN_LATITUDE, KNOWN_LONGITUDE, RiskGetType.JSON_TOTAL);
        SuburbRiskTotalResponse response = factory.get(searchParams);

        assertTrue(response.getTotalRisk() >= 0);
    }

    protected Logger log() {
        return LoggerFactory.getLogger(getClass());
    }
}
