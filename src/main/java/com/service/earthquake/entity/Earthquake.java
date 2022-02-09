package com.service.earthquake.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Earthquake {

    private Date time;
    private Double latitude;
    private Double longitude;
    private Double depth;
    private Double magnitude;
    private String magType;
    private String id;
    private String place;
    private String type;

    public Earthquake() {
    }

    public Earthquake(Date time, Double latitude, Double longitude,
                      Double depth, Double magnitude, String magType,
                      String id, String place, String type) {
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.depth = depth;
        this.magnitude = magnitude;
        this.magType = magType;
        this.id = id;
        this.place = place;
        this.type = type;
    }

    public Date getTime() {
        return this.time;
    }

    public void setTime(Date time) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Earthquake that = (Earthquake) o;
        return Objects.equals(time, that.time) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(depth, that.depth) &&
                Objects.equals(magnitude, that.magnitude) &&
                Objects.equals(magType, that.magType) &&
                Objects.equals(id, that.id) &&
                Objects.equals(place, that.place) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, latitude, longitude, depth, magnitude, magType, id, place, type);
    }

    @Override
    public String toString() {
        return "***Earthquake***\n" +
                "time = " + time + "\n" +
                "latitude = " + latitude + "\n" +
                "longitude = " + longitude + "\n" +
                "depth = " + depth + "\n" +
                "magnitude = " + magnitude + "\n" +
                "magType = " + magType + "\n" +
                "id = " + id + "\n" +
                "place = " + place + "\n" +
                "type = " + type + "\n";
    }

}
