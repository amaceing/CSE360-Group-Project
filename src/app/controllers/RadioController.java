package app.controllers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by arinhouck on 10/17/15.
 */
public class RadioController  implements Initializable {


    @FXML
    private TopBarController topBarController;

    @FXML
    private Button AMButton;

    @FXML
    private Button FMButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AMButton.getStyleClass().add("active");
    }

}
