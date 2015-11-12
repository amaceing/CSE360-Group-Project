package app.controllers;
import app.VistaNavigator;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import app.models.RadioHistory;

import java.net.URL;
import java.util.ResourceBundle;

public class RadioHistController  implements Initializable {

    @FXML
    private TopBarController topBarController;

    @FXML
    private TableView<RadioHistory> radioTableView;

    @FXML
    private TableColumn<RadioHistory, String> name;

    @FXML
    private  TableColumn<RadioHistory, String> station;

    @FXML
    private TableColumn<RadioHistory, String> date;

    @FXML
    private TableColumn<RadioHistory, String> time;

    @FXML
    private TableColumn<RadioHistory, Double> duration;


    private ObservableList<RadioHistory> radioHistory;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        topBarController.setBackButton(VistaNavigator.INFORMATION, RadioHistController.this);

        radioHistory = radioTableView.getItems();
        radioHistory.add(new RadioHistory(1, "Drew", "92.5 FM", "10/31/15", "3:30 PM", 4.5));
        radioHistory.add(new RadioHistory(2, "Arin", "93.3 FM", "3/4/15", "5:45 PM", 10.0));
        radioHistory.add(new RadioHistory(3, "Mario", "1000 AM", "4/6/15", "1:00 AM", 145.9));
        radioHistory.add(new RadioHistory(4, "Anthony","1010 AM", "10/28/15", "2:30 AM", 354.89));
    }

}