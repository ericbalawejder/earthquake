package com.service.earthquake.resource;

import com.service.earthquake.db.EarthquakeDataService;
import com.service.earthquake.entity.Earthquake;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/data")
@Produces(MediaType.APPLICATION_JSON)
public class DataResource {

    @GET
    public List<Earthquake> getEarthquakes(@QueryParam("filter") Optional<String> filter)
            throws IOException {

        if (filter == null) {
            throw new IllegalArgumentException("Optional<String> reference cannot be null.");
        }
        final EarthquakeDataService dataService =
                new EarthquakeDataService("earthquake.json");

        return dataService.getEarthquakes()
                .stream()
                .filter(e -> containsIgnoreCase(e.getPlace(), filter.orElse("")))
                .sorted(Comparator.comparing(Earthquake::getMagnitude)
                        .reversed()
                        .thenComparing(Earthquake::getTime))
                .collect(Collectors.toUnmodifiableList());
    }

    // Faster than regex match("(?i).*filter.*$") for large files
    private boolean containsIgnoreCase(String source, String match) {
        final int filterLength = match.length();
        if (filterLength == 0) {
            return true;
        }
        final char firstLowerCharOfMatch = Character.toLowerCase(match.charAt(0));
        final char firstUpperCharOfMatch = Character.toUpperCase(match.charAt(0));

        for (int i = source.length() - filterLength; i >= 0; i--) {
            // Quick check before calling the more expensive regionMatches() method:
            final char sourceCharacter = source.charAt(i);
            if (sourceCharacter != firstLowerCharOfMatch && sourceCharacter != firstUpperCharOfMatch) {
                continue;
            }
            if (source.regionMatches(true, i, match, 0, filterLength)) {
                return true;
            }
        }
        return false;
    }

}
