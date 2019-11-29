package ie.gmit.ds;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import java.util.logging.Logger;

public class UserApiApplication extends Application<UserApiConfig> {
    private static final Logger logger = Logger.getLogger(UserApiApplication.class.getName());

    public static void main(String[] args) throws Exception {
        new UserApiApplication().run(args);
    }

    @Override
    public void run(UserApiConfig userApiConfig, Environment environment) throws Exception {
        logger.info("REST resource register");
        environment.jersey().register(new UserApiResource(environment.getValidator()));

        final UserHealthCheck healthCheck = new UserHealthCheck();
        environment.healthChecks().register("User", healthCheck);
    }
}
