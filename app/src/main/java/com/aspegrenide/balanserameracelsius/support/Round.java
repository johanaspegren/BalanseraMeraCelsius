package com.aspegrenide.balanserameracelsius.support;

import java.io.Serializable;
import java.util.ArrayList;

public class Round implements Serializable {
    private String name; //Rosenknoppen
    private String description; //Rosenknoppen
    private String distance; //Rosenknoppen
    private int durationInMinutes; //Rosenknoppen
    private ArrayList<Station> stations;

    public Round() {
    }

    public Round(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Round{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", distance='" + distance + '\'' +
                ", durationInMinutes=" + durationInMinutes +
                ", stations=" + stations +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

    public void setStations(ArrayList<Station> stations) {
        this.stations = stations;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
}