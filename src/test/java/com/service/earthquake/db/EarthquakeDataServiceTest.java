package com.service.earthquake.db;

import com.service.earthquake.entity.RawEarthquake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EarthquakeDataServiceTest {

    private RawEarthquake rawEarthquake;

    @BeforeEach
    void setup() {
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
    void getRawEarthquakeData() throws IOException {
        EarthquakeDataService earthquakeDataService = new EarthquakeDataService();

        List<RawEarthquake> expected = List.of(rawEarthquake);

        List<RawEarthquake> actual = earthquakeDataService.getRawEarthquakeData("test.json");

        assertEquals(expected, actual);
    }
}