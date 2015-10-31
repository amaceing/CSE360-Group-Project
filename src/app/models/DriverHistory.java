package app.models;

//import java.util.Date;

import app.SqlDriver;

/**
 * Created by drewdavis on 10/24/15.
 */
public class DriverHistory {
    private String name;
    private String date;
    private Double duration;
    private Double maxSpeed;
    private Double avgSpeed;

    public DriverHistory(String name, String date, Double duration, Double maxSpeed, Double avgSpeed) {
        this.name = name;
        this.date = date;
        this.duration = duration;
        this.maxSpeed = maxSpeed;
        this.avgSpeed = avgSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(Double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }
}

