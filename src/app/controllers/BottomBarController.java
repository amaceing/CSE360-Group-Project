package app.controllers;

import app.VistaNavigator;
import app.models.Session;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sun.rmi.rmic.Main;
import app.xmlModels.SessionClassWrapper;



import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by arinhouck on 10/9/15.
 */
public class BottomBarController implements Initializable {
    public Session session;

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
        session = new Session();
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
        session.endSession();
        session.printDuration();
        VistaNavigator.loadVista(VistaNavigator.LOGIN);
        writeSessionToXML();
    }

    public void hideLogOutButton() {
        logoutButton.setVisible(false);
    }

    public void writeSessionToXML() {
        SessionClassWrapper.write(session, "sessions.xml");
    }
}
