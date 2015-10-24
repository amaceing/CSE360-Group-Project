package app.controllers;

import app.VistaNavigator;
import com.pepperonas.fxiconics.*;
import com.pepperonas.fxiconics.awf.FxFontAwesome;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Label user;

    @FXML
    private BottomBarController bottomBarController;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Font font = FxIconics.getAwesomeFont(196);
        user.setFont(font);
        user.setText(FxFontAwesome.Icons.faw_user.toString());
    }

    @FXML
    protected void handleLoginAction(ActionEvent actionEvent) {
        VistaNavigator.loadVista(VistaNavigator.DASHBOARD);
    }

}
