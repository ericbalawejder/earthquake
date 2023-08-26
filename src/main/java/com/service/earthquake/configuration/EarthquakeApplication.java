package com.service.earthquake.configuration;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.service.earthquake.resource.DataResource;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.FilterRegistration;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import java.util.EnumSet;

public class EarthquakeApplication extends Application<EarthquakeConfiguration> {

  public static void main(String[] args) throws Exception {
    new EarthquakeApplication().run(args);
  }

  @Override
  public void initialize(Bootstrap<EarthquakeConfiguration> bootstrap) {
    bootstrap.getObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    bootstrap.getObjectMapper().setDateFormat(new StdDateFormat());
  }

  @Override
  public void run(EarthquakeConfiguration configuration, Environment environment) {
    final DataResource resource = new DataResource("earthquake.json");
    environment.jersey().register(resource);

    // Enable CORS headers
    final FilterRegistration.Dynamic cors = environment.servlets()
        .addFilter("CORS", CrossOriginFilter.class);

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
