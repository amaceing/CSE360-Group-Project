package app.controllers;

import app.VistaNavigator;
import app.models.Driver;
import app.models.Session;
import com.pepperonas.fxiconics.*;
import com.pepperonas.fxiconics.awf.FxFontAwesome;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import app.SqlDriver;

import javax.sound.midi.SysexMessage;


public class LoginController implements Initializable {
    private static MainController mainController;

    @FXML
    private Label user;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Font font = FxIconics.getAwesomeFont(196);
        user.setFont(font);
        user.setText(FxFontAwesome.Icons.faw_user.toString());

        mainController = VistaNavigator.getMainController();
    }

    @FXML
    protected void handleLoginAction(ActionEvent actionEvent) {
        Driver driver = new Driver("Anthony", "Mace", usernameTextField.getText(), passwordTextField.getText());
        SqlDriver.insertRecord(driver);
        Session session = new Session();
        mainController.setSession(session);
        mainController.getSession().setDriver(driver);
        printRecords();

        //FIX BEFORE COMMIT
//        if (mainController.getSession().validateLogin()) {
//            VistaNavigator.loadVista(VistaNavigator.DASHBOARD);
//        } else {
//            Alert invalidLogin = new Alert(Alert.AlertType.WARNING);
//            invalidLogin.setTitle("Invalid login");
//            invalidLogin.setHeaderText("Invalid username and/or password");
//            invalidLogin.setContentText("The username and/or password you entered are not valid! Please enter a valid login or register.");
//            invalidLogin.showAndWait();
//        }

        VistaNavigator.loadVista(VistaNavigator.DASHBOARD);
    }

    public void printRecords() {
        List<String> records = SqlDriver.getRecords("DRIVER");
        for (String record : records) {
            System.out.println(record);
        }
    }

}
