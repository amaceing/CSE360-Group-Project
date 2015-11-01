package app.controllers;
import app.SqlDriver;
import app.VistaNavigator;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by arinhouck on 10/17/15.
 */
public class RadioController  implements Initializable {
    private static MainController mainController;

    @FXML
    private TopBarController topBarController;

    @FXML
    private Button AMButton;

    @FXML
    private Button FMButton;

    @FXML
    private ListView stationList;

    @FXML
    private Label volumeLabel;

    private int volume;

    private ObservableList<String> stations;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AMButton.getStyleClass().add("active");
        topBarController.setBackButton(VistaNavigator.DASHBOARD);

        mainController = VistaNavigator.getMainController();
        volume = mainController.getSession().getDriver().getRadioVolume();
        volumeLabel.setText(Integer.toString(volume));

        stations = stationList.getItems();
        setStations("AM");
    }

    private void setStations(String type) {
        stations.clear();
        switch (type) {
            case "FM":
                stations.add("92.5");
                stations.add("93.3");
                stations.add("98.3");
                stations.add("103.9");
                stations.add("104.7");
                stations.add("107.9");
                break;
            case "AM":
                stations.add("1000");
                stations.add("1100");
                stations.add("1200");
                stations.add("1300");
                stations.add("1400");
                stations.add("1500");
                break;
        }
    }

    @FXML
    public void volumeUp() {
        if (volume != 10) {
            volumeLabel.setText(Integer.toString(++volume));
            SqlDriver.updateRecord("DRIVERS", "RADIO_VOLUME", mainController.getSession().getDriver().getID(), volume);
            mainController.getSession().getDriver().setRadioVolume(volume);
        }
    }

    @FXML
    public void volumeDown() {
        if (volume != 0) {
            volumeLabel.setText(Integer.toString(--volume));
            SqlDriver.updateRecord("DRIVERS", "RADIO_VOLUME", mainController.getSession().getDriver().getID(), volume);
            mainController.getSession().getDriver().setRadioVolume(volume);
        }
    }

    @FXML
    public void setAM() {
        FMButton.getStyleClass().removeAll("active");
        AMButton.getStyleClass().add("active");
        setStations("AM");
    }

    @FXML
    public void setFM() {
        AMButton.getStyleClass().removeAll("active");
        FMButton.getStyleClass().add("active");
        setStations("FM");
    }

}
