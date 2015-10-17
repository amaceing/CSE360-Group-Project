package app.controllers;

import app.VistaNavigator;
import app.models.Session;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sun.rmi.rmic.Main;
import app.xmlModels.SessionClassWrapper;
import app.controllers.MainController;



import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by arinhouck on 10/9/15.
 */
public class BottomBarController implements Initializable {
    private MainController mainController;

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
        mainController.session = new Session();
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
        mainController.session.endSession();
        mainController.session.printDuration();
        VistaNavigator.loadVista(VistaNavigator.LOGIN);
    }

    public void hideLogOutButton() {
        logoutButton.setVisible(false);
    }

}
