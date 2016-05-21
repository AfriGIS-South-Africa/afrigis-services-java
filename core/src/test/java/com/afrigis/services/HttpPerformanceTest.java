package com.afrigis.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afrigis.services.test.util.TestUtil;

public class HttpPerformanceTest {
    static ServiceCallFactory factory;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        factory = AfriGISServices.instance(TestUtil.getKey(),
                TestUtil.getSecret());
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    private long run(int howManyRequest) {
        long start = System.currentTimeMillis();
        List<Future<Integer>> promises = new ArrayList<>();
        List<Integer> creditChecks = new ArrayList<>();
        for (int i = 0; i < howManyRequest; i++) {
            Future<Integer> aPromise = factory.getCreditBalanceAsync();
            promises.add(aPromise);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
               log().warn("InterruptedException",e);
            }
        }

        log().debug("Starting batch (length: {})", promises.size());
        for (Future<Integer> future : promises) {
            try {
                Integer ballance = future.get(20, TimeUnit.SECONDS);
                assertTrue(ballance > 0);
                creditChecks.add(ballance);                

            } catch (Exception e) {
                log().error("Failed to obtain credits", e);

            }
        }
        assertEquals(creditChecks.size(), promises.size());
        long diff = System.currentTimeMillis() - start;
        return diff;
    }

    /**
     * <p>
     * Executes 5 batches of 200 async "getCredits" requests, and records the results. 
     * </p>
     * <p>
     * Some basic validation is done along the way.
     * </p>
     * <p>
     * Using this test, and changing the internal http client connection
     * manager, I was able to obtain the following results:
     * </p>
     * 
     * <pre>
     * Pooled connection (max 4 per route, 200 total)
     *================================================
     * Total run time: 19.977 seconds. Avg per batch: 3995.4
     * Total run time: 17.729 seconds. Avg per batch: 3545.8
     * Total run time: 17.8 seconds. Avg per batch: 3560.0
     *
     * Default http client
     * ======================
     * Total run time: 42.742 seconds. Avg per batch: 8548.4
     * Total run time: 33.545 seconds. Avg per batch: 6709.0
     * Total run time: 33.17 seconds. Avg per batch: 6634.0
     * </pre>
     * 
     * <p>
     * Test is marked as ignored, since we can't run it internally without server rate 
     * limiting kicking in - which causes the sucker to fail
     * </p>
     */
    @Test
    @Ignore
    public void test() {
        final int batchVolume = 200;
        final int batchCount = 5;

        long cummulativeTime = 0;

        for (int i = 0; i < batchCount; i++) {
            long batchTime = run(batchVolume);
            cummulativeTime += batchTime;
            log().info("Batch {} complete in {} millis ({} seconds)", i,
                    batchTime, batchTime / 1000.0);
        }

        log().info("Total run time: {} seconds. Avg per batch: {}",
                cummulativeTime / 1000.0,
                cummulativeTime / (double) batchCount);

    }

    private Logger log() {
        return LoggerFactory.getLogger(getClass());
    }

}
