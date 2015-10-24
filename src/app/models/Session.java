package app.models;

import app.xmlModels.SessionClassWrapper;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.sql.*;

/**
 * Created by anthonymace on 10/14/15.
 */
public class Session {
    private LocalTime startTime;
    private LocalTime endTime;
    private long duration;
    private Driver driver;

    public Session() {
        startTime = LocalTime.now();
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public boolean validateLogin() {
        //will eventually check against file filled with usernames/passwords
        if (driver.getUsername().equals("example") && driver.getPassword().equals("password")) {
            System.out.println("valid");
            return true;
        } else {
            System.out.println("invalid");
            return false;
        }
    }

    public void endSession() {
        endTime = LocalTime.now();
        duration = ChronoUnit.SECONDS.between(startTime, endTime);
        writeSessionToXML();
    }

    public void printDuration() {
        System.out.println("The duration of your session: " + duration);
    }

    public void writeSessionToXML() {
        SessionClassWrapper.write(this, "sessions.xml");
    }
}
