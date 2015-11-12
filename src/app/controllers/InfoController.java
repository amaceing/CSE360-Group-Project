package app.controllers;
import app.VistaNavigator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import com.pepperonas.fxiconics.FxIconics;
import com.pepperonas.fxiconics.awf.FxFontAwesome;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class InfoController implements Initializable {

    @FXML
    private TopBarController topBarController;

    @FXML
    private Label phoneHistory;

    @FXML
    private Label drivingHistory;

    @FXML
    private Label radioHistory;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        topBarController.setBackButton(VistaNavigator.DASHBOARD, InfoController.this);

        Font font = FxIconics.getAwesomeFont(114);
        phoneHistory.setFont(font);
        phoneHistory.setText(FxFontAwesome.Icons.faw_phone.toString());

        drivingHistory.setFont(font);
        drivingHistory.setText(FxFontAwesome.Icons.faw_car.toString());

        radioHistory.setFont(font);
        radioHistory.setText(FxFontAwesome.Icons.faw_music.toString());


    }

    @FXML public void driveHistClick(MouseEvent arg0) {
        VistaNavigator.loadVista(VistaNavigator.DRIVEHIST);
    }

    @FXML public void phoneHistClick(MouseEvent arg0) {VistaNavigator.loadVista(VistaNavigator.PHONEHIST);}

    @FXML public void radioHistClick(MouseEvent arg0) {VistaNavigator.loadVista(VistaNavigator.RADIOHIST);}


}