package app.controllers;
import app.SqlDriver;
import app.VistaNavigator;
import app.models.RadioHistory;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

/**
 * Created by arinhouck on 10/17/15.
 */
public class RadioController implements Initializable {
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

    private LocalDate date;
    private LocalTime start;

    private ObservableList<String> stations;

    private BooleanProperty closing;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AMButton.getStyleClass().add("active");
        topBarController.setBackButton(VistaNavigator.DASHBOARD, RadioController.this);

        mainController = VistaNavigator.getMainController();
        volume = mainController.getSession().getDriver().getRadioVolume();
        volumeLabel.setText(Integer.toString(volume));

        stations = stationList.getItems();

        setStations(mainController.getSession().getDriver().getChannel());
        stationList.getSelectionModel().select(mainController.getSession().getDriver().getStation());
        date = LocalDate.now();
        start = LocalTime.now();
        closing = new SimpleBooleanProperty(false);

        closing.addListener((observable, oldValue, newValue) -> {
            saveHistory();
        });

        stationList.getSelectionModel().selectedItemProperty()
        .addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                saveStation(stationList.getSelectionModel().getSelectedIndex());
            }
        });

    }

    private void saveHistory() {
        long duration = ChronoUnit.SECONDS.between(start, LocalTime.now());
        DateTimeFormatter outputFormat = new DateTimeFormatterBuilder().appendPattern("hh:mm a").toFormatter();
        SqlDriver.insertRecord(new RadioHistory(
                        mainController.getSession().getDriver().getID(),
                        mainController.getSession().getDriver().getFirstName(),
                        stationList.getSelectionModel().getSelectedItem().toString(),
                        date.toString(),
                        start.format(outputFormat).toString(),
                        (double) duration
                )
        );
    }

    private void setStations(String type) {
        stations.clear();

        switch (type) {
            case "FM":
                AMButton.getStyleClass().removeAll("active");
                FMButton.getStyleClass().add("active");
                SqlDriver.updateRecord("DRIVERS", "CHANNEL", mainController.getSession().getDriver().getID(), "FM");
                mainController.getSession().getDriver().setChannel("FM");
                stations.add("92.5");
                stations.add("93.3");
                stations.add("98.3");
                stations.add("103.9");
                stations.add("104.7");
                stations.add("107.9");
                break;
            case "AM":
                FMButton.getStyleClass().removeAll("active");
                AMButton.getStyleClass().add("active");
                SqlDriver.updateRecord("DRIVERS", "CHANNEL", mainController.getSession().getDriver().getID(), "AM");
                mainController.getSession().getDriver().setChannel("AM");
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
        setStations("AM");
        saveStation(0);
        stationList.getSelectionModel().select(mainController.getSession().getDriver().getStation());
    }

    @FXML
    public void setFM() {
        setStations("FM");
        saveStation(0);
        stationList.getSelectionModel().select(mainController.getSession().getDriver().getStation());
    }

    private void saveStation(int stationIndex) {
        mainController.getSession().getDriver().setStation(stationIndex);
        SqlDriver.updateRecord("DRIVERS", "STATION", mainController.getSession().getDriver().getID(), stationIndex);
    }

    public boolean getClosing() {
        return closing.get();
    }

    public BooleanProperty closingProperty() {
        return closing;
    }

    public void setClosing(boolean closing) { this.closing.set(closing);}


}
