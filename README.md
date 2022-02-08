## Earthquake Data Service
This program reads an array of earthquake data, provided in earthquake.json, and maps selected fields
to a RawEarthquake object. It then converts the time stamp String to a Date object and maps each 
RawEarthquake to an Earthquake object. The endpoint `/earthquake/data` provides a List of Earthquakes sorted by
magnitude and time. The endpoint `/earthquake/find` provides an optional filter for the location field.

### To run:
To run the tests:
```
$ ./gradlew test
```
To run the server:
```
$ ./gradlew run
```
Provides the entire list of earthquakes.
```
$ curl localhost:8080/earthquake/data
```
or visit `http://localhost:8080/earthquake/data`

Find by a filter to the location field case-insensitive:
```
$ curl localhost:8080/earthquake/find?filter=idaho
```
For pretty print output:
```
$ curl localhost:8080/earthquake/find?filter=idaho | jq
```
