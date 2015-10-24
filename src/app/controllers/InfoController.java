package app.controllers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import com.pepperonas.fxiconics.FxIconics;
import com.pepperonas.fxiconics.awf.FxFontAwesome;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class InfoController implements Initializable {

    @FXML
    private Label sessionHistory;

    @FXML
    private Label drivingHistory;

    @FXML
    private Label sessionStats;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Font font = FxIconics.getAwesomeFont(114);
        sessionHistory.setFont(font);
        sessionHistory.setText(FxFontAwesome.Icons.faw_history.toString());

        drivingHistory.setFont(font);
        drivingHistory.setText(FxFontAwesome.Icons.faw_car.toString());

        sessionStats.setFont(font);
        sessionStats.setText(FxFontAwesome.Icons.faw_bar_chart.toString());


    }

}