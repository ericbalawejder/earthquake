package com.service.earthquake.resource;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.service.earthquake.db.EarthquakeDataService;
import com.service.earthquake.entity.Earthquake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataResourceTest {

    DataResource dataResource;
    EarthquakeDataService earthquakeDataService;

    @BeforeEach
    void setUp() {
        dataResource = new DataResource();
        earthquakeDataService = new EarthquakeDataService("test.json");
    }

    @Test
    void getEarthquakes() throws IOException, ParseException {
        final ISO8601DateFormat dateFormat = new ISO8601DateFormat();
        Earthquake earthquake = new Earthquake();
        earthquake.setTime(dateFormat.parse("2017-09-07T21:53:50.480Z"));
        earthquake.setLatitude(37.3486);
        earthquake.setLongitude(-98.2119);
        earthquake.setDepth(8.92);
        earthquake.setMagnitude(2.5);
        earthquake.setMagType("mb_lg");
        earthquake.setId("us2000ahrz");
        earthquake.setPlace("17km WNW of Harper, Kansas");
        earthquake.setType("earthquake");

        List<Earthquake> expected = List.of(earthquake);

        List<Earthquake> actual = dataResource.getEarthquakes(Optional.of("Harper, Kansas"));

        assertEquals(expected, actual);
    }
}