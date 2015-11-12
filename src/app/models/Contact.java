package app.models;

/**
 * Created by Marius on 11/11/2015.
 */
public class Contact {

    private int ID;
    private int driverID;
    private String PhoneNumber;

    public Contact() {
        this.ID = 0;
        this.PhoneNumber = "";
    }

    public Contact(int ID, String phoneNumber) {
        this.ID = ID;
        this.PhoneNumber = PhoneNumber;
    }

    public void setDriverID(int driverID) { this.driverID = driverID; }

    public int getDriverID() { return driverID; }

    public void setID(int ID) { this.ID = ID; }

    public int getID() { return ID; }

    public void setphoneNumber(String phoneNumber) { this.PhoneNumber = PhoneNumber; }

    public String getPhoneNumber() { return PhoneNumber; }
}
