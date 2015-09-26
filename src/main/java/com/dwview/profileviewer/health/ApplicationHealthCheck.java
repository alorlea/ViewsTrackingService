package com.dwview.profileviewer.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by Alberto on 2015-09-26.
 */
public class ApplicationHealthCheck extends HealthCheck {

    public ApplicationHealthCheck(){
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
