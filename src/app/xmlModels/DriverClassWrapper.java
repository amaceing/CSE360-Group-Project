package app.xmlModels;

import app.models.Driver;
import app.xmlModels.DriverClassWrapper;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * Created by anthonymace on 10/24/15.
 */
public class DriverClassWrapper {

    public static void write(Driver driver, String fileName) {
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
            encoder.writeObject(driver);
            encoder.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
