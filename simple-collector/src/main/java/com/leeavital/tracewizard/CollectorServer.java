package com.leeavital.tracewizard;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

public class CollectorServer extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new CollectorServer().run(args);
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.jersey().register(CollectResource.class);
    }
}
