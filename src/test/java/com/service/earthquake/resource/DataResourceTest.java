package com.service.earthquake.resource;

import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.service.earthquake.db.EarthquakeDataService;
import com.service.earthquake.entity.Earthquake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DataResourceTest {

  EarthquakeDataService earthquakeDataService;
  DataResource dataResource;

  @BeforeEach
  void setUp() throws IOException {
    dataResource = new DataResource("test.json");
    earthquakeDataService = new EarthquakeDataService(dataResource.getFileName());
  }

  @Test
  void getEarthquakes() throws IOException, ParseException {
    Earthquake earthquake = new Earthquake(
        new StdDateFormat().parse("2017-09-07T21:53:50.480Z"),
        37.3486,
        -98.2119,
        8.92,
        2.5,
        "mb_lg",
        "us2000ahrz",
        "17km WNW of Harper, Kansas",
        "earthquake"
    );
    List<Earthquake> expected = List.of(earthquake);

    List<Earthquake> actual = dataResource.findEarthquakes(Optional.of("Harper, Kansas"));

    assertEquals(expected, actual);
  }

  @Test
  void getEarthquakesThrowsException() {
    IllegalArgumentException expected =
        assertThrows(
            IllegalArgumentException.class,
            () -> dataResource.findEarthquakes(null));

    assertThat(expected)
        .hasMessage("Optional<String> reference cannot be null.");
  }

}