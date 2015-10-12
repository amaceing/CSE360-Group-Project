package app.controllers;

import com.pepperonas.fxiconics.FxIconics;
import com.pepperonas.fxiconics.awf.FxFontAwesome;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by arinhouck on 10/12/15.
 */
public class DashboardController implements Initializable {

    @FXML
    private Label radio;

    @FXML
    private Label phone;

    @FXML
    private Label routes;

    @FXML
    private Label profile;

    @FXML
    private Label info;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Font font = FxIconics.getAwesomeFont(114);
        radio.setFont(font);
        radio.setText(FxFontAwesome.Icons.faw_music.toString());

        phone.setFont(font);
        phone.setText(FxFontAwesome.Icons.faw_phone.toString());

        routes.setFont(font);
        routes.setText(FxFontAwesome.Icons.faw_location_arrow.toString());

        profile.setFont(font);
        profile.setText(FxFontAwesome.Icons.faw_user.toString());

        info.setFont(font);
        info.setText(FxFontAwesome.Icons.faw_info_circle.toString());
    }
}