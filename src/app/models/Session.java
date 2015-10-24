package app.models;

import app.xmlModels.SessionClassWrapper;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import app.controllers.MainController;

/**
 * Created by anthonymace on 10/14/15.
 */
public class Session {
    private LocalTime startTime;
    private LocalTime endTime;
    private String sessionUserName;
    private String sessionPassword;
    private long duration;
    private Driver driver;

    public Session() {
        startTime = LocalTime.now();
    }

    public String getSessionUserName() {
        return sessionUserName;
    }

    public String getSessionPassword() {
        return sessionPassword;
    }

    public long getDuration() {
        return duration;
    }

    public void setSessionUserName(String sessionUserName) {
        this.sessionUserName = sessionUserName;
    }

    public void setSessionPassword(String sessionPassword) {
        this.sessionPassword = sessionPassword;
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
        if (driver.getUsername().equals("Anthony") && driver.getPassword().equals("abc123")) {
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
        this.driver.writeDriverToXML();
    }

    public void printDuration() {
        System.out.println("The duration of your session: " + duration);
    }

    public void writeSessionToXML() {
        SessionClassWrapper.write(this, "sessions.xml");
    }
}
