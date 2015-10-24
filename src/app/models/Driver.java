package app.models;

import app.xmlModels.DriverClassWrapper;
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

    public Driver() {
        this.ID = 0;
        this.firstName = "";
        this.lastName = "";
        this.username = "";
        this.password = "";
    }

    public Driver(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
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

    public void writeDriverToXML() {
        DriverClassWrapper.write(this, "drivers.xml");
    }
}
