package com.afrigis.services.addresssubmission;

import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.test.util.TestUtil;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Pieterv
 */
public class AddressSubmissionTest {

    protected static final Logger LOG = LoggerFactory.getLogger(AddressSubmissionTest.class);
    protected static final String ADDRESS = "446 Rigel Avenue";
    protected static final String ADDITIONALINFO = "The Location is wrong should be opposite Pick n Pay shops";
    private static ServiceCallFactory factory;
    private static ServiceCallFactory zeroFactory;
   private static final String SERVICE_ENDPOINT_BASE = "https://saasstaging.afrigis.co.za/rest/2/";
   
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        factory = AfriGISServices.instance(TestUtil.getKey(), TestUtil.getSecret());

    }

    @Before
    public void before() {
        factory.setServiceEndpoint(SERVICE_ENDPOINT_BASE);
        zeroFactory.setServiceEndpoint(SERVICE_ENDPOINT_BASE);
    }

    @Test
    public void testAddressSubmission() {
        LOG.info("Test AddressSubmission");
        AddressSubmissionRequest addressSubParams = new AddressSubmissionRequest(TestUtil.getKey(), ADDRESS, ADDITIONALINFO);
        AddressSubmissionResponse response = factory.get(addressSubParams);
        assertNotNull(response);
        
        List<AddressSubmissionResponse> addressSubmList = response.listResults();
        assertNotNull(addressSubmList);
        assertTrue(addressSubmList.size() >= 1);
        

    }

}
