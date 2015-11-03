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
        volumeLabel.setFont(font);
        volumeLabel.setText(Integer.toString(volume));

        call.setFont(font);
        call.setText(FxFontAwesome.Icons.faw_phone.toString());

        clear.setFont(font);
        clear.setText(FxFontAwesome.Icons.faw_times_circle_o.toString());

        add.setFont(font);
        add.setText(FxFontAwesome.Icons.faw_plus_square_o.toString());

        topBarController.setBackButton(VistaNavigator.DASHBOARD);
    }

    @FXML
    public void clearNumber() {
            phoneNumber = "";
            phoneNumberField.setText(phoneNumber);
    }

    @FXML
    public void removeContact(){
         for(int i=0; i<10; i++) {
             contacts.remove(i);
         }
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

    @FXML
    public void addDigit0() {
        // Size of a US phone number is 14 when written as a string
        if (phoneNumber.length() < 14) {
            if (phoneNumber.isEmpty() == true) {
                phoneNumber += "(" + "0";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 3) {
                phoneNumber += "0" + ")" + "-";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 8) {
                phoneNumber += "0" + "-";
                phoneNumberField.setText(phoneNumber);
            } else {
                phoneNumber += "0";
                phoneNumberField.setText(phoneNumber);
            }
        }
    }

    @FXML
    public void addDigit1() {
        // Size of a US phone number is 14 when written as a string
        if (phoneNumber.length() < 14) {
            if (phoneNumber.isEmpty() == true) {
                phoneNumber += "(" + "1";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 3) {
                phoneNumber += "1" + ")" + "-";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 8) {
                phoneNumber += "1" + "-";
                phoneNumberField.setText(phoneNumber);
            } else {
                phoneNumber += "1";
                phoneNumberField.setText(phoneNumber);
            }
        }
    }

    @FXML
    public void addDigit2() {
        // Size of a US phone number is 14 when written as a string
        if (phoneNumber.length() < 14) {
            if (phoneNumber.isEmpty() == true) {
                phoneNumber += "(" + "2";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 3) {
                phoneNumber += "2" + ")" + "-";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 8) {
                phoneNumber += "2" + "-";
                phoneNumberField.setText(phoneNumber);
            } else {
                phoneNumber += "2";
                phoneNumberField.setText(phoneNumber);
            }
        }
    }

    @FXML
    public void addDigit3() {
        // Size of a US phone number is 14 when written as a string
        if (phoneNumber.length() < 14) {
            if (phoneNumber.isEmpty() == true) {
                phoneNumber += "(" + "3";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 3) {
                phoneNumber += "3" + ")" + "-";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 8) {
                phoneNumber += "3" + "-";
                phoneNumberField.setText(phoneNumber);
            } else {
                phoneNumber += "3";
                phoneNumberField.setText(phoneNumber);
            }
        }
    }

    @FXML
    public void addDigit4() {
        // Size of a US phone number is 14 when written as a string
        if (phoneNumber.length() < 14) {
            if (phoneNumber.isEmpty() == true) {
                phoneNumber += "(" + "4";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 3) {
                phoneNumber += "4" + ")" + "-";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 8) {
                phoneNumber += "4" + "-";
                phoneNumberField.setText(phoneNumber);
            } else {
                phoneNumber += "4";
                phoneNumberField.setText(phoneNumber);
            }
        }
    }

    @FXML
    public void addDigit5() {
        // Size of a US phone number is 14 when written as a string
        if (phoneNumber.length() < 14) {
            if (phoneNumber.isEmpty() == true) {
                phoneNumber += "(" + "5";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 3) {
                phoneNumber += "5" + ")" + "-";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 8) {
                phoneNumber += "5" + "-";
                phoneNumberField.setText(phoneNumber);
            } else {
                phoneNumber += "5";
                phoneNumberField.setText(phoneNumber);
            }
        }
    }

    @FXML
    public void addDigit6() {
        // Size of a US phone number is 14 when written as a string
        if (phoneNumber.length() < 14) {
            if (phoneNumber.isEmpty() == true) {
                phoneNumber += "(" + "6";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 3) {
                phoneNumber += "6" + ")" + "-";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 8) {
                phoneNumber += "6" + "-";
                phoneNumberField.setText(phoneNumber);
            } else {
                phoneNumber += "6";
                phoneNumberField.setText(phoneNumber);
            }
        }
    }

    @FXML
    public void addDigit7() {
        // Size of a US phone number is 14 when written as a string
        if (phoneNumber.length() < 14) {
            if (phoneNumber.isEmpty() == true) {
                phoneNumber += "(" + "7";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 3) {
                phoneNumber += "7" + ")" + "-";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 8) {
                phoneNumber += "7" + "-";
                phoneNumberField.setText(phoneNumber);
            } else {
                phoneNumber += "7";
                phoneNumberField.setText(phoneNumber);
            }
        }
    }

    @FXML
    public void addDigit8() {
        // Size of a US phone number is 14 when written as a string
        if (phoneNumber.length() < 14) {
            if (phoneNumber.isEmpty() == true) {
                phoneNumber += "(" + "8";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 3) {
                phoneNumber += "8" + ")" + "-";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 8) {
                phoneNumber += "8" + "-";
                phoneNumberField.setText(phoneNumber);
            } else {
                phoneNumber += "8";
                phoneNumberField.setText(phoneNumber);
            }
        }
    }

    @FXML
    public void addDigit9() {
        // Size of a US phone number is 14 when written as a string
        if (phoneNumber.length() < 14) {
            if (phoneNumber.isEmpty() == true) {
                phoneNumber += "(" + "9";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 3) {
                phoneNumber += "9" + ")" + "-";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 8) {
                phoneNumber += "9" + "-";
                phoneNumberField.setText(phoneNumber);
            } else {
                phoneNumber += "9";
                phoneNumberField.setText(phoneNumber);
            }
        }
    }

    @FXML
    public void addDigitStar() {
        // Size of a US phone number is 14 when written as a string
        if (phoneNumber.length() < 14) {
            if (phoneNumber.isEmpty() == true) {
                phoneNumber += "(" + "*";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 3) {
                phoneNumber += "*" + ")" + "-";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 8) {
                phoneNumber += "*" + "-";
                phoneNumberField.setText(phoneNumber);
            } else {
                phoneNumber += "*";
                phoneNumberField.setText(phoneNumber);
            }
        }
    }

    @FXML
    public void addDigitHashtag() {
        // Size of a US phone number is 14 when written as a string
        if (phoneNumber.length() < 14) {
            if (phoneNumber.isEmpty() == true) {
                phoneNumber += "(" + "#";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 3) {
                phoneNumber += "#" + ")" + "-";
                phoneNumberField.setText(phoneNumber);
            } else if (phoneNumber.length() == 8) {
                phoneNumber += "#" + "-";
                phoneNumberField.setText(phoneNumber);
            } else {
                phoneNumber += "#";
                phoneNumberField.setText(phoneNumber);
            }
        }
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

