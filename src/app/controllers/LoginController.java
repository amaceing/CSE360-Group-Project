package app.controllers;

import app.VistaNavigator;
import app.models.Session;
import com.pepperonas.fxiconics.*;
import com.pepperonas.fxiconics.awf.FxFontAwesome;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.text.Font;
import app.controllers.MainController;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private static MainController mainController;

    @FXML
    private Label user;

    @FXML
    private BottomBarController bottomBarController;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Font font = FxIconics.getAwesomeFont(196);
        user.setFont(font);
        user.setText(FxFontAwesome.Icons.faw_user.toString());
        bottomBarController.hideLogOutButton();

        mainController = VistaNavigator.getMainController();
    }

    @FXML
    protected void handleLoginAction(ActionEvent actionEvent) {
        Session session = new Session();
        mainController.setSession(session);
        mainController.getSession().setSessionUserName(usernameTextField.getText());
        mainController.getSession().setSessionPassword(passwordTextField.getText());
        if (mainController.getSession().validateLogin()) {
            System.out.println("user can log in");
            VistaNavigator.loadVista(VistaNavigator.DASHBOARD);
        } else {
            System.out.println("user cannot log in");
        }
    }
}
