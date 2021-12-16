package com.aspegrenide.balanserameracelsius.support;

import com.aspegrenide.balanserameracelsius.support.Exercise;
import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class Station implements Serializable {
    private String title;
    private String description;
    private Exercise exercise;
    private boolean done;
    private double lat;
    private double lng;

    public Station() {
    }

    public Station(String title) {
        this.title = title;
    }

    public Station(String title, String description, Exercise exercise, boolean done, double lat, double lng) {
        this.title = title;
        this.description = description;
        this.exercise = exercise;
        this.done = done;
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public String toString() {
        return title;
    }

    public String toStringFull() {
        return "Station{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", exercise=" + exercise +
                ", done=" + done +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    private LatLng getLatLng() {
        LatLng ll = new LatLng(getLat(), getLng());
        return ll;
    }

    private void setLatLng(LatLng latLng) {
        setLat(latLng.latitude);
        setLng(latLng.longitude);
    }

}
