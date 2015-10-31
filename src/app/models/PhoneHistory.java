package app.models;

/**
 * Created by drewdavis on 10/31/15.
 */
public class PhoneHistory {
    private String name;
    private String number;
    private String date;
    private String time;
    private Double duration;

    public PhoneHistory(String name, String number, String date, String time, Double duration) {
        this.name = name;
        this.number = number;
        this.date = date;
        this.time = time;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

}
