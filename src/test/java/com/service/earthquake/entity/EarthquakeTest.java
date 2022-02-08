package com.service.earthquake.entity;

import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EarthquakeTest {

    private Earthquake earthquake;

    @BeforeEach
    void setUp() {
        earthquake = new Earthquake();
    }

    @Test
    void getAndSetTime() throws ParseException {
        final StdDateFormat dateFormat = new StdDateFormat();
        earthquake.setTime(dateFormat.parse("2017-09-08T12:46:04.610Z"));

        Date expected = dateFormat.parse("2017-09-08T12:46:04.610Z");

        Date actual = earthquake.getTime();

        assertEquals(expected, actual);
    }

    @Test
    void getLatitude() {
        earthquake.setLatitude(15.348);

        Double expected = 15.348;

        Double actual = earthquake.getLatitude();

        assertEquals(expected, actual);
    }

    @Test
    void setLatitude() {
        earthquake.setLatitude(15.348);

        Double expected = 15.348;

        Double actual = earthquake.getLatitude();

        assertEquals(expected, actual);
    }

    @Test
    void getLongitude() {
        earthquake.setLongitude(-93.9526);

        Double expected = -93.9526;

        Double actual = earthquake.getLongitude();

        assertEquals(expected, actual);
    }

    @Test
    void setLongitude() {
        earthquake.setLongitude(-93.9526);

        Double expected = -93.9526;

        Double actual = earthquake.getLongitude();

        assertEquals(expected, actual);
    }

    @Test
    void getDepth() {
        earthquake.setDepth(66.08);

        Double expected = 66.08;

        Double actual = earthquake.getDepth();

        assertEquals(expected, actual);
    }

    @Test
    void setDepth() {
        earthquake.setDepth(66.08);

        Double expected = 66.08;

        Double actual = earthquake.getDepth();

        assertEquals(expected, actual);
    }

    @Test
    void getMagnitude() {
        earthquake.setMagnitude(4.7);

        Double expected = 4.7;

        Double actual = earthquake.getMagnitude();

        assertEquals(expected, actual);
    }

    @Test
    void setMagnitude() {
        earthquake.setMagnitude(4.7);

        Double expected = 4.7;

        Double actual = earthquake.getMagnitude();

        assertEquals(expected, actual);
    }

    @Test
    void getId() {
        earthquake.setId("us2000ai1z");

        String expected = "us2000ai1z";

        String actual = earthquake.getId();

        assertEquals(expected, actual);
    }

    @Test
    void setId() {
        earthquake.setId("us2000ai1z");

        String expected = "us2000ai1z";

        String actual = earthquake.getId();

        assertEquals(expected, actual);
    }

    @Test
    void getPlace() {
        earthquake.setPlace("72km SW of Tres Picos, Mexico");

        String expected = "72km SW of Tres Picos, Mexico";

        String actual = earthquake.getPlace();

        assertEquals(expected, actual);
    }

    @Test
    void setPlace() {
        earthquake.setPlace("72km SW of Tres Picos, Mexico");

        String expected = "72km SW of Tres Picos, Mexico";

        String actual = earthquake.getPlace();

        assertEquals(expected, actual);
    }

    @Test
    void getMagType() {
        earthquake.setMagType("mb");

        String expected = "mb";

        String actual = earthquake.getMagType();

        assertEquals(expected, actual);
    }

    @Test
    void setMagType() {
        earthquake.setMagType("mb");

        String expected = "mb";

        String actual = earthquake.getMagType();

        assertEquals(expected, actual);
    }

    @Test
    void getType() {
        earthquake.setType("earthquake");

        String expected = "earthquake";

        String actual = earthquake.getType();

        assertEquals(expected, actual);
    }

    @Test
    void setType() {
        earthquake.setType("earthquake");

        String expected = "earthquake";

        String actual = earthquake.getType();

        assertEquals(expected, actual);
    }
}