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

        double milesRemaining = mainController.getSession().getDriver().getMilesRemaining();

        switch (type) {
            case "FM":
                AMButton.getStyleClass().removeAll("active");
                FMButton.getStyleClass().add("active");
                SqlDriver.updateRecord("DRIVERS", "CHANNEL", mainController.getSession().getDriver().getID(), "FM");
                mainController.getSession().getDriver().setChannel("FM");

                if (milesRemaining < 100) {
                    stationsFM(1);
                } else if (milesRemaining >= 100 && milesRemaining < 200) {
                    stationsFM(2);
                } else {
                    stationsFM(3);
                }
                break;
            case "AM":
                FMButton.getStyleClass().removeAll("active");
                AMButton.getStyleClass().add("active");
                SqlDriver.updateRecord("DRIVERS", "CHANNEL", mainController.getSession().getDriver().getID(), "AM");
                mainController.getSession().getDriver().setChannel("AM");

                if (milesRemaining < 100) {
                    stationsAM(1);
                } else if (milesRemaining >= 100 && milesRemaining < 200) {
                    stationsAM(2);
                } else {
                    stationsAM(3);
                }
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

    private void stationsAM(int location) {
        switch(location) {
            case 1:
                stations.add("550");
                stations.add("580");
                stations.add("620");
                stations.add("710");
                stations.add("740");
                break;
            case 2:
                stations.add("780");
                stations.add("830");
                stations.add("860");
                stations.add("910");
                stations.add("960");
                break;
            case 3:
                stations.add("990");
                stations.add("1010");
                stations.add("1060");
                stations.add("1100");
                stations.add("1150");
                break;
        }
    }

    private void stationsFM (int location) {
        switch(location) {
            case 1:
                stations.add("88.3");
                stations.add("88.7");
                stations.add("88.9");
                stations.add("89.1");
                stations.add("89.5");
                break;
            case 2:
                stations.add("89.7");
                stations.add("89.9");
                stations.add("90.3");
                stations.add("90.9");
                stations.add("91.1");
                break;
            case 3:
                stations.add("96.9");
                stations.add("97.5");
                stations.add("97.9");
                stations.add("98.3");
                stations.add("98.7");
                break;
        }
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

    public void setClosing(boolean closing) {
        this.closing.set(closing);
    }


}
