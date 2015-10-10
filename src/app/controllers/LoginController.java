package app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private BottomBarController bottomBarController;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View loaded.");
    }

    @FXML
    protected void handleLoginAction(ActionEvent actionEvent) {
        // Handle Login
    }
}
