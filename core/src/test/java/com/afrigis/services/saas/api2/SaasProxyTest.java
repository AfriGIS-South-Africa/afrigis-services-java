package com.afrigis.services.saas.api2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afrigis.services.KeyValue;
import com.afrigis.services.impl.GenericRequest;
import com.afrigis.services.impl.GenericResponse;
import com.afrigis.services.internal.saas.api2.SaasClient;
import com.afrigis.services.test.util.TestUtil;

/**
 * @deprecated please use  {@link com.afrigis.services.ServiceCallFactory} instead.
 * @author hendrikc
 *
 */
@Deprecated
public class SaasProxyTest {
	private static final String TEST_SAAS_SECRET = TestUtil.getSecret();

	private static final String TEST_SAAS_CLIENT_ID = TestUtil.getKey();
	private SaasClient proxy;

	@Before
	public void setUp() throws Exception {
		// http://saas.afrigis.co.za/Rest/?Request=Geocode&query=hatfield&from=0&numResults=25&key=REzjBU8DQfhBexTKmDSZs6xat6k=&message=face67df-0d84-4f6a-ad10-ed3994fac48e&clientid=1
		proxy = new SaasClient("https://saas.afrigis.co.za/rest/2");
		proxy.setSaasClient(TEST_SAAS_CLIENT_ID);
//		proxy.setSaasService();
		proxy.setSharedKey(new String(TEST_SAAS_SECRET).getBytes());
	}

	protected Logger getLog() {
		return LoggerFactory.getLogger(getClass());
	}

	@Test
	public void testDefaultResponse() {
		Collection<KeyValue> params =new ArrayList<KeyValue>();
		params.add(new KeyValue("ils_location", "hatfield, pretoria") );
		params.add(new KeyValue("ils_result_start", "0"));
		params.add(new KeyValue("ils_result_count", "1"));
		
		GenericResponse defResp = new GenericResponse();
		proxy.execute( GenericRequest.build("intiendols.basic.geocode.address",params) ,defResp);
		
		getLog().debug("Status: {}", defResp.toString());

		if (defResp.isError() || defResp.getError() != null) {
			getLog().debug("Error message: {}", defResp.getError().getMessage());
			fail("There seems to be a  server error " + defResp.getError().getMessage());
		}
		else {
			assertEquals(200, defResp.getHttpStatusCode());
			assertNotNull("Raw received data is null", defResp.getByteArray());
			assertTrue("Received raw data is empty", defResp.getByteArray().length > 0);

			try {
				JSONObject obj = new JSONObject(new String(defResp.getByteArray()));
				JSONArray arr = obj.getJSONArray("results");
				assertTrue("We were expecting actual data in the result array - something is fishy", arr.length() > 0);
			}
			catch (JSONException e) {
				fail("JSON Parsing failed - " + e.getMessage());

			}
		}

	}
	
	@Test
	public void testList() {
		List<KeyValue> params = new ArrayList<KeyValue>();
		params.add(new KeyValue("ils_location", "hatfield, pretoria"));
		params.add(new KeyValue("ils_result_start", "0"));
		params.add(new KeyValue("ils_result_count", "1"));
		params.add(new KeyValue("ils_result_count", "3"));
		
		
		GenericResponse defResp = new GenericResponse();
		proxy.execute( GenericRequest.build("intiendols.basic.geocode.address",params) ,defResp);
		
		getLog().debug("Status: {}", defResp.toString());

		if (defResp.isError() || defResp.getError() != null) {
			getLog().debug("Error message: {}", defResp.getError().getMessage());
			fail("There seems to be a  server error " + defResp.getError().getMessage());
		}
		else {
			assertEquals(200, defResp.getHttpStatusCode());
			assertNotNull("Raw received data is null", defResp.getByteArray());
			assertTrue("Received raw data is empty", defResp.getByteArray().length > 0);

			try {
				JSONObject obj = new JSONObject(new String(defResp.getByteArray()));
				JSONArray arr = obj.getJSONArray("results");
				assertTrue("We were expecting actual data in the result array - something is fishy", arr.length() > 0);
			}
			catch (JSONException e) {
				fail("JSON Parsing failed - " + e.getMessage());

			}
		}
	}
}
