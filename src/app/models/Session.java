package app.models;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by anthonymace on 10/14/15.
 */
public class Session {
    private LocalTime startTime;
    private LocalTime endTime;
    public long duration;

    public Session() {
        startTime = LocalTime.now();
    }

    public long getDuration() {
        return duration;
    }

    public void endSession() {
        endTime = LocalTime.now();
        duration = ChronoUnit.SECONDS.between(startTime, endTime);
    }

    public void printDuration() {
        System.out.println("The duration of your session: " + duration);
    }
}
