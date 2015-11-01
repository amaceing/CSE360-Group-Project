package app.models;

import javafx.beans.property.SimpleStringProperty;
/**
 * Created by arinhouck on 10/9/15.
 */
public class Driver {

    private int ID;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int radioVolume;

    public Driver() {
        this.ID = 0;
        this.firstName = "";
        this.lastName = "";
        this.username = "";
        this.password = "";
        this.radioVolume = 0;
    }

    public Driver(int ID, String firstName, String lastName, String username, String password, int radioVolume) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.radioVolume = radioVolume;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public String usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRadioVolume() {
        return radioVolume;
    }

    public void setRadioVolume(int radioVolume) {
        this.radioVolume = radioVolume;
    }
}
