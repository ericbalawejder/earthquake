package com.service.earthquake.db;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.service.earthquake.entity.Earthquake;
import com.service.earthquake.entity.RawEarthquake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EarthquakeDataServiceTest {

    private RawEarthquake rawEarthquake;
    private EarthquakeDataService earthquakeDataService;

    @BeforeEach
    void setup() {
        earthquakeDataService = new EarthquakeDataService("test.json");
        rawEarthquake = new RawEarthquake();
        rawEarthquake.setTime("2017-09-07T21:53:50.480Z");
        rawEarthquake.setLatitude(37.3486);
        rawEarthquake.setLongitude(-98.2119);
        rawEarthquake.setDepth(8.92);
        rawEarthquake.setMagnitude(2.5);
        rawEarthquake.setMagType("mb_lg");
        rawEarthquake.setId("us2000ahrz");
        rawEarthquake.setPlace("17km WNW of Harper, Kansas");
        rawEarthquake.setType("earthquake");
    }

    @Test
    void getRawEarthquakes() throws IOException {
        List<RawEarthquake> expected = List.of(rawEarthquake);

        List<RawEarthquake> actual = earthquakeDataService.getRawEarthquakeData();

        assertEquals(expected, actual);
    }

    @Test
    void getEarthquakes() throws ParseException {
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

        List<Earthquake> actual = earthquakeDataService.getEarthquakes(List.of(rawEarthquake));

        assertEquals(expected, actual);
    }
}