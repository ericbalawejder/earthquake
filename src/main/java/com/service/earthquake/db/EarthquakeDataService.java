package com.service.earthquake.db;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.service.earthquake.entity.Earthquake;
import com.service.earthquake.entity.RawEarthquake;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EarthquakeDataService {

    private static final String FILE_PATH = "earthquake.json";

    public List<RawEarthquake> getRawEarthquakeData(String filePath) throws IOException {
        final InputStream jsonInputStream = getClass().getResourceAsStream(filePath);

        final ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonInputStream, new TypeReference<>() {});
    }

    public List<Earthquake> getEarthquakes() throws IOException {
        final List<RawEarthquake> rawEarthquakes = getRawEarthquakeData(FILE_PATH);

        return rawEarthquakes.stream()
                .map(mapRawEarthquakeToEarthquake)
                .collect(Collectors.toUnmodifiableList());
    }

    private Function<RawEarthquake, Earthquake> mapRawEarthquakeToEarthquake
            = rawEarthquake -> {

        Earthquake earthquake = new Earthquake();
        try {
            earthquake.setTime(convertStringToDate(rawEarthquake.getTime()));
            earthquake.setLatitude(rawEarthquake.getLatitude());
            earthquake.setLongitude(rawEarthquake.getLongitude());
            earthquake.setDepth(rawEarthquake.getDepth());
            earthquake.setMagnitude(rawEarthquake.getMagnitude());
            earthquake.setMagType(rawEarthquake.getMagType());
            earthquake.setId(rawEarthquake.getId());
            earthquake.setPlace(rawEarthquake.getPlace());
            earthquake.setType(rawEarthquake.getType());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return earthquake;
    };

    private Date convertStringToDate(String time) throws ParseException {
        final ISO8601DateFormat dateFormat = new ISO8601DateFormat();
        return dateFormat.parse(time);
    }
}
