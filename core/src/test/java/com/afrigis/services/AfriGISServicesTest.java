package com.afrigis.services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afrigis.services.test.util.TestUtil;

public class AfriGISServicesTest {

    private static final Logger LOG = LoggerFactory.getLogger(AfriGISServicesTest.class);

   
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {        
    }

    @Test
    public void testCommercialKey() {
        ServiceCallFactory testFactory = AfriGISServices.instance(TestUtil.getKey(),
                TestUtil.getSecret());
        assertNotNull(testFactory);

        
        assertTrue(testFactory.getCreditBalance() > 0);

        LOG.info("ServiceCallFactory - commercial key - set up OK");
    }
    
    @Before
    public void before ()
    {
        ServiceCallFactory testFactory = AfriGISServices.instance(TestUtil.getKey(),
                TestUtil.getSecret());
        testFactory.setServiceEndpoint("https://saas.afrigis.co.za/rest/2/");
    }

   

    @Test
    public void testCreditBalanceForCommercialKey() {
        ServiceCallFactory testFactory = AfriGISServices.instance(TestUtil.getKey(),
                TestUtil.getSecret());
        assertNotNull(testFactory);
        
        Integer credits = testFactory.getCreditBalance();

        LOG.info("Credit result is: {}", credits);
        assertTrue("Expected non-zero credit balance, but got " + credits,credits > 0);

        LOG.info("Credit Balance check");
    }
    
   
    
    @Test
    public void testServerOverride () {
        
        ServiceCallFactory testFactory = AfriGISServices.instance(TestUtil.getKey(),TestUtil.getSecret());
        assertNotNull(testFactory);

        //This is NOT a valid setting, but we prove we do not molest the user provided input
        testFactory.setServiceEndpoint("saas.afrigis.co.za");
        assertEquals("saas.afrigis.co.za", testFactory.getServiceEndpoint());
        
        testFactory.setServiceEndpoint("http://saas.fake.co.za");                
        assertEquals( "http://saas.fake.co.za",testFactory.getServiceEndpoint());
        
        testFactory.setServiceEndpoint("https://saas.test.afrigis.co.za");
        assertEquals("https://saas.test.afrigis.co.za", testFactory.getServiceEndpoint());
        
        //Because we ASSUME this user KNOWS what they are doing!
        testFactory.setServiceEndpoint(null);  
        assertNull( testFactory.getServiceEndpoint());
        
    }
}
