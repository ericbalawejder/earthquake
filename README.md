# Earthquake Data Service
This program reads an array of earthquake data, provided in earthquake.json, and maps selected fields to a RawEarthquake object.
It then converts the time stamp String to a Date object and maps each RawEarthquake to an Earthquake object.
The endpoint /data provides a List of Earthquakes sorted by magnitude and time and provides an Optional filter for location.

To run the tests:
```
$ gradle test
```

To run the server:
```
$ ./gradlew run
```
Provides the entire list of earthquakes.
```
$ curl localhost:8080/data
```
Add a filter to the location:
```
$ curl localhost:8080/data?filter=Idaho
```
For pretty print output:
```
$ curl localhost:8080/data?filter=Idaho | jq
```