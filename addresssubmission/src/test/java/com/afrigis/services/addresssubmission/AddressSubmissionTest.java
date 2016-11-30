package com.afrigis.services.addresssubmission;

import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;
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
    protected static final String CLIENTID = "5B55B5B835";
    protected static final String ADDRESS = "446 Rigel Avenue";
    protected static final String ADDITIONALINFO = "The Location is wrong should be opposite Pick n Pay shops";
    private static ServiceCallFactory factory;
    private static ServiceCallFactory zeroFactory;
   private static final String SERVICE_ENDPOINT_BASE = "https://saasstaging.afrigis.co.za/rest/2/";
   
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        zeroFactory = AfriGISServices.instance("76efefcda8", "ZERO");
        //factory = AfriGISServices.instance(TestUtil.getKey(), TestUtil.getSecret());
        factory = AfriGISServices.instance("5B55B5B835", "D3vT35t");
   

    }

    @Before
    public void before() {
        factory.setServiceEndpoint(SERVICE_ENDPOINT_BASE);
        zeroFactory.setServiceEndpoint(SERVICE_ENDPOINT_BASE);
    }

    @Test
    public void testAddressSubmission() {
        LOG.info("Test AddressSubmission");
        AddressSubmissionRequest addressSubParams = new AddressSubmissionRequest(CLIENTID, ADDRESS, ADDITIONALINFO);
        AddressSubmissionResponse response = factory.get(addressSubParams);
        assertNotNull(response);
        
        List<AddressSubmissionResult> addressSubmList = response.listResults();
        assertNotNull(addressSubmList);
        assertTrue(addressSubmList.size() >= 1);
        

    }

}
