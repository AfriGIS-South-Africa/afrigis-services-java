package com.afrigis.services.search.extension.integration;

import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.search.extension.PostalCodeGetType;
import com.afrigis.services.search.extension.PostalCodeResponse;
import com.afrigis.services.search.extension.intiendoLS.api2.params.PostalCodeParams;
import com.afrigis.services.search.extension.postalcode.PostalCode;
import com.afrigis.services.test.util.TestUtil;
import org.json.JSONArray;
import org.json.JSONException;
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
 * Integration test for AfriGIS postal code service
 * </p>
 */
public class PostalCodeServiceTest {

    protected static final String KNOWN_SEOID = "Yze36F_iqn3043538";

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

        PostalCodeParams postalCodeParams = new PostalCodeParams(null, KNOWN_SEOID, PostalCodeGetType.JSON);
        factory.get(postalCodeParams);
    }

    @Test(expected = AfriGISServicesException.class)
    public void testInvalidEmail() throws Exception {
        log().info("Running testInvalidEmail");

        PostalCodeParams postalCodeParams = new PostalCodeParams(INVALID_EMAIL, KNOWN_LONGITUDE, null, PostalCodeGetType.JSON);
        factory.get(postalCodeParams);
    }

    @Test(expected = AfriGISServicesException.class)
    public void testMissingParamSeod() throws Exception {
        log().info("Running testMissingParamSeod");

        PostalCodeParams postalCodeParams = new PostalCodeParams(KNOWN_EMAIL, null, PostalCodeGetType.JSON);
        factory.get(postalCodeParams);
    }

    @Test(expected = AfriGISServicesException.class)
    public void testMissingParamLatitude() throws Exception {
        log().info("Running testMissingParamLatitude");

        PostalCodeParams postalCodeParams = new PostalCodeParams(KNOWN_EMAIL, null, KNOWN_LONGITUDE, PostalCodeGetType.JSON);
        factory.get(postalCodeParams);
    }

    @Test(expected = AfriGISServicesException.class)
    public void testMissingParamLongitude() throws Exception {
        log().info("Running testMissingParamLongitude");

        PostalCodeParams postalCodeParams = new PostalCodeParams(KNOWN_EMAIL, KNOWN_LONGITUDE, null, PostalCodeGetType.JSON);
        factory.get(postalCodeParams);
    }

    @Test
    public void testPostalCodeGetWithSeoid() throws Exception {
        log().info("Running testPostalCodeGetWithSeoid");

        PostalCodeParams postalCodeParams = new PostalCodeParams(KNOWN_EMAIL, KNOWN_SEOID, PostalCodeGetType.JSON);
        PostalCodeResponse response = factory.get(postalCodeParams);

        PostalCode postalCode = response.getResult();

        assertNotNull(postalCode);
        assertNotNull(postalCode.getCommercialActivities());
        assertNotNull(postalCode.getStreetCode());
        assertNotNull(postalCode.getSuburbs());
        assertTrue(postalCode.getSuburbs().size() >= 0);
        assertTrue(postalCode.getAverageHouseholdIncome() >= 0);
        assertTrue(postalCode.getHouseHoldCount() >= 0);
        assertNotNull(postalCode.getJsonGeometry());
        assertTrue(postalCode.getTotalArea() >= 0);
        assertTrue(postalCode.getTotalPopulation() >= 0);

        String rawJson = new String(response.getByteArray());

        assertNotNull(rawJson);
        assertTrue(rawJson.length() > 0);

        JSONObject obj = new JSONObject(rawJson).getJSONObject("result");
        assertNotNull(obj);

        assertTrue(obj.has("AverageHouseholdIncome"));
        assertTrue(obj.has("CommercialActivities"));
        assertTrue(obj.has("HouseHoldCount"));
        assertTrue(obj.has("JsonGeometry"));
        assertTrue(obj.has("StreetCode"));
        assertTrue(obj.has("Suburbs"));
        assertTrue(obj.has("TotalArea"));
        assertTrue(obj.has("TotalPopulation"));

        verifyCommercialActivities(obj.getJSONObject("CommercialActivities"));
        verifySuburbs(obj.getJSONArray("Suburbs"));
    }

    private void verifyCommercialActivities(JSONObject obj) {
        assertTrue(obj.has("Automotive"));
        assertTrue(obj.has("Commercial"));
        assertTrue(obj.has("Entertainment"));
        assertTrue(obj.has("FillingStations"));
        assertTrue(obj.has("Medical"));
        assertTrue(obj.has("Services"));
        assertTrue(obj.has("Stores"));
        assertTrue(obj.has("Tourism"));
        assertTrue(obj.has("Transportation"));
    }

    private void verifySuburbs(JSONArray arr) throws JSONException {
        for (int i = 0; i < arr.length(); i++) {

            JSONObject obj = arr.getJSONObject(i);

            assertTrue(obj.has("SuburbName"));
            assertTrue(obj.has("StreetCode"));
            assertTrue(obj.has("AverageHouseholdIncome"));
            assertTrue(obj.has("Population"));
            assertTrue(obj.has("RoadsInKM"));
            assertTrue(obj.has("SectionalSchemeCount"));
            assertTrue(obj.has("CentroidX"));
            assertTrue(obj.has("CentroidY"));
            assertTrue(obj.has("HouseholdIncome"));
        }
    }

    @Test
    public void testPostalCodeGetWithLatitudeAndLongitude() throws Exception {
        log().info("Running testPostalCodeGetWithLatitudeAndLongitude");

        PostalCodeParams postalCodeParams = new PostalCodeParams(KNOWN_EMAIL, KNOWN_LATITUDE, KNOWN_LONGITUDE, PostalCodeGetType.JSON);
        PostalCodeResponse response = factory.get(postalCodeParams);

        PostalCode postalCode = response.getResult();

        assertNotNull(postalCode);
        assertNotNull(postalCode.getCommercialActivities());
        assertNotNull(postalCode.getStreetCode());
        assertNotNull(postalCode.getSuburbs());
        assertTrue(postalCode.getSuburbs().size() >= 0);
        assertTrue(postalCode.getAverageHouseholdIncome() >= 0);
        assertTrue(postalCode.getHouseHoldCount() >= 0);
        assertNotNull(postalCode.getJsonGeometry());
        assertTrue(postalCode.getTotalArea() >= 0);
        assertTrue(postalCode.getTotalPopulation() >= 0);

        String rawJson = new String(response.getByteArray());

        assertNotNull(rawJson);
        assertTrue(rawJson.length() > 0);

        JSONObject obj = new JSONObject(rawJson).getJSONObject("result");
        assertNotNull(obj);

        assertTrue(obj.has("AverageHouseholdIncome"));
        assertTrue(obj.has("CommercialActivities"));
        assertTrue(obj.has("HouseHoldCount"));
        assertTrue(obj.has("JsonGeometry"));
        assertTrue(obj.has("StreetCode"));
        assertTrue(obj.has("Suburbs"));
        assertTrue(obj.has("TotalArea"));
        assertTrue(obj.has("TotalPopulation"));

        verifyCommercialActivities(obj.getJSONObject("CommercialActivities"));
        verifySuburbs(obj.getJSONArray("Suburbs"));
    }

    @Test
    public void testPostalCodeDownload() throws Exception {
        log().info("Running testPostalCodeDownload");

        PostalCodeParams postalCodeParams = new PostalCodeParams(KNOWN_EMAIL, KNOWN_LATITUDE, KNOWN_LONGITUDE, PostalCodeGetType.PDF);
        PostalCodeResponse response = factory.get(postalCodeParams);

        assertNotNull(response.getByteArray());
        assertTrue(response.getByteArray().length > 0);
    }

    protected Logger log() {
        return LoggerFactory.getLogger(getClass());
    }
}
