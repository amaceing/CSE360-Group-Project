package app.controllers;

import app.VistaNavigator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by arinhouck on 10/31/15.
 */
public class RouteController implements Initializable {

    @FXML
    private TopBarController topBarController;

    @FXML
    private Slider slider;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        topBarController.setBackButton(VistaNavigator.DASHBOARD, RouteController.this);
        slider.setValue(0);
        slider.setMin(0);
        slider.setMax(10);
        slider.setDisable(true);
    }
}
