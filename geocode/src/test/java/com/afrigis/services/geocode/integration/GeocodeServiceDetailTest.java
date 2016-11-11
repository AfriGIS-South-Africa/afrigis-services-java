package com.afrigis.services.geocode.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ConfidenceLevel;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.geocode.DetailsRequest;
import com.afrigis.services.geocode.DetailsResponse;
import com.afrigis.services.geocode.GeocodeGroupOption;
import com.afrigis.services.geocode.LocationResult;
import com.afrigis.services.geocode.impl.GeocodeDetailsResponseImpl;
import com.afrigis.services.test.util.TestUtil;

public class GeocodeServiceDetailTest {

    protected static final String KNOWN_SEOID = "CA155b0E010101010b305c_32302D5345502D3134";

    protected static final String KNOWN_DOCID = "AG_NAD|3~635~14628~494145";

    protected static final String _446_RIGEL = "446 Rigel";

    protected static final String HATFIELD = "Hatfield";
    private static ServiceCallFactory factory;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

        factory = AfriGISServices.instance(TestUtil.getKey(), TestUtil.getSecret());

    }

    @Test
    public void testDetailsCallback() {
        final String functionName = "myFuncyFunc" + Math.random();
        DetailsRequest detailParams = new DetailsRequest(KNOWN_DOCID);

        detailParams.setCallBack(functionName);

        String response = factory.getString(detailParams);
        assertTrue(response.startsWith(functionName));
    }

    @Test
    public void testGetDetailsWithDocId() throws Exception {
        log().info("Running testGetDetailsWithDocId");

        DetailsRequest params = new DetailsRequest(KNOWN_DOCID);

        DetailsResponse response = factory.get(params);
        assertNotNull(response);

        List<LocationResult> detailList = response.listResults();
        for (LocationResult geocodeDetail : detailList) {
            String docId = geocodeDetail.getDocId();
            assertNotNull(geocodeDetail.getConfidence());
            assertFalse(ConfidenceLevel.unknown.equals(geocodeDetail.getConfidence()));
            assertNotNull(geocodeDetail.getLevel());
            assertNotNull(geocodeDetail.getTypes());
            assertFalse(geocodeDetail.getTypes().isEmpty());
            assertNotNull(docId);
        }
    }

    @Test
    public void testGetDetailsWithDocIdAndIndenting() throws Exception {
        log().info("Running testGetDetailsWithDocIdAndIndenting");

        DetailsRequest params = new DetailsRequest(KNOWN_DOCID);
        params.setIndent(Boolean.TRUE);

        String response = factory.getString(params);
        assertNotNull(response);

        String[] lines = response.split("\r\n|\r|\n");
        assertTrue(lines.length > 10);

        JSONObject obj = new JSONObject(response);
        assertNotNull(obj);

    }

    @Test
    public void testGetDetailsWithSeoid() throws Exception {
        log().info("Running testGetDetails");

        DetailsRequest params = new DetailsRequest(KNOWN_SEOID);

        DetailsResponse response = factory.get(params);
        assertNotNull(response);

        List<LocationResult> addresse = response.listResults();

        LocationResult first = addresse.get(0);

        String seoid = first.getSeoId();
        assertNotNull(seoid);
        assertEquals(KNOWN_SEOID, seoid);
    }

    protected Logger log() {
        return LoggerFactory.getLogger(getClass());
    }

    @Test
    public void testDetailsWithAddressComponents() throws JSONException {

        DetailsRequest detailParams = new DetailsRequest(KNOWN_DOCID);

        detailParams.addGroup(GeocodeGroupOption.addressComponent);

        String response = factory.getString(detailParams);

        JSONObject obj = new JSONObject(response);
        JSONArray arr = obj.getJSONArray("results");
        JSONObject first = arr.getJSONObject(0);
        JSONArray address_components = first.getJSONArray("address_components");
        assertNotNull(address_components);
        assertTrue(address_components.length() > 2);
    }

    @Test
    public void testDetailsWithGeometry() throws JSONException {

        DetailsRequest detailParams = new DetailsRequest(KNOWN_DOCID);

        detailParams.addGroup(GeocodeGroupOption.geometry);

        String response = factory.getString(detailParams);

        JSONObject obj = new JSONObject(response);
        JSONArray arr = obj.getJSONArray("results");
        JSONObject first = arr.getJSONObject(0);
        JSONObject geometry = first.getJSONObject("geometry");
        assertNotNull(geometry);
        assertTrue(geometry.length() > 1);
    }

    @Test(expected = AfriGISServicesException.class)
    public void testResponse403Handling() throws IOException {
        InputStream in = getClass().getResourceAsStream("/serverresponses/403.response");

        DetailsResponse response = new GeocodeDetailsResponseImpl();
        // SaaS almost always return http 200.
        response.consume(in, 200);

        try {
            response.completeBuild();

            fail("We should have hit an AfriGISException.");
        } catch (Exception e) {
            assertEquals("You are not Authorized to implement this WebMethod", e.getMessage());
            throw e;
        } finally {
            IOUtils.closeQuietly(in);
        }

    }

    @Test(expected = AfriGISServicesException.class)
    public void testGenericResponse402Handling() throws IOException {
        InputStream in = getClass().getResourceAsStream("/serverresponses/402.response");

        DetailsResponse response = new GeocodeDetailsResponseImpl();
        // SaaS almost always return http 200.
        response.consume(in, 200);

        try {
            response.completeBuild();

            fail("We should have hit an AfriGISException.");
        } catch (Exception e) {
            assertEquals("Insufficient Credits", e.getMessage());
            throw e;
        } finally {
            IOUtils.closeQuietly(in);
        }

    }

    @Test(expected = AfriGISServicesException.class)
    public void testGenericResponse401Handling() throws IOException {
        InputStream in = getClass().getResourceAsStream("/serverresponses/401.response");

        DetailsResponse response = new GeocodeDetailsResponseImpl();
        // SaaS almost always return http 200.
        response.consume(in, 200);

        try {
            response.completeBuild();

            fail("We should have hit an AfriGISException.");
        } catch (Exception e) {
            assertEquals("Invalid Authentication", e.getMessage());
            throw e;
        } finally {
            IOUtils.closeQuietly(in);
        }

    }

    @Test(expected = InvalidParameterException.class)
    public void testRequiredInvalidParamNull() {
        DetailsRequest request = new DetailsRequest(null);
        fail("We successfully constructed a DetailsRequest (" + request + ") when we should not have been able to");
    }

    @Test(expected = InvalidParameterException.class)
    public void testRequiredInvalidParamEmptyString() {
        DetailsRequest request = new DetailsRequest("");
        fail("We successfully constructed a DetailsRequest (" + request + ") when we should not have been able to");
    }

}
