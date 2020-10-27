package com.service.earthquake.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RawEarthquake {

    private String time;
    private Double latitude;
    private Double longitude;
    private Double depth;
    private Double magnitude;
    private String magType;
    private String id;
    private String place;
    private String type;

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getDepth() {
        return this.depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    @JsonProperty(value = "mag")
    public Double getMagnitude() {
        return this.magnitude;
    }

    public void setMagnitude(Double mag) {
        this.magnitude = mag;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getMagType() {
        return this.magType;
    }

    public void setMagType(String magType) {
        this.magType = magType;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("*RawEarthquakeData*\n");
        stringBuilder.append("time = " + time + "\n");
        stringBuilder.append("latitude = " + latitude + "\n");
        stringBuilder.append("longitude = " + longitude + "\n");
        stringBuilder.append("depth = " + depth + "\n");
        stringBuilder.append("magnitude = " + magnitude + "\n");
        stringBuilder.append("magType = " + magType + "\n");
        stringBuilder.append("id = " + id + "\n");
        stringBuilder.append("place = " + place + "\n");
        stringBuilder.append("type = " + type + "\n");
        return stringBuilder.toString();
    }
}
