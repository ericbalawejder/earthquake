package com.service.earthquake.db;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.service.earthquake.entity.Earthquake;
import com.service.earthquake.entity.RawEarthquake;
import com.service.earthquake.exception.EarthquakeDateParseException;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class EarthquakeDataService {

  private final List<Earthquake> earthquakes;

  public EarthquakeDataService(String filePath) throws IOException {
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

  private List<RawEarthquake> getRawEarthquakeData(String filePath) throws IOException {
    final InputStream jsonInputStream = getClass().getResourceAsStream(filePath);
    final ObjectMapper objectMapper = new ObjectMapper();

    return objectMapper.readValue(jsonInputStream, new TypeReference<>() {
    });
  }

  private final Function<RawEarthquake, Earthquake> mapRawEarthquakeToEarthquake
      = rawEarthquake -> {

    try {
      return new Earthquake(
          convertStringToDate(rawEarthquake.getTime()),
          rawEarthquake.getLatitude(),
          rawEarthquake.getLongitude(),
          rawEarthquake.getDepth(),
          rawEarthquake.getMagnitude(),
          rawEarthquake.getMagType(),
          rawEarthquake.getId(),
          rawEarthquake.getPlace(),
          rawEarthquake.getType());
    } catch (ParseException e) {
      e.printStackTrace();
      throw new EarthquakeDateParseException("can not parse date from type RawEarthquake");
    }
  };

  private Date convertStringToDate(String time) throws ParseException {
    final StdDateFormat dateFormat = new StdDateFormat();
    return dateFormat.parse(time);
  }

}
