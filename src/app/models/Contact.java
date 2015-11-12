package app.models;

/**
 * Created by Marius on 11/11/2015.
 */
public class Contact {

    private int ID;
    private int driverID;
    private String phoneNumber;

    public Contact() {
        this.ID = 0;
        this.phoneNumber = "";
    }

    public Contact(int ID, String phoneNumber) {
        this.ID = ID;
        this.phoneNumber = phoneNumber;
    }

    public void setdriverID(int driverID) { this.driverID = driverID; }

    public int getDRIVER_ID(int driverID)  { return driverID; }

    public void setID(int ID) { this.ID = ID; }

    public int getID() { return ID; }

    public void setphoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getphoneNumber(String phoneNumber) { return phoneNumber; }
}
