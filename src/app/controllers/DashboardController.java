package app.controllers;

import app.VistaNavigator;
import com.pepperonas.fxiconics.FxIconics;
import com.pepperonas.fxiconics.awf.FxFontAwesome;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.*;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

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

//    @FXML
//    private TopBarController topBar;

//    @FXML
//    private BottomBarController bottomBar;
    @FXML
    private BottomBarController bottomBarController;

    @FXML
    private Label speedLabel;

    @FXML
    private Label milesLeftLabel;

    @FXML
    private VBox phoneBox;

    @FXML
    private VBox radioBox;

    @FXML
    private BorderPane borderPane;

    private Double speed;
    private Double milesLeft;

    private boolean timerRunning = false;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Font font = FxIconics.getAwesomeFont(114);
        borderPane.setFocusTraversable(true);

        speed = 0.0;
        speedLabel.setText(speed.toString());

        milesLeft = 300.0;
        milesLeftLabel.setText(milesLeft.toString());

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

    @FXML
    private void keyPressed(final KeyEvent event)
    {
        if (event.getCode() == KeyCode.UP) {
            if (speed < 100) {
                speedLabel.setText((++speed).toString());
            }
        } else if (event.getCode() == KeyCode.DOWN) {
            if (speed > 0) {
                speedLabel.setText((--speed).toString());
            }
        }
    }

    @FXML
    private void keyReleased(final KeyEvent event)
    {
        if (!timerRunning) {
            timerRunning = true;
            decrementSpeed();
        }
    }

    private void decrementSpeed() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        speedLabel.setText((--speed).toString());
                        if(milesLeft >= 0)
                            milesLeft -= .5;
                        if (speed <= 0) {
                            timer.cancel();
                            timerRunning = false;
                            milesLeftLabel.setText((--milesLeft).toString());
                        }
                    }
                });
            }
        }, 500, 500); //Every half second
    }

    @FXML
    public void handlePhoneClick(MouseEvent arg0)
    {
        VistaNavigator.loadVista(VistaNavigator.PHONE);
    }

    @FXML
    public void handleRadioClick(MouseEvent arg0) {
        VistaNavigator.loadVista(VistaNavigator.RADIO);
    }

    @FXML
    public void handleRouteClick(MouseEvent arg0) {
        VistaNavigator.loadVista(VistaNavigator.ROUTE);
    }

    @FXML
    public void infoClick(MouseEvent arg0) {
        VistaNavigator.loadVista(VistaNavigator.INFORMATION);
    }

}
