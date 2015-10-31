package app.controllers;
import app.VistaNavigator;
import app.models.Driver;
import app.models.DriverHistory;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


//Helpful links
//http://docs.oracle.com/javafx/2/fxml_get_started/fxml_tutorial_intermediate.htm

// http://stackoverflow.com/questions/11180884/how-to-populate-a-tableview-that-is-defined-in-an-fxml-file-that-is-designed-in

public class DriverHistController implements Initializable {

    @FXML
    private TopBarController topBarController;

    @FXML
    private TableView<DriverHistory> tableView;

    @FXML
    private TableColumn<DriverHistory, String> name;

    @FXML
    private TableColumn<DriverHistory, String> date;

    @FXML
    private TableColumn<DriverHistory, Double> duration;

    @FXML
    private  TableColumn<DriverHistory, Double> avgSpeed;

    @FXML
    private TableColumn<DriverHistory, Double> maxSpeed;


    private ObservableList<DriverHistory> driverHistory;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        topBarController.setBackButton(VistaNavigator.INFORMATION);


        driverHistory = tableView.getItems();
        driverHistory.add(new DriverHistory("Drew", "10/31/15", 4.5, 50.0, 100.0));
        driverHistory.add(new DriverHistory("Arin", "3/4/15", 10.0, 88.9, 90.7));
        driverHistory.add(new DriverHistory("Mario", "4/6/15", 145.9, 45.0, 67.8));
        driverHistory.add(new DriverHistory("Anthony", "10/28/15", 354.89, 34.5, 78.7 ));


    }

}