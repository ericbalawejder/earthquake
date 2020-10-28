package com.service.earthquake.configuration;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.service.earthquake.resource.DataResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class EarthquakeApplication extends Application<EarthquakeConfiguration> {

    public static void main(String[] args) throws Exception {
        new EarthquakeApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<EarthquakeConfiguration> bootstrap) {
        bootstrap.getObjectMapper()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        bootstrap.getObjectMapper().setDateFormat(new ISO8601DateFormat());
    }

    @Override
    public void run(EarthquakeConfiguration configuration, Environment environment) {
        final DataResource resource = new DataResource();
        environment.jersey().register(resource);
    }

    @Override
    public String getName() {
        return "Earthquake Data Service";
    }
}
