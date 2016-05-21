package com.afrigis.services.reversegeocode;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.afrigis.services.AfriGISServices;
//import com.afrigis.services.Coordinate;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.reversegeocoding.AddressResult;
import com.afrigis.services.reversegeocoding.ReverseGeocodeRequest;
import com.afrigis.services.reversegeocoding.ReverseGeocodeResponse;
import com.afrigis.services.test.util.TestUtil;

public class ReverseGeocodeServiceZeroCredTest {
    
    private static ServiceCallFactory serviceFactory;
//    private static final Coordinate KNOWN_COORDINATE =
//            new Coordinate(-26.099082946777344d, 28.063194d);

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        serviceFactory = AfriGISServices.instance(TestUtil.getZeroCreditKey(),
                TestUtil.getZeroCreditSecret());
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Test(expected=AfriGISServicesException.class)
    public void testZeroCredBalanceCommercial() {
        ReverseGeocodeRequest request = new ReverseGeocodeRequest(-25.806426,28.248292);
        ReverseGeocodeResponse response = serviceFactory.get(request);
        assertNotNull(response);
        List<AddressResult> results = response.listResults();
        assertNotNull(results);
        assertEquals (0, results.size());
    }

}
