package app.controllers;

import app.Main;
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
    private static MainController mainController;

    @FXML
    private TopBarController topBarController;

    @FXML
    private Slider slider;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        topBarController.setBackButton(VistaNavigator.DASHBOARD, RouteController.this);
        mainController = VistaNavigator.getMainController();

        slider.setValue(Main.MAX_MILEAGE - mainController.getSession().getDriver().getMilesRemaining());
        slider.setMin(0);
        slider.setMax(Main.MAX_MILEAGE);
        slider.setDisable(true);
    }
}
