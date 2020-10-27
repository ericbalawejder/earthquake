package com.service.earthquake.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RawEarthquakeTest {

    private RawEarthquake rawEarthquake;

    @BeforeEach
    void setUp() {
        rawEarthquake = new RawEarthquake();
    }

    @Test
    void getAndSetTime() {
        rawEarthquake.setTime("2017-09-08T12:46:04.610Z");

        String expected = "2017-09-08T12:46:04.610Z";

        String actual = rawEarthquake.getTime();

        assertEquals(expected, actual);
    }

    @Test
    void getLatitude() {
        rawEarthquake.setLatitude(15.348);

        Double expected = 15.348;

        Double actual = rawEarthquake.getLatitude();

        assertEquals(expected, actual);
    }

    @Test
    void setLatitude() {
        rawEarthquake.setLatitude(15.348);

        Double expected = 15.348;

        Double actual = rawEarthquake.getLatitude();

        assertEquals(expected, actual);
    }

    @Test
    void getLongitude() {
        rawEarthquake.setLongitude(-93.9526);

        Double expected = -93.9526;

        Double actual = rawEarthquake.getLongitude();

        assertEquals(expected, actual);
    }

    @Test
    void setLongitude() {
        rawEarthquake.setLongitude(-93.9526);

        Double expected = -93.9526;

        Double actual = rawEarthquake.getLongitude();

        assertEquals(expected, actual);
    }

    @Test
    void getDepth() {
        rawEarthquake.setDepth(66.08);

        Double expected = 66.08;

        Double actual = rawEarthquake.getDepth();

        assertEquals(expected, actual);
    }

    @Test
    void setDepth() {
        rawEarthquake.setDepth(66.08);

        Double expected = 66.08;

        Double actual = rawEarthquake.getDepth();

        assertEquals(expected, actual);
    }

    @Test
    void getMagnitude() {
        rawEarthquake.setMagnitude(4.7);

        Double expected = 4.7;

        Double actual = rawEarthquake.getMagnitude();

        assertEquals(expected, actual);
    }

    @Test
    void setMagnitude() {
        rawEarthquake.setMagnitude(4.7);

        Double expected = 4.7;

        Double actual = rawEarthquake.getMagnitude();

        assertEquals(expected, actual);
    }

    @Test
    void getId() {
        rawEarthquake.setId("us2000ai1z");

        String expected = "us2000ai1z";

        String actual = rawEarthquake.getId();

        assertEquals(expected, actual);
    }

    @Test
    void setId() {
        rawEarthquake.setId("us2000ai1z");

        String expected = "us2000ai1z";

        String actual = rawEarthquake.getId();

        assertEquals(expected, actual);
    }

    @Test
    void getPlace() {
        rawEarthquake.setPlace("72km SW of Tres Picos, Mexico");

        String expected = "72km SW of Tres Picos, Mexico";

        String actual = rawEarthquake.getPlace();

        assertEquals(expected, actual);
    }

    @Test
    void setPlace() {
        rawEarthquake.setPlace("72km SW of Tres Picos, Mexico");

        String expected = "72km SW of Tres Picos, Mexico";

        String actual = rawEarthquake.getPlace();

        assertEquals(expected, actual);
    }

    @Test
    void getMagType() {
        rawEarthquake.setMagType("mb");

        String expected = "mb";

        String actual = rawEarthquake.getMagType();

        assertEquals(expected, actual);
    }

    @Test
    void setMagType() {
        rawEarthquake.setMagType("mb");

        String expected = "mb";

        String actual = rawEarthquake.getMagType();

        assertEquals(expected, actual);
    }

    @Test
    void getType() {
        rawEarthquake.setType("earthquake");

        String expected = "earthquake";

        String actual = rawEarthquake.getType();

        assertEquals(expected, actual);
    }

    @Test
    void setType() {
        rawEarthquake.setType("earthquake");

        String expected = "earthquake";

        String actual = rawEarthquake.getType();

        assertEquals(expected, actual);
    }
}