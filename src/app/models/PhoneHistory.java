package app.models;

/**
 * Created by drewdavis on 10/31/15.
 */
public class PhoneHistory {
    private String name;
    private String number;
    private String date;
    private Double duration;

    public PhoneHistory(String name, String number, String date, Double duration) {
        this.name = name;
        this.number = number;
        this.date = date;
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

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

}
