package com.afrigis.services;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.afrigis.services.test.util.TestUtil;

public class Prove418HandlingCorrectTest {    
    

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Test
    public void test() {
         //For this to have value, please adjust your machine clock ahead (or back) with 5+ minutes.
        //If we are able to otain a valid credit balance, 418 handling worked.
        ServiceCallFactory factory = AfriGISServices.instance(TestUtil.getKey(), TestUtil.getSecret());
        
        //Ok, so basically, if we can get valid looking credits, then the 418 handling works.
        int credists = factory.getCreditBalance();
        assertTrue (credists >0);
        
        //TODO refactor factory stuff to enable subclasses and "corrupting" of system clock programmatically
    }
    

}
