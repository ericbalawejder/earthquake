package com.service.earthquake.configuration;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.service.earthquake.resource.DataResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;

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

        // Enable CORS headers
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }

    @Override
    public String getName() {
        return "Earthquake Data Service";
    }
}
