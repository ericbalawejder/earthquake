package com.service.earthquake.db;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.earthquake.entity.RawEarthquake;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EarthquakeDataService {

    final private ObjectMapper objectMapper = new ObjectMapper();

    public List<RawEarthquake> getRawEarthquakeData(String filePath) throws IOException {
        InputStream jsonInputStream = getClass().getResourceAsStream(filePath);

        return objectMapper.readValue(jsonInputStream, new TypeReference<>() {});
    }
}
