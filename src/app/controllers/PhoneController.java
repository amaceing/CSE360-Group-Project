package app.controllers;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import app.VistaNavigator;
import com.pepperonas.fxiconics.FxIconics;
import com.pepperonas.fxiconics.awf.FxFontAwesome;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * Created by Marius on 10/17/2015.
 */


public class PhoneController implements Initializable {

    @FXML
    private Label call;

    @FXML
    private Label clear;

    @FXML
    private TopBarController topBarController;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Font font = FxIconics.getAwesomeFont(70);
        call.setFont(font);
        call.setText(FxFontAwesome.Icons.faw_phone.toString());

        clear.setFont(font);
        clear.setText(FxFontAwesome.Icons.faw_times_circle_o.toString());
        topBarController.setBackButton(VistaNavigator.DASHBOARD);
    }


    @FXML public void handleCallClick(MouseEvent arg0) {
        System.out.print("call");
    }


}

