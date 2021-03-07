package com.service.earthquake.db;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.service.earthquake.entity.Earthquake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EarthquakeDataServiceTest {

    private Earthquake earthquake;
    private EarthquakeDataService earthquakeDataService;

    @BeforeEach
    void setup() throws ParseException, IOException {
        earthquakeDataService = new EarthquakeDataService("test.json");

        final ISO8601DateFormat dateFormat = new ISO8601DateFormat();
        earthquake = new Earthquake();
        earthquake.setTime(dateFormat.parse("2017-09-07T21:53:50.480Z"));
        earthquake.setLatitude(37.3486);
        earthquake.setLongitude(-98.2119);
        earthquake.setDepth(8.92);
        earthquake.setMagnitude(2.5);
        earthquake.setMagType("mb_lg");
        earthquake.setId("us2000ahrz");
        earthquake.setPlace("17km WNW of Harper, Kansas");
        earthquake.setType("earthquake");
    }


    @Test
    void getEarthquakes() {
        List<Earthquake> expected = List.of(earthquake);

        List<Earthquake> actual = earthquakeDataService.getEarthquakes();

        assertEquals(expected, actual);
    }

    @Test
    void getFilePath() {
        String expected = "test.json";

        String actual = earthquakeDataService.getFilePath();

        assertEquals(expected, actual);
    }
}
