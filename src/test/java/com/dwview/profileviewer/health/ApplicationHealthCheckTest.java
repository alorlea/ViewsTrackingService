package com.dwview.profileviewer.health;

import com.codahale.metrics.health.HealthCheck;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alberto on 2015-09-26.
 */
public class ApplicationHealthCheckTest {

    @Test
    public void ApplicationIsHealthy() throws Exception {
        ApplicationHealthCheck healthCheck = new ApplicationHealthCheck();
        assertEquals(healthCheck.check(), HealthCheck.Result.healthy());
    }
}