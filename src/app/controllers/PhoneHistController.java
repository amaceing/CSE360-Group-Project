package app.controllers;
import app.VistaNavigator;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import app.models.PhoneHistory;

import java.net.URL;
import java.util.ResourceBundle;

public class PhoneHistController  implements Initializable {

    @FXML
    private TopBarController topBarController;

    @FXML
    private TableView<PhoneHistory> phoneTableView;

    @FXML
    private TableColumn<PhoneHistory, String> name;

    @FXML
    private  TableColumn<PhoneHistory, Double> number;

    @FXML
    private TableColumn<PhoneHistory, String> date;

    @FXML
    private TableColumn<PhoneHistory, Double> duration;


    private ObservableList<PhoneHistory> phoneHistory;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        topBarController.setBackButton(VistaNavigator.INFORMATION);

//        phoneTableView.setPrefWidth(600);


        phoneHistory = phoneTableView.getItems();
        phoneHistory.add(new PhoneHistory("Drew", "555-555-5555", "10/31/15", 4.5));
        phoneHistory.add(new PhoneHistory("Arin", "111-111-1111", "3/4/15", 10.0));
        phoneHistory.add(new PhoneHistory("Mario", "123-456-7890", "4/6/15", 145.9));
        phoneHistory.add(new PhoneHistory("Anthony","243-465-2349", "10/28/15", 354.89));
    }

}