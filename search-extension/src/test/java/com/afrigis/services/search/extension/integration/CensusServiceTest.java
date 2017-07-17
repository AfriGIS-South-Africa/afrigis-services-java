package com.afrigis.services.search.extension.integration;

import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.search.extension.census.Census;
import com.afrigis.services.search.extension.CensusGetType;
import com.afrigis.services.search.extension.CensusResponse;
import com.afrigis.services.search.extension.intiendoLS.api2.params.CensusParams;
import com.afrigis.services.test.util.TestUtil;
import java.util.concurrent.Future;
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
 * Integration test for AfriGIS census service
 * </p>
 */
public class CensusServiceTest {

    protected static final String KNOWN_SEOID = "Yze36F_iqn3043538";

    protected static final String KNOWN_EMAIL = extractValue("ag.services.test.search-extension.email", null);

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

    @Test
    public void testCensusGetWithSeoid() throws Exception {
        log().info("Running testCensusGetWithSeoid");

        CensusParams censusParams = new CensusParams(KNOWN_EMAIL, KNOWN_SEOID, CensusGetType.JSON);
        Future<CensusResponse> resultFuture = factory.getAsync(censusParams);

        CensusResponse response = resultFuture.get();
        Census census = response.getResult();

        assertNotNull(census);
        assertNotNull(census.getAgeDetails());
        assertNotNull(census.getDwellingDetails());
        assertNotNull(census.getHouseholdIncomeDetails());
        assertNotNull(census.getIndividualIncomeDetails());
        assertNotNull(census.getEmploymentStatusDetails());
        assertNotNull(census.getGenderDetails());
        assertNotNull(census.getLandUseDetails());
        assertNotNull(census.getLanguageDetails());
        assertNotNull(census.getPopulationGroupDetails());
        assertNotNull(census.getWaterDetails());
        assertNotNull(census.getGeoJson());
        assertTrue(census.getLatitude() >= 0);
        assertTrue(census.getLongitude() >= 0);

        String rawJson = new String(response.getByteArray());

        assertNotNull(rawJson);
        assertTrue(rawJson.length() > 0);

        JSONObject obj = new JSONObject(rawJson).getJSONObject("result");
        assertNotNull(obj);

        assertTrue(obj.has("AgeDetails"));
        assertTrue(obj.has("DwellingDetails"));
        assertTrue(obj.has("HouseholdIncomeDetails"));
        assertTrue(obj.has("IndividualIncomeDetails"));
        assertTrue(obj.has("EmploymentStatusDetails"));
        assertTrue(obj.has("GenderDetails"));
        assertTrue(obj.has("LandUseDetails"));
        assertTrue(obj.has("LanguageDetails"));
        assertTrue(obj.has("PopulationGroupDetails"));
        assertTrue(obj.has("WaterDetails"));

        verifyAgeDetailsJson(obj.getJSONObject("AgeDetails"));
        verifyDwellingDetailsJson(obj.getJSONObject("DwellingDetails"));
        verifyHouseholdIncomeDetails(obj.getJSONObject("HouseholdIncomeDetails"));
        verifyIndividualIncomeDetails(obj.getJSONObject("IndividualIncomeDetails"));
        verifyEmploymentStatusDetails(obj.getJSONObject("EmploymentStatusDetails"));
        verifyGenderDetails(obj.getJSONObject("GenderDetails"));
        verifyLandUseDetails(obj.getJSONObject("LandUseDetails"));
        verifyLanguageDetails(obj.getJSONObject("LanguageDetails"));
    }

    private void verifyAgeDetailsJson(JSONObject obj) {
        assertTrue(obj.has("Age0To9"));
        assertTrue(obj.has("Age10To19"));
        assertTrue(obj.has("Age20To29"));
        assertTrue(obj.has("Age30To39"));
        assertTrue(obj.has("Age40To49"));
        assertTrue(obj.has("Age50To59"));
        assertTrue(obj.has("Age60To60"));
        assertTrue(obj.has("Age70To79"));
        assertTrue(obj.has("Age80Plus"));
    }

    private void verifyDwellingDetailsJson(JSONObject obj) {
        assertTrue(obj.has("CaravanTent"));
        assertTrue(obj.has("ClusterHouse"));
        assertTrue(obj.has("Flat"));
        assertTrue(obj.has("House"));
        assertTrue(obj.has("HouseInBackyard"));
        assertTrue(obj.has("InformalDwelling"));
        assertTrue(obj.has("InformalDwellingInBackyard"));
        assertTrue(obj.has("NotApplicable"));
        assertTrue(obj.has("Other"));
        assertTrue(obj.has("RoomOnAProperty"));
        assertTrue(obj.has("SemiDetachedHouse"));
        assertTrue(obj.has("Townhouse"));
        assertTrue(obj.has("TraditionalDwelling"));
        assertTrue(obj.has("TraditionalResidential"));
        assertTrue(obj.has("Unspecified"));
    }

    private void verifyHouseholdIncomeDetails(JSONObject obj) {
        assertTrue(obj.has("NoIncome"));
        assertTrue(obj.has("LessThan4800"));
        assertTrue(obj.has("MoreThan4800LessThan9600"));
        assertTrue(obj.has("MoreThan9600LessThan19600"));
        assertTrue(obj.has("MoreThan19600LessThan38200"));
        assertTrue(obj.has("MoreThan38200LessThan76400"));
        assertTrue(obj.has("MoreThan76400LessThan153800"));
        assertTrue(obj.has("MoreThan153800LessThan307600"));
        assertTrue(obj.has("MoreThan307600LessThan614400"));
        assertTrue(obj.has("MoreThan614400LessThan1228800"));
        assertTrue(obj.has("MoreThan1228800LessThan2457600"));
        assertTrue(obj.has("MoreThan2457600"));
        assertTrue(obj.has("Unspecified"));
    }

    private void verifyIndividualIncomeDetails(JSONObject obj) {
        assertTrue(obj.has("NoIncome"));
        assertTrue(obj.has("LessThan400"));
        assertTrue(obj.has("MoreThan400LessThan800"));
        assertTrue(obj.has("MoreThan800LessThan1600"));
        assertTrue(obj.has("MoreThan1600LessThan3200"));
        assertTrue(obj.has("MoreThan3200LessThan6400"));
        assertTrue(obj.has("MoreThan6400LessThan12800"));
        assertTrue(obj.has("MoreThan12800LessThan25600"));
        assertTrue(obj.has("MoreThan25600LessThan51200"));
        assertTrue(obj.has("MoreThan51200LessThan102400"));
        assertTrue(obj.has("MoreThan102400LessThan204800"));
        assertTrue(obj.has("MoreThan204800"));
        assertTrue(obj.has("Unspecified"));
        assertTrue(obj.has("NotApplicable"));
    }

    private void verifyEmploymentStatusDetails(JSONObject obj) {
        assertTrue(obj.has("AgeLessThan15Years"));
        assertTrue(obj.has("DiscouragedWorkSeeker"));
        assertTrue(obj.has("Employed"));
        assertTrue(obj.has("EmploymentNotApplicable"));
        assertTrue(obj.has("OtherNotEconomicallyActive"));
        assertTrue(obj.has("Unemployed"));
    }

    private void verifyGenderDetails(JSONObject obj) {
        assertTrue(obj.has("Male"));
        assertTrue(obj.has("Female"));
    }

    private void verifyLandUseDetails(JSONObject obj) {
        assertTrue(obj.has("Collective"));
        assertTrue(obj.has("Commercial"));
        assertTrue(obj.has("Farms"));
        assertTrue(obj.has("FormalResidential"));
        assertTrue(obj.has("Industrial"));
        assertTrue(obj.has("InformalResidential"));
        assertTrue(obj.has("ParksAndRecreation"));
        assertTrue(obj.has("SmallHoldings"));
        assertTrue(obj.has("TradionalResidential"));
        assertTrue(obj.has("Vacant"));
    }

    private void verifyLanguageDetails(JSONObject obj) {
        assertTrue(obj.has("Afrikaans"));
        assertTrue(obj.has("English"));
        assertTrue(obj.has("Isindebele"));
        assertTrue(obj.has("Isixhosa"));
        assertTrue(obj.has("Isizulu"));
        assertTrue(obj.has("Sepedi"));
        assertTrue(obj.has("Sesotho"));
        assertTrue(obj.has("Setswana"));
        assertTrue(obj.has("SignLanguage"));
        assertTrue(obj.has("Siswati"));
        assertTrue(obj.has("Tshivenda"));
        assertTrue(obj.has("Xitsonga"));
        assertTrue(obj.has("Other"));
        assertTrue(obj.has("Unspecified"));
        assertTrue(obj.has("NotApplicable"));
    }

    @Test
    public void testCensusGetWithLatitudeAndLongitude() throws Exception {
        log().info("Running testCensusGetWithLatitudeAndLongitude");

        CensusParams censusParams = new CensusParams(KNOWN_EMAIL, KNOWN_LATITUDE, KNOWN_LONGITUDE, CensusGetType.JSON);
        Future<CensusResponse> resultFuture = factory.getAsync(censusParams);

        CensusResponse response = resultFuture.get();
        Census census = response.getResult();

        assertNotNull(census);
        assertNotNull(census.getAgeDetails());
        assertNotNull(census.getDwellingDetails());
        assertNotNull(census.getHouseholdIncomeDetails());
        assertNotNull(census.getIndividualIncomeDetails());
        assertNotNull(census.getEmploymentStatusDetails());
        assertNotNull(census.getGenderDetails());
        assertNotNull(census.getLandUseDetails());
        assertNotNull(census.getLanguageDetails());
        assertNotNull(census.getPopulationGroupDetails());
        assertNotNull(census.getWaterDetails());
        assertNotNull(census.getGeoJson());
        assertTrue(census.getLatitude() >= 0);
        assertTrue(census.getLongitude() >= 0);

        String rawJson = new String(response.getByteArray());

        assertNotNull(rawJson);
        assertTrue(rawJson.length() > 0);

        JSONObject obj = new JSONObject(rawJson).getJSONObject("result");
        assertNotNull(obj);

        assertTrue(obj.has("AgeDetails"));
        assertTrue(obj.has("DwellingDetails"));
        assertTrue(obj.has("HouseholdIncomeDetails"));
        assertTrue(obj.has("IndividualIncomeDetails"));
        assertTrue(obj.has("EmploymentStatusDetails"));
        assertTrue(obj.has("GenderDetails"));
        assertTrue(obj.has("LandUseDetails"));
        assertTrue(obj.has("LanguageDetails"));
        assertTrue(obj.has("PopulationGroupDetails"));
        assertTrue(obj.has("WaterDetails"));

        verifyAgeDetailsJson(obj.getJSONObject("AgeDetails"));
        verifyDwellingDetailsJson(obj.getJSONObject("DwellingDetails"));
        verifyHouseholdIncomeDetails(obj.getJSONObject("HouseholdIncomeDetails"));
        verifyIndividualIncomeDetails(obj.getJSONObject("IndividualIncomeDetails"));
        verifyEmploymentStatusDetails(obj.getJSONObject("EmploymentStatusDetails"));
        verifyGenderDetails(obj.getJSONObject("GenderDetails"));
        verifyLandUseDetails(obj.getJSONObject("LandUseDetails"));
        verifyLanguageDetails(obj.getJSONObject("LanguageDetails"));
    }

    @Test
    public void testCensusDownload() throws Exception {
        log().info("Running testCensusGetWithLatitudeAndLongitude");

        CensusParams censusParams = new CensusParams(KNOWN_EMAIL, KNOWN_LATITUDE, KNOWN_LONGITUDE, CensusGetType.PDF);
        CensusResponse response = factory.get(censusParams);

        assertNotNull(response.getByteArray());
        assertTrue(response.getByteArray().length > 0);
    }

    protected Logger log() {
        return LoggerFactory.getLogger(getClass());
    }

    public static String extractValue(final String key,
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
}
