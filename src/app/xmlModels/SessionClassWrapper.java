package app.xmlModels;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;
import app.models.Session;

/**
 * Created by anthonymace on 10/17/15.
 */


public class SessionClassWrapper {

    public static void write(Session sesh, String fileName) {
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
            encoder.writeObject(sesh);
            encoder.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    public static Session read(String filename) {
//        try {
//            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
//            Session o = (Session)decoder.readObject();
//            decoder.close();
//        } catch (Exception e) {
//        }
//        return o;
//    }

}
