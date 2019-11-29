package ie.gmit.ds;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import java.util.logging.Logger;

/**
 * The runner of the Dropwizard application.
 */
public class UserApiApplication extends Application<UserApiConfig> {
    private static final Logger logger = Logger.getLogger(UserApiApplication.class.getName());

    public static void main(String[] args) throws Exception {
        new UserApiApplication().run(args);
    }

    /**
     * Register resource class by Jersey and pass in environment validator.
     * Also do health check on the environment = http://localhost:8081/healthcheck
     *
     * @param userApiConfig the config
     * @param environment environment
     * @throws Exception
     */
    @Override
    public void run(UserApiConfig userApiConfig, Environment environment) throws Exception {
        logger.info("REST resource register");
        environment.jersey().register(new UserApiResource(environment.getValidator()));

        final UserHealthCheck healthCheck = new UserHealthCheck();
        environment.healthChecks().register("User", healthCheck);
    }
}
