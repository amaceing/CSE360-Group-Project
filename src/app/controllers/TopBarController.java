package app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by arinhouck on 10/9/15.
 */
public class TopBarController implements Initializable {

    @FXML
    private Label time;

    @FXML
    private Label left;

    @FXML
    private Label right;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set time eg. 12:00 PM
        DateFormat currentTime = new SimpleDateFormat("hh:mm a");
        Date date = new Date();
        time.setText(currentTime.format(date).toString());
    }
}
