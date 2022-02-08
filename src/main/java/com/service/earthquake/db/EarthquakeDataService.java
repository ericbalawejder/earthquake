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

    private final String filePath;
    private final List<Earthquake> earthquakes;

    public EarthquakeDataService(String filePath) throws IOException {
        this.filePath = filePath;
        this.earthquakes = getEarthquakeData(getRawEarthquakeData(filePath));
    }

    public List<Earthquake> getEarthquakes() {
        return List.copyOf(earthquakes);
    }

    public String getFilePath() {
        return filePath;
    }

    private List<Earthquake> getEarthquakeData(List<RawEarthquake> rawEarthquakes) {
        return rawEarthquakes.stream()
                .map(mapRawEarthquakeToEarthquake)
                .toList();
    }

    private List<RawEarthquake> getRawEarthquakeData(String filePath) throws IOException {
        final InputStream jsonInputStream = getClass().getResourceAsStream(filePath);
        final ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(jsonInputStream, new TypeReference<>() {});
    }

    private final Function<RawEarthquake, Earthquake> mapRawEarthquakeToEarthquake
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
        final StdDateFormat dateFormat = new StdDateFormat();
        return dateFormat.parse(time);
    }

}
