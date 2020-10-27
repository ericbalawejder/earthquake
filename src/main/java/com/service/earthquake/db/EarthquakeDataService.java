package com.service.earthquake.db;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.earthquake.entity.RawEarthquake;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EarthquakeDataService {

    public static void main(String[] args) throws IOException {
        EarthquakeDataService earthquakeDataService = new EarthquakeDataService();
        System.out.println(earthquakeDataService.getRawEarthquakeData());
    }

    final private ObjectMapper objectMapper = new ObjectMapper();

    public List<RawEarthquake> getRawEarthquakeData() throws IOException {
        InputStream jsonInputStream = getClass().getResourceAsStream("earthquake.json");

        return objectMapper.readValue(jsonInputStream, new TypeReference<>() {});
    }
}
