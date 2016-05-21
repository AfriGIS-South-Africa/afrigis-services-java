package com.afrigis.services;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.impl.GenericRequest;
import com.afrigis.services.impl.GenericResponse;
import com.afrigis.services.test.util.TestUtil;

public class GenericServiceTest {

    private static ServiceCallFactory factory;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        factory = AfriGISServices.instance(TestUtil.getKey(),
                TestUtil.getSecret());
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Test
    public void testGenericServiceBuildUrl() {
        Collection<KeyValue> params = new ArrayList<>();
        params.add(new KeyValue("ils_location", "Hatfield"));
        params.add(new KeyValue("ils_result_count", "2"));
        Request genReq = GenericRequest
                .build("intiendols.basic.geocode.address", params);
        String url = factory.buildUrl(genReq);
        /*
         * URL should look something like this:
         * https://saas.afrigis.co.za/rest/2/intiendols.basic.geocode.address/
         * 5B55B5B835/kZnDGnLE_u4Cj8EGJ2Ncriw3KiY/1447846478/?ils_location=
         * Hatfield&ils_result_count=2&libmode=url&libplat=java&libver=0.0.9-
         * SNAPSHOT
         */
        assertTrue(url.contains("intiendols.basic.geocode.address"));
        assertTrue(
                url.matches(".+/" + TestUtil.getKey() + "/.{5,}/\\d{10,}/.+"));
        log().debug("Got this url: '{}'", url);
    }

    @Test
    public void testGenericServiceBuildUrlStringVersion() {

        Request genReq =
                GenericRequest.build("intiendols.basic.geocode.address",
                        "ils_location=Hatfield&ils_result_count=2");
        
        String url = factory.buildUrl(genReq);
        /*
         * URL should look something like this:
         * https://saas.afrigis.co.za/rest/2/intiendols.basic.geocode.address/
         * 5B55B5B835/kZnDGnLE_u4Cj8EGJ2Ncriw3KiY/1447846478/?ils_location=
         * Hatfield&ils_result_count=2&libmode=url&libplat=java&libver=0.0.9-
         * SNAPSHOT
         */
        assertTrue(url.contains("intiendols.basic.geocode.address"));
        assertTrue(
                url.matches(".+/" + TestUtil.getKey() + "/.{5,}/\\d{10,}/.+"));
        log().debug("Got this url: '{}'", url);
    }
    
    @Test
    public void testGenericServiceGetString() throws JSONException {

        Request genReq =
                GenericRequest.build("intiendols.basic.geocode.address",
                        "ils_location=Hatfield&ils_result_count=2");
        
        String response = factory.getString(genReq);
        assertTrue (response.contains("docid"));
        assertTrue (response.contains("formatted_address"));
        JSONObject json = new JSONObject(response);
        assertNotNull(json);
        
    }

    @Test
    public void testGenericServiceGetStringQeuryStringVersion() throws JSONException {
        String content = factory.getString("intiendols.basic.geocode.address",
                "ils_location=Hatfield&ils_result_count=2");
        assertNotNull(content);
        JSONObject json = new JSONObject(content);
        assertNotNull(json);
    }

    private Logger log() {
        return LoggerFactory.getLogger(getClass());
    }
    
    @Test (expected=AfriGISServicesException.class)    
    public void testGenericResponse401Handling () throws IOException {
        InputStream  in =getClass().getResourceAsStream("/serverresponses/401.response");
        
        GenericResponse response = new GenericResponse();
        //SaaS almost always return http 200.
        response.consume(in, 200);
        
        try {
            response.completeBuild();
        
            fail("We should have hit an AfriGISException.");
        }
        catch (Exception e) {
            assertEquals("Invalid Authentication", e.getMessage());
            throw e;
        }
        finally {
            IOUtils.closeQuietly(in);
        }
        
    }
    
    @Test
    public void testByteArrayGetting () throws JSONException {
        Collection<KeyValue> params = new ArrayList<>();
        params.add(new KeyValue("ils_location", "Hatfield"));
        params.add(new KeyValue("ils_result_count", "2"));
        params.add(new KeyValue("abc", "xyz"));
        
        byte [] content = factory.getByteArray(GenericRequest.build("intiendols.basic.geocode.address", params));
        assertNotNull(content);
        assertTrue (content.length > 0);
        JSONObject json = new JSONObject(StringUtils.newStringUtf8(content));
        assertNotNull(json);
        String serializedAgain = json.toString();
        assertTrue (serializedAgain.contains("Hatfield"));
    }
    
    @Test (expected=AfriGISServicesException.class)    
    public void testGenericResponse402Handling () throws IOException {
        InputStream  in =getClass().getResourceAsStream("/serverresponses/402.response");
        
        GenericResponse response = new GenericResponse();
        //SaaS almost always return http 200.
        response.consume(in, 200);
        
        try {
            response.completeBuild();
        
            fail("We should have hit an AfriGISException.");
        }
        catch (Exception e) {
            assertEquals("Insufficient Credits", e.getMessage());
            throw e;
        }
        finally {
            IOUtils.closeQuietly(in);
        }
        
    }
    
    @Test (expected=AfriGISServicesException.class)    
    public void testGenericResponse403Handling () throws IOException {
        InputStream  in =getClass().getResourceAsStream("/serverresponses/403.response");
        
        GenericResponse response = new GenericResponse();
        //SaaS almost always return http 200.
        response.consume(in, 200);
        
        try {
            response.completeBuild();
        
            fail("We should have hit an AfriGISException.");
        }
        catch (Exception e) {
            assertEquals ("You are not Authorized to implement this WebMethod",e.getMessage());
            throw e;
        }
        finally {
            IOUtils.closeQuietly(in);
        }
        
    }
    
    @Test
    public void testObjectGetting () throws JSONException {
        Collection<KeyValue> params = new ArrayList<>();
        params.add(new KeyValue("ils_location", "Hatfield"));
        params.add(new KeyValue("ils_result_count", "2"));
        params.add(new KeyValue("abc", "xyz"));
        
        GenericResponse response = factory.get(GenericRequest.build("intiendols.basic.geocode.address", params));
        assertNotNull(response);
        
        JSONObject json = new JSONObject(response.toString());
        assertNotNull(json);
        String serializedAgain = json.toString();
        assertTrue (serializedAgain.contains("Hatfield"));
    }

}
