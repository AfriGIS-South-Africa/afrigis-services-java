/**
 * 
 */
package com.afrigis.services.token.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Future;

import org.apache.commons.io.IOUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.exceptions.AfriGISServicesException;
import com.afrigis.services.test.util.TestUtil;
import com.afrigis.services.token.TokenResponse;
import com.afrigis.services.token.impl.DefaultTokenParameters;
import com.afrigis.services.token.impl.DefaultTokenResponse;

/**
 * @author hendrikc
 *
 */
public class TokenServiceTest {

    private static final Logger LOG =
            LoggerFactory.getLogger(TokenServiceTest.class);

    private static ServiceCallFactory factory;

    /**
     * @throws java.lang.Exception
     *             you know...when things explode.
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        factory = AfriGISServices.instance(TestUtil.getKey(),
                TestUtil.getSecret());
    }

    /**
     * @throws java.lang.Exception
     *             if things go wrong...this is thrown...
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    @Test
    public void testToken() throws Exception {

        TokenResponse response = factory.get(new DefaultTokenParameters());
        assertNotNull(response);
        assertNotNull(response.getToken());
        assertNotNull(response.getToken());
        assertTrue(response.getToken().length() == 36);
    }

    @Test
    public void testTokenAsync() throws Exception {

        // TokenService service = (TokenService) factory
        // .getService(TokenRequest.class, TokenResponse.class);
        //
        // assertNotNull(service);
        //
        long startTime = System.currentTimeMillis();
        Future<TokenResponse> response =
                factory.getAsync(new DefaultTokenParameters());
        assertNotNull(response);
        assertFalse(response.isCancelled());
        assertFalse(response.isDone());

        while (!response.isDone()) {
            long diff = System.currentTimeMillis() - startTime;
            LOG.debug(
                    "Token not received yet, wait 1 second. Have already waited {} seconds",
                    (diff / 1000.0));
            Thread.sleep(1000);
            if (diff > 30000) {
                LOG.debug("Patience exhausted, breaking loop");
                // Have to kill the test at some point,and 30sec is waaaaaaaaay
                // to long to wait for a token
                break;
            }
        }
        assertTrue(response.isDone());
        TokenResponse tokResp = response.get();
        LOG.debug("Got token response: {}", tokResp);

        assertNotNull(tokResp.getToken());
        assertTrue(tokResp.getToken().length() == 36);
    }
    
    @Test (expected=AfriGISServicesException.class)    
    public void testGenericResponse401Handling () throws IOException {
        InputStream  in =getClass().getResourceAsStream("/serverresponses/401.response");
        
        TokenResponse response = new DefaultTokenResponse();
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
    
    @Test (expected=AfriGISServicesException.class)    
    public void testGenericResponse402Handling () throws IOException {
        InputStream  in =getClass().getResourceAsStream("/serverresponses/402.response");
        
        TokenResponse response = new DefaultTokenResponse();
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
        
        TokenResponse response = new DefaultTokenResponse();
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
}
