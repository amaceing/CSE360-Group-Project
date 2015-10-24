package app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by arinhouck on 10/9/15.
 */
public class BottomBarController implements Initializable {

    @FXML
    private Label left;

    @FXML
    private Label center;

    @FXML
    private Label right;

    @FXML
    private Button accel;

    @FXML
    private Label mph;

    int speed = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // View did load
        mph.setText("MPH: " + speed);
    }

    @FXML public void accelerateAction(MouseEvent arg0) {
        //System.out.println("Up");
        if(speed <= 100)
        {
            speed++;
            mph.setText("MPH: " + speed);
        }

    }

    @FXML public void decelerateAction(MouseEvent arg0) {
        //System.out.println("Up");
        if (speed >= 1)
        {
            speed--;
            mph.setText("MPH: " + speed);
        }

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

}

