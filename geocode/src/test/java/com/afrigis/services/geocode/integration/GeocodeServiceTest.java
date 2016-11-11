/**
 * 
 */
package com.afrigis.services.geocode.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.nio.charset.Charset;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.geocode.AddressRequest;
import com.afrigis.services.geocode.AddressResponse;
import com.afrigis.services.geocode.GeocodeGroupOption;
import com.afrigis.services.geocode.Geometry;
import com.afrigis.services.geocode.LocationResult;
import com.afrigis.services.geocode.impl.AddressComponent;
import com.afrigis.services.internal.saas.api2.intiendoLS.params.SearchParams;
import com.afrigis.services.test.util.TestUtil;

/**
 * @author hendrikc
 *
 */
public class GeocodeServiceTest {

    protected static final String KNOWN_SEOID =
            "CA155b0E010101010b305c_32302D5345502D3134";

    protected static final String KNOWN_DOCID = "AG_NAD|3~635~14628~494145";

    protected static final String _446_RIGEL = "446 Rigel";

    protected static final String HATFIELD = "Hatfield";

    protected static final Logger LOG =
            LoggerFactory.getLogger(GeocodeServiceTest.class);

    private static ServiceCallFactory factory;

    private static ServiceCallFactory zeroFactory;

    public GeocodeServiceTest() {

    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

        factory = AfriGISServices.instance(TestUtil.getKey(),
                TestUtil.getSecret());

        zeroFactory = AfriGISServices.instance("76efefcda8", "ZERO");


    }
    
    @Before
    public void before () {
        //Just make sure the test that fiddle with endpoint url does not have side effects
        factory.setServiceEndpoint("https://saas.afrigis.co.za/rest/2/");
        zeroFactory.setServiceEndpoint("https://saas.afrigis.co.za/rest/2/");
    }

   
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        factory = null;
    }

    @Test
    public void testGeocodeSearch() throws Exception {
        log().info("Running testGeocodeSearch");

        AddressResponse addressResponse =
                factory.get(AddressRequest.build(_446_RIGEL));

        assertNotNull(addressResponse);

        List<LocationResult> addresses = addressResponse.listResults();
        assertTrue(addresses.size() > 0);

        // Get items by index
        assertNotNull(addresses.get(0));
        assertNotNull(addresses.get(1));

        // Or loop through the whole shebang
        for (LocationResult address : addresses) {
            LOG.info("LocationResult match: {}", address);
            assertNotNull(address);
            assertNotNull(address.getFormattedAddress());
            assertNotNull(address.getConfidence());
            assertNotNull(address.getTypes());
            assertFalse (address.getTypes().isEmpty());
        }

        String rawJson = new String(addressResponse.getByteArray());
        LOG.info("This is the raw response as received from the server: \n{}",
                rawJson);
        assertNotNull(rawJson);
        assertTrue(rawJson.length() > 10);

        JSONObject obj = new JSONObject(rawJson);
        assertNotNull(obj);

    }

    @Test
    public void testGeocodeGet() throws Exception {
        /*
         * This is basically the same thing as #testGeocodeSearch
         */
        log().info("Running testGeocodeSearch");

        AddressResponse addressResponse =
                factory.get((AddressRequest.build(HATFIELD)));

        assertNotNull(addressResponse);

        List<LocationResult> addresses = addressResponse.listResults();
        assertTrue(addresses.size() > 0);

        verifyAddressList(addresses);

        LocationResult first = addresses.get(0);
        assertEquals("Hatfield, Pretoria, Gauteng, 0028", first.getFormattedAddress());

        String rawJson = new String(addressResponse.getByteArray());
        LOG.info("This is the raw response as received from the server: \n{}",
                rawJson);
        assertNotNull(rawJson);
        assertTrue(rawJson.length() > 10);

        JSONObject obj = new JSONObject(rawJson);
        assertNotNull(obj);

    }

    @Test
    public void testGeocodeSearchAsync() throws Exception {
        log().info("Running testGeocodeSearchAsync");
        long start = System.currentTimeMillis();

        Future<AddressResponse> addressResponse =
                factory.getAsync((AddressRequest.build(HATFIELD)));
        assertNotNull(addressResponse);

        AddressResponse realResponse =
                addressResponse.get(30, TimeUnit.SECONDS);
        long diff = System.currentTimeMillis() - start;
        log().info("Received async response after {} millis", diff);

        Collection<LocationResult> addresses = realResponse.listResults();
        assertTrue(addresses.size() > 0);
        verifyAddressList(addresses);

        String rawJson = new String(realResponse.getByteArray());
        LOG.info("This is the raw response as received from the server: \n{}",
                rawJson);
        assertNotNull(rawJson);
        assertTrue(rawJson.length() > 10);

        JSONObject obj = new JSONObject(rawJson);
        assertNotNull(obj);

    }

    protected Logger log() {
        return LoggerFactory.getLogger(getClass());
    }

    @Test
    public void testGeocodeSearchWithOptionalParams() throws Exception {
        log().info("Running testGeocodeSearchWithOptionalParams");

        AddressResponse addressResponse =
                factory.get((AddressRequest.build(_446_RIGEL)));
        assertNotNull(addressResponse);

        Collection<LocationResult> addresses = addressResponse.listResults();
        assertTrue(addresses.size() > 0);
        verifyAddressList(addresses);

        String rawJson = new String(addressResponse.getByteArray());
        LOG.info("This is the raw response as received from the server: \n{}",
                rawJson);
        assertNotNull(rawJson);
        assertTrue(rawJson.length() > 10);

        JSONObject obj = new JSONObject(rawJson);
        assertNotNull(obj);

    }

    @Ignore ("Backend service is foobar, intermittedly returns more results than asked for.")
    @Test
    public void testGeocodeSearchWithLimitAndOffset() throws Exception {
        log().info("Running testGeocodeSearchWithLimitAndOffset");

        AddressRequest params = new AddressRequest(HATFIELD);
        params.setNumberOfRecords(5);

        AddressResponse addressResponse = factory.get(params);
        assertNotNull(addressResponse);

        List<LocationResult> addressesWithLimits = addressResponse.listResults();
        assertTrue("Expected 5 ore less address, but apparently received " + addressesWithLimits.size(),addressesWithLimits.size() <= 5);
        verifyAddressList(addressesWithLimits);

        // Ok, now repeat the above, but with offset of 2
        params.setFrom(2);
        addressResponse = factory.get(params);
        assertNotNull(addressResponse);

        //This test for some reason produces failures every now and then - the problem is with the backend service.
        List<LocationResult> addressesWithLimitsAndOffset =
                addressResponse.listResults();
        if (addressesWithLimitsAndOffset.size() > 5) {
            log().warn("geocode service again ignored the limit parameter. We have disabled the assertion in this test until such time as the server is fixed.");
        }
//        assertTrue("Expected 5 or less address results, but got " + addressesWithLimitsAndOffset.size(),addressesWithLimitsAndOffset.size() <= 5);
        verifyAddressList(addressesWithLimitsAndOffset);
        assertFalse(addressesWithLimits.get(0)
                .equals(addressesWithLimitsAndOffset.get(0)));
        assertFalse(addressesWithLimits.get(1)
                .equals(addressesWithLimitsAndOffset.get(1)));

        // So if offset worked, then the third item in the old list must match
        // the first item
        // in the new list. easy.
        assertTrue(addressesWithLimits.get(2)
                .equals(addressesWithLimitsAndOffset.get(0)));
    }

    /**
     * Utility method that checks that:
     * <ul>
     * <li>No null objects in the list</li>
     * <li>each object in the list has non null LocationResult component</li>
     * <li>each object has a non null Location component</li>
     * </ul>
     * 
     * @param addresses
     *            the list of addresses received from the server
     */
    private void verifyAddressList(Collection<LocationResult> addresses) {
        for (LocationResult address : addresses) {
            LOG.info("LocationResult match: {}", address);
            assertNotNull(address);
            assertNotNull(address.getFormattedAddress());
            assertNotNull(address.getLocation());
        }
    }

    @Test(expected = AfriGISServicesException.class)
    public void testGeocodeNoCredits() throws Exception {
        log().info("Running testGeocodeNoCredits");
        
        int remainingCreds = zeroFactory.getCreditBalance();
        assertEquals(
                "Was expecting zero credits, instead got " + remainingCreds, 0,
                remainingCreds); 

        AddressRequest params = new AddressRequest(HATFIELD);
        zeroFactory.get(params);
        /*
         * Force an error if we got here, it should have thrown an Insufficients
         * Credits exception rather
         */
        fail("We were supposed to get an exception here, but we did not");

        LOG.info("GeocodeService got Insufficients Credits exception");
    }

    @Test
    public void testBuildUrlNoOptionals() {
        log().debug("Running testBuildUrlNoOptionals");

        String url = zeroFactory.buildUrl(AddressRequest.build(HATFIELD));
        log().debug("We got this this URL: {}", url);

        assertTrue(url.startsWith(
                "https://saas.afrigis.co.za/rest/2/intiendols.basic.geocode.address/76efefcda8/"));
        assertTrue(url.contains("ils_location=Hatfield"));
        assertTrue(url.contains("libmode=url"));
        assertFalse(url.contains("ils_result_start"));
        assertFalse(url.contains("ils_result_count"));
    }

    /**
     * Generates some random number to use as an "address", and verifies that we
     * get 0 results without "incident".
     */
    @Test
    public void testFakeAddress() {
        String rand = Double.toString(Math.random()) + " " + Math.random();

        AddressResponse addressResponse =
                factory.get(AddressRequest.build(rand));
        assertEquals(0, addressResponse.listResults().size());
    }

    @Test
    public void testGetStringNoOptionals() {
        String response =
                factory.getString(AddressRequest.build(HATFIELD));
        assertNotNull(response);
        assertTrue(response.length() > 0);

        JSONObject testObj;
        try {
            testObj = new JSONObject(response);
            assertNotNull(testObj);
            JSONArray results = testObj.getJSONArray("results");
            assertNotNull(results);
            assertTrue(results.length() > 2);

            // We are searching a known entity, so we EXPECT this to be solid.
            JSONObject first = results.getJSONObject(0);
            assertNotNull(first);

            assertEquals("AG_SUBURBS|3~635~13777", first.get("docid"));

        } catch (JSONException e) {
            log().error("Failed to parse json - so probably bad");
            fail(e.getMessage());
        }

    }

    @Test
    public void testGetByteArrayNoOptionals() {
        byte[] response =
                factory.getByteArray(AddressRequest.build(HATFIELD));
        assertNotNull(response);
        assertTrue(response.length > 10);

        JSONObject testObj;
        try {
            testObj = new JSONObject(
                    new String(response, Charset.forName("UTF-8")));
            assertNotNull(testObj);
            JSONArray results = testObj.getJSONArray("results");
            assertNotNull(results);
            assertTrue(results.length() > 2);

            // We are searching a known entity, so we EXPECT this to be solid.
            JSONObject first = results.getJSONObject(0);
            assertNotNull(first);

            assertEquals("AG_SUBURBS|3~635~13777", first.get("docid"));

        } catch (JSONException e) {
            log().error("Failed to parse json - so probably bad");
            fail(e.getMessage());
        }
    }

    @Test(expected = InvalidParameterException.class)
    public void testEmptyStringGeocodeParams() {
        factory.get(AddressRequest.build(""));
    }
    
    

    @Test(expected = AfriGISServicesException.class)
    public void testNullGeocodeSearchTerm() {
        factory.get((AddressRequest) null);
    }

    @Test
    public void testCallback() {
        SearchParams request = new AddressRequest(HATFIELD);
        
        final String functionName = "myFuncyFunc";
        request.setCallBack(functionName);
        String response = factory.getString(request);
        assertTrue(response.startsWith(functionName));
    }

    @Test
    public void testIndent() {
        AddressRequest request = new AddressRequest(HATFIELD);        
        request.setIndent(Boolean.TRUE);
        String response = factory.getString(request);
        assertNotNull(response);

        String[] lines = response.split("\r\n|\r|\n");
        assertTrue(lines.length > 25);
    }

    @Test
    public void testAddressComponentParsing() throws JSONException {
        AddressRequest params = new AddressRequest(HATFIELD);
        
        
        params.addGroup(GeocodeGroupOption.addressComponent);
        String response = factory.getString(params);
        JSONObject obj = new JSONObject(response);
        JSONArray arr = obj.getJSONArray("results");
        JSONObject first = arr.getJSONObject(0);
        JSONArray addressComponents = first.getJSONArray("address_components");
        assertTrue(addressComponents.length() > 2);

        // Just make sure the parsing still works.
        AddressResponse deserializedResponse = factory.get(params);
        assertNotNull(deserializedResponse);

    }

    

    @Test
    public void testAddressGeometry() throws JSONException {
        AddressRequest params = new AddressRequest(HATFIELD);
        
        
        params.addGroup(GeocodeGroupOption.geometry);
        String response = factory.getString(params);
        JSONObject obj = new JSONObject(response);
        JSONArray arr = obj.getJSONArray("results");
        JSONObject first = arr.getJSONObject(0);
        JSONObject metaData = first.getJSONObject("geometry");
        assertTrue(metaData.length() > 1);

        // Just make sure the parsing still works.
        AddressResponse deserializedResponse = factory.get(params);
        assertNotNull(deserializedResponse);

    }
    
    @Test
    public void testMetaInfoInResponse() {
        AddressResponse response =
                factory.get(AddressRequest.build(HATFIELD));

        assertNotNull(response.getQtime());
        assertTrue(response.getQtime() > 0);
        
        assertNotNull(response.getStatus());
        assertEquals("OK", response.getStatus());
        
        assertNotNull (response.getNumberOfRecords());
        assertTrue(response.getNumberOfRecords() > 0);

    }
    
    @Test
    public void testAddressGeometryParsing() throws JSONException {
        AddressRequest params = new AddressRequest(HATFIELD);
        
        params.addGroup(GeocodeGroupOption.geometry);
        String response = factory.getString(params);
        JSONObject obj = new JSONObject(response);
        JSONArray arr = obj.getJSONArray("results");
        JSONObject first = arr.getJSONObject(0);
        JSONObject metaData = first.getJSONObject("geometry");
        assertTrue(metaData.length() > 1);

        // Just make sure the parsing still works.
        AddressResponse deserializedResponse = factory.get(params);
        assertNotNull(deserializedResponse);
        LocationResult firstAddress = deserializedResponse.listResults().get(0);
        assertNotNull (firstAddress);
        
        Geometry geom = firstAddress.getGeometry();
        assertNotNull(geom);
        assertNotNull (geom.getLocation());
        assertNotNull (geom.getLocation().getLatitude());
        assertNotNull (geom.getLocation().getLongitude());
        assertNotNull (geom.getViewport());
        assertNotNull (geom.getViewport().getNortheast());
        assertNotNull (geom.getViewport().getSouthwest());
        
        assertNotNull (geom.getBounds ());
        assertNotNull (geom.getBounds ().getNortheast());
        assertNotNull (geom.getBounds ().getSouthwest());        

    }
    
    @Test
    public void testAddressComponentRequest() throws JSONException {
        AddressRequest params = new AddressRequest(HATFIELD);
        
        
        params.addGroup(GeocodeGroupOption.addressComponent);

        // Just make sure the parsing still works.
        AddressResponse deserializedResponse = factory.get(params);
        assertNotNull(deserializedResponse);
        
        LocationResult first = deserializedResponse.listResults().get(0);
        assertNotNull (first.getAddressComponents());
        assertFalse (first.getAddressComponents().isEmpty());
        assertNotNull(first.getAddressComponents().get(0));
        AddressComponent comp = first.getAddressComponents().get(0);
        assertNotNull (comp.getAdministrativeType());
        assertNotNull (comp.getGisId());
        assertNotNull (comp.getShortName());

    }

}
