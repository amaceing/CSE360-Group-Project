package app.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // View did load
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
