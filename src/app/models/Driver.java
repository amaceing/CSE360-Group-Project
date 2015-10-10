package app.models;

import javafx.beans.property.SimpleStringProperty;
/**
 * Created by arinhouck on 10/9/15.
 */
public class Driver {

    private final SimpleStringProperty username;
    private final SimpleStringProperty password;

    public Driver(String username, String password) {
        this.username =  new SimpleStringProperty(username);
        this.password =  new SimpleStringProperty(password);
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
