package app.controllers;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import app.VistaNavigator;
import com.pepperonas.fxiconics.FxIconics;
import com.pepperonas.fxiconics.awf.FxFontAwesome;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private Label add;

    @FXML
    private Label volumeLabel;
    private int volume;

    @FXML
    private Label phoneNumberField;
    private  String phoneNumber = "";

    @FXML
    private ObservableList<String> contacts;

    @FXML
    private ListView contactsList;

    @FXML
    private TopBarController topBarController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Font font = FxIconics.getAwesomeFont(52);

        phoneNumberField.setText(phoneNumber);

        contacts = contactsList.getItems();

        volume = 0;
        volumeLabel.setText(Integer.toString(volume));

        call.setFont(font);
        call.setText(FxFontAwesome.Icons.faw_phone.toString());

        clear.setFont(font);
        clear.setText(FxFontAwesome.Icons.faw_times_circle_o.toString());

        add.setFont(font);
        add.setText(FxFontAwesome.Icons.faw_plus_square_o.toString());

        topBarController.setBackButton(VistaNavigator.DASHBOARD, PhoneController.this);
    }

    @FXML
    public void clearNumber() {
            phoneNumber = "";
            phoneNumberField.setText(phoneNumber);
    }

    @FXML
    public void addNumber() {
        for (int i = 0; i < 10; i++) {
            if (phoneNumber.length() == 14) {
                contacts.add(i,phoneNumber);
                clearNumber();
            }
        }
    }

    public void addDigit(String digit) {
        // Size of a US phone number is 14 when written as a string
        if (phoneNumber.length() < 14) {
            if (phoneNumber.isEmpty() == true) {
                phoneNumber += "(" + digit;
            } else if (phoneNumber.length() == 3) {
                phoneNumber += digit + ")" + "-";
            } else if (phoneNumber.length() == 8) {
                phoneNumber += digit + "-";
            } else {
                phoneNumber += digit;
            }
            phoneNumberField.setText(phoneNumber);
        }
    }
    @FXML
    public void addDigit0() {
        // Size of a US phone number is 14 when written as a string
        addDigit("0");
    }

    @FXML
    public void addDigit1() {
        // Size of a US phone number is 14 when written as a string
        addDigit("1");
    }

    @FXML
    public void addDigit2() {
        // Size of a US phone number is 14 when written as a string
        addDigit("2");
    }

    @FXML
    public void addDigit3() {
        // Size of a US phone number is 14 when written as a string
        addDigit("3");
    }

    @FXML
    public void addDigit4() {
        // Size of a US phone number is 14 when written as a string
        addDigit("4");
    }

    @FXML
    public void addDigit5() {
        // Size of a US phone number is 14 when written as a string
        addDigit("5");
    }

    @FXML
    public void addDigit6() {
        // Size of a US phone number is 14 when written as a string
        addDigit("6");
    }

    @FXML
    public void addDigit7() {
        // Size of a US phone number is 14 when written as a string
        addDigit("7");
    }

    @FXML
    public void addDigit8() {
        // Size of a US phone number is 14 when written as a string
        addDigit("8");
    }

    @FXML
    public void addDigit9() {
        // Size of a US phone number is 14 when written as a string
        addDigit("9");
    }

    @FXML
    public void addDigitStar() {
        // Size of a US phone number is 14 when written as a string
        addDigit("*");
    }

    @FXML
    public void addDigitHashtag() {
        // Size of a US phone number is 14 when written as a string
        addDigit("#");
    }

    @FXML
    public void volumeUp() {
        if (volume != 10)
            volumeLabel.setText(Integer.toString(++volume));
    }

    @FXML
    public void volumeDown() {
        if (volume != 0)
            volumeLabel.setText(Integer.toString(--volume));
    }
}

