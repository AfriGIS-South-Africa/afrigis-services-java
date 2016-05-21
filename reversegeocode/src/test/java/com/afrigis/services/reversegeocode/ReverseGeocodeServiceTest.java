/**
 * 
 */
package com.afrigis.services.reversegeocode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afrigis.services.AfriGISServices;
import com.afrigis.services.Coordinate;
import com.afrigis.services.KeyValue;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.reversegeocoding.AddressResult;
import com.afrigis.services.reversegeocoding.Layer;
import com.afrigis.services.reversegeocoding.Level;
import com.afrigis.services.reversegeocoding.ReverseGeocodeRequest;
import com.afrigis.services.reversegeocoding.ReverseGeocodeResponse;
import com.afrigis.services.test.util.TestUtil;

/**
 * <p>
 * Puts the reverse-geocoding service through it's paces.
 * </p>
 * 
 * @author hendrikc
 *
 */
public class ReverseGeocodeServiceTest {
    private static final String KNOWN_DOCID2 = "AG_TOWNS|3~945";
    private static final String KNOWN_DOCID = "AG_NAD|3~635~14586~586247";
    private static ServiceCallFactory serviceFactory;
    private static final Coordinate KNOWN_COORDINATE =
            new Coordinate(-26.099082946777344d, 28.063194d);

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

        serviceFactory = AfriGISServices.instance(TestUtil.getKey(),
                TestUtil.getSecret());
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
   
    @Test
    public void testReverseGeocodeCoordinate() throws Exception {
        log().info("Running testReverseGeocodeCoordinate");

        ReverseGeocodeRequest request = new ReverseGeocodeRequest(-25.806426d,28.248292d);
        
        ReverseGeocodeResponse response = serviceFactory.get(request);
        assertNotNull(response);
        assertNotNull(response.getByteArray());
        assertTrue(response.getByteArray().length > 10);
        assertNotNull(response.listResults());
        assertTrue(response.listResults().size() > 0);
        boolean foundExpectedDocId = false;
        
        List<AddressResult> addresses = response.listResults();

        for (AddressResult address : addresses) {
            assertNotNull (address.getLatitude());
            assertNotNull (address.getLongitude());
            
            Coordinate coord = address.getLocation();
            assertNotNull (coord);            
            
            assertEquals(address.getLatitude(), Double.valueOf(coord.getLatitude()));
            assertEquals(address.getLongitude(), Double.valueOf(coord.getLongitude()));
            
            if (address.getDocId().equals(KNOWN_DOCID)) {
                foundExpectedDocId = true;
                break;
            }
        }
        assertTrue("Could not find expected doc id " + KNOWN_DOCID,
                foundExpectedDocId);
    }

    @Test
    public void testReverseGeocodeCoordinateWithLimit() throws Exception {
        log().info("Running testReverseGeocodeCoordinateWithLimit");

        ReverseGeocodeRequest params =
                new ReverseGeocodeRequest(-24.896926d, 28.968292d);
        params.setNumResults(5);
        ReverseGeocodeResponse response =
                serviceFactory.get(params);
        assertNotNull(response);
        assertNotNull(response.getByteArray());
        assertTrue(response.getByteArray().length > 10);
        assertNotNull(response.listResults());
        assertTrue(response.listResults().size() > 2
                && response.listResults().size() <= 5);

    }

   
    @Test
    public void testReverseGeocodeCoordinateReverseGeocodeParameters() {
        log().info(
                "Running testReverseGeocodeCoordinateReverseGeocodeParameters");

        ReverseGeocodeRequest params =
                new ReverseGeocodeRequest(KNOWN_COORDINATE);
        params.setRadius(20);
        params.setLevel(Level.TOWN_5.level());

        params.setNumResults(5);

        ReverseGeocodeResponse response =
                serviceFactory.get( params);
        assertNotNull(response);
        assertNotNull(response.getByteArray());
        assertTrue(response.getByteArray().length > 10);
        assertNotNull(response.listResults());
        assertTrue(response.listResults().size() > 2);
        boolean foundExpectedDocId = false;
        
        List<AddressResult> addresses = response.listResults();

        for (AddressResult address : addresses) {
            if (address.getDocId().equals(KNOWN_DOCID2)) {
                foundExpectedDocId = true;
                break;
            }
        }
        assertTrue("Could not find expected doc id " + KNOWN_DOCID2,
                foundExpectedDocId);
    }

    @Ignore (value="Currently can not find ANY reason for this test to fail. It seems to be failing ONLY from the jenkins box. Temporarily ignoring this test until I can investigate further.")
    @Test
    public void testSettingLayerWithDefaultRadius() {
        log().info("Running testSettingLayerWithDefaultRadius");

        ReverseGeocodeRequest params =
                new ReverseGeocodeRequest(KNOWN_COORDINATE);
       
        params.setLayer(Layer.STREETS.toString());

        ReverseGeocodeResponse response = serviceFactory.get(params);
        assertNotNull(response);
        List<AddressResult> resutls = response.listResults();
        assertTrue(resutls.size() > 0);
        for (AddressResult reverseGeocodeAddress : resutls) {
            assertTrue(reverseGeocodeAddress.getDocId()
                    .contains(Layer.STREETS.toString()));
        }
    }

    @Test
    public void testSettingLayerWith1000tRadius() {
        log().info("Running testSettingLayerWithDefaultRadius");

        ReverseGeocodeRequest params =
                new ReverseGeocodeRequest(KNOWN_COORDINATE);
      
        params.setLayer(Layer.STREETS.toString());
        params.setRadius(1000);

        ReverseGeocodeResponse response = serviceFactory.get(params);
        assertNotNull(response);
        List<AddressResult> resutls = response.listResults();
        assertTrue(resutls.size() > 0);
        for (AddressResult reverseGeocodeAddress : resutls) {
            assertTrue(reverseGeocodeAddress.getDocId()
                    .contains(Layer.STREETS.toString()));
            assertTrue(reverseGeocodeAddress.getDistance() <= 1000);
        }
    }

    @Test
    public void testSettingLevel() {
        log().info("Running testSettingLayerWithDefaultRadius");

        ReverseGeocodeRequest params =
                new ReverseGeocodeRequest(KNOWN_COORDINATE);
       
        params.setLevel(Level.CROSSING_STREET_12.level());

        ReverseGeocodeResponse response = serviceFactory.get(params);
        assertNotNull(response);
        List<AddressResult> resutls = response.listResults();
        assertTrue(resutls.size() > 0);
        for (AddressResult reverseGeocodeAddress : resutls) {
            assertTrue(reverseGeocodeAddress.getDocId()
                    .contains(Layer.CROSSING_STREETS.toString()));
        }
    }

    @Test
    public void testIndentationRequest() throws Exception {
        log().info("Running testIndentationRequest");

        ReverseGeocodeRequest params =
                new ReverseGeocodeRequest(KNOWN_COORDINATE);
     
        params.setIndent(true);
        String response = serviceFactory.getString(params);
        assertNotNull(response);

        String[] lines = response.split("\r\n|\r|\n");
        assertTrue(lines.length > 10);

        // Just make sure it IS valid json
        JSONObject obj = new JSONObject(response);
        assertNotNull(obj);

    }

    @Test
    public void testCallback() {
        ReverseGeocodeRequest params =
                new ReverseGeocodeRequest(KNOWN_COORDINATE);
      
        final String functionName = "myFuncyFunc";
        params.setCallBack(functionName);

      

        String response = serviceFactory.getString(params);
        assertTrue(response.startsWith(functionName));
    }

    private Logger log() {
        return LoggerFactory.getLogger(getClass());
    }
    
    @Test
    public void testMetaInfo () {
        ReverseGeocodeRequest params =
                new ReverseGeocodeRequest(KNOWN_COORDINATE);
       
        params.setLevel(Level.CROSSING_STREET_12.level());

        ReverseGeocodeResponse response = serviceFactory.get(params);
        
        assertNotNull (response.getQtime());
        assertTrue (response.getQtime() > 0);
        
        assertNotNull (response.getResponseMessage());        
        
        assertNotNull (response.getResponseCode());
        assertEquals (response.getResponseCode().intValue(),0);
        
        assertNotNull (response.getCount());
        assertTrue (response.getCount() > 0);
    }
    
    @Test
    public void testExtraParams () {
        ReverseGeocodeRequest params =
                new ReverseGeocodeRequest(KNOWN_COORDINATE);
        
        Collection<KeyValue> extras = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            extras.add(new KeyValue(Integer.toString(i),Integer.toString(rand.nextInt())));
        }
        
        params.setExtraParameters(extras);
        String queryString = params.toQueryString();
        
        for (KeyValue keyValue : extras) {
            String keyValPair = keyValue.getKey() + "=" + keyValue.getValue();
            assertTrue (queryString.contains(keyValPair));
        }
    }
    
    @Test
    public void testResultCountOnAlternateCoordinate ()
    {
        Coordinate altCoord=  new Coordinate(-33.015127d, 27.912752d);
        ReverseGeocodeRequest request = new ReverseGeocodeRequest(altCoord);
        request.setNumResults(3);
        request.setLevel(Level.STREETS_11.level());
        ReverseGeocodeResponse response = serviceFactory.get(request);
        
        
        assertTrue (response.listResults().size() > 2);
    }

}
