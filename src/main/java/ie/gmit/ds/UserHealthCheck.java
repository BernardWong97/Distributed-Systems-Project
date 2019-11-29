package ie.gmit.ds;

import com.codahale.metrics.health.HealthCheck;

/**
 * A health check to check if the Dropwizard application is running correctly.
 * http://localhost:8081/healthcheck
 */
public class UserHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
