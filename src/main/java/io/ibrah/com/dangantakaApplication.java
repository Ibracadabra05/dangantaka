package io.ibrah.com;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.ibrah.com.resources.UserResource;

public class dangantakaApplication extends Application<dangantakaConfiguration> {

    public static void main(final String[] args) throws Exception {
        new dangantakaApplication().run(args);
    }

    @Override
    public String getName() {
        return "dangantaka";
    }

    @Override
    public void initialize(final Bootstrap<dangantakaConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final dangantakaConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new UserResource());
    }

}
