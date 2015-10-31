package app.controllers;

import app.SqlDriver;
import app.VistaNavigator;
import app.models.DriverHistory;
import app.models.Session;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sun.rmi.rmic.Main;
import app.controllers.MainController;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;


/**
 * Created by arinhouck on 10/9/15.
 */
public class BottomBarController implements Initializable {
    private MainController mainController;
    private DriverHistory driverHistory;

    @FXML
    private Label left;

    @FXML
    private Label center;

    @FXML
    private Label right;

    @FXML
    private Button logoutButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // View did load
        mainController = VistaNavigator.getMainController();
    }


    public Label getRight() {
        return right;
    }

    public Label getLeft() {
        return left;
    }

    public Label getCenter() {
        return center;
    }

    public Button getLogoutButton() {
        return logoutButton;
    }

    public void endSession() {
        mainController.getSession().endSession();
        mainController.getSession().printDuration();
        createAndInsertDriverHistoryRecord();
        VistaNavigator.loadVista(VistaNavigator.LOGIN);
        mainController.setSession(null);
    }

    public void createAndInsertDriverHistoryRecord() {
        String name = mainController.getSession().getDriver().getFirstName();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateString = dateFormat.format(date).toString();
        double duration = mainController.getSession().getDuration();
        driverHistory = new DriverHistory(name, dateString, duration, 53.0, 25.9);
        SqlDriver.insertRecord(driverHistory);
    }

}

