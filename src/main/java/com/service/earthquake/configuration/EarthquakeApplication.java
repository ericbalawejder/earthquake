package com.service.earthquake.configuration;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class EarthquakeApplication extends Application<EarthquakeConfiguration> {

    public static void main(String[] args) throws Exception {
        new EarthquakeApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<EarthquakeConfiguration> bootstrap) {
    }

    @Override
    public void run(EarthquakeConfiguration configuration, Environment environment) {
    }

    @Override
    public String getName() {
        return "Earthquake Data Service";
    }
}
