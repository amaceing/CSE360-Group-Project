package app.controllers;

import app.VistaNavigator;
import app.models.Session;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
<<<<<<< HEAD
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sun.rmi.rmic.Main;
import app.xmlModels.SessionClassWrapper;
import app.controllers.MainController;


=======
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
>>>>>>> 51eec8e4a2bb50b8e35747f453531667d4351d4c

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
    }


    public Label getRight() {
        return right;
    }

    public Label getLeft() {
        return left;
    }

<<<<<<< HEAD
    public Label getCenter() {
        return center;
    }

    public Button getLogoutButton() {
        return logoutButton;
    }

    public void endSession() {
        mainController.getSession().endSession();
        mainController.getSession().printDuration();
        VistaNavigator.loadVista(VistaNavigator.LOGIN);
        mainController.setSession(null);
    }

    public void hideLogOutButton() {
        logoutButton.setVisible(false);
    }
=======
    public Label getCenter() { return center; }
>>>>>>> 51eec8e4a2bb50b8e35747f453531667d4351d4c

}

