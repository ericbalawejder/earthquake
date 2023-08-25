package com.service.earthquake.db;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.service.earthquake.entity.Earthquake;
import com.service.earthquake.entity.RawEarthquake;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class EarthquakeDataService {

  private final List<Earthquake> earthquakes;

  public EarthquakeDataService(String filePath) {
    this.earthquakes = getEarthquakeData(getRawEarthquakeData(filePath));
  }

  public List<Earthquake> getEarthquakes() {
    return List.copyOf(earthquakes);
  }

  private List<Earthquake> getEarthquakeData(List<RawEarthquake> rawEarthquakes) {
    return rawEarthquakes.stream()
        .map(mapRawEarthquakeToEarthquake)
        .toList();
  }

  private List<RawEarthquake> getRawEarthquakeData(String filePath) {
    try (InputStream jsonInputStream = getClass().getResourceAsStream(filePath)) {
      return new ObjectMapper().readValue(jsonInputStream, new TypeReference<>() {
      });
    } catch (IOException ioException) {
      throw new RuntimeException(ioException);
    }
  }

  private final Function<RawEarthquake, Earthquake> mapRawEarthquakeToEarthquake = rawEarthquake -> new Earthquake(
      convertStringToDate(rawEarthquake.getTime()),
      rawEarthquake.getLatitude(),
      rawEarthquake.getLongitude(),
      rawEarthquake.getDepth(),
      rawEarthquake.getMagnitude(),
      rawEarthquake.getMagType(),
      rawEarthquake.getId(),
      rawEarthquake.getPlace(),
      rawEarthquake.getType());

  private Date convertStringToDate(String time) {
    try {
      return new StdDateFormat().parse(time);
    } catch (ParseException parseException) {
      throw new RuntimeException(parseException);
    }
  }

}
