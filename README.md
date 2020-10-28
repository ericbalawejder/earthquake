# earthquake
To run the tests:
```
$ gradle test
```

To run the server:
```
$ ./gradlew run
```
In terminal:
```
$ curl localhost:8080/data
```
Add a filter to the location:
```
$ curl localhost:8080/data?filter=ssw
```
For pretty print output:
```
$ curl localhost:8080/data?filter=ssw | jq
```