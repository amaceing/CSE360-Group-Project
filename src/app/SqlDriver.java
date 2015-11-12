package app;

import app.models.Contact;
import app.models.Driver;
import app.models.RadioHistory;
import java.sql.*;
import java.util.*;
import java.util.List;


/**
 * Created by anthonymace on 10/24/15.
 */
public class SqlDriver {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement ps;

    private static String DB_NAME = "jdbc:sqlite:test.db";
    private static String LIBRARY = "org.sqlite.JDBC";

    public void createTestDBFile() {
        try {
            Class.forName(LIBRARY);
            connection = DriverManager.getConnection(DB_NAME);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        createDriverTable();
    }

    public void createDriverTable() {
        try {
            Class.forName(LIBRARY);
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            stmt = connection.createStatement();

            //TODO: CHAR (50) can't be manually created in sql browser so using TEXT?
            String sql = "CREATE TABLE DRIVERS " +
                    "(ID    INTEGER     PRIMARY KEY    autoincrement    NOT NULL," +
                    " FIRST_NAME    CHAR(50)    NOT NULL, " +
                    " LAST_NAME     CHAR(50)    NOT NULL, " +
                    " USERNAME      CHAR(50)    NOT NULL, " +
                    " PASSWORD      CHAR(50)    NOT NULL, " +
                    " CHANNEL      CHAR(50), " +
                    " RADIO_VOLUME  INTEGER)";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public static void insertRecord(Object obj) {

        try {
            Class.forName(LIBRARY);
            connection = DriverManager.getConnection(DB_NAME);

            String sql = "";
            if (obj instanceof Driver && !isRecord(obj)) {
                ps = connection.prepareStatement(
                        "INSERT INTO DRIVERS  (FIRST_NAME, LAST_NAME, USERNAME, PASSWORD, CHANNEL, RADIO_VOLUME, STATION, PHONE_VOLUME, MILES_REMAINING, AVERAGE_SPEED, MAX_SPEED) " +
                                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
                );
                ps.setString(1, ((Driver) obj).getFirstName());
                ps.setString(2, ((Driver) obj).getLastName());
                ps.setString(3, ((Driver) obj).getUsername());
                ps.setString(4, ((Driver) obj).getPassword());
                ps.setString(5,  ((Driver) obj).getChannel());
                ps.setInt(6, ((Driver) obj).getRadioVolume());
                ps.setInt(7,  ((Driver) obj).getStation());
                ps.setInt(8,  ((Driver) obj).getPhoneVolume());
                ps.setDouble(9, ((Driver) obj).getMilesRemaining());
                ps.setDouble(10, ((Driver) obj).getAverageSpeed());
                ps.setDouble(11,  ((Driver) obj).getMaxSpeed());
            } else if (obj instanceof RadioHistory) {
                ps = connection.prepareStatement(
                        "INSERT INTO RADIO_HISTORIES  (DRIVER_ID, NAME, STATION, DATE, TIME, DURATION) " +
                        "VALUES(?, ?, ?, ?, ?, ?)"
                );
                ps.setInt(1,  ((RadioHistory) obj).getdriverID());
                ps.setString(2, ((RadioHistory) obj).getName());
                ps.setString(3, ((RadioHistory) obj).getStation());
                ps.setString(4, ((RadioHistory) obj).getDate());
                ps.setString(5,  ((RadioHistory) obj).getTime());
                ps.setDouble(6, ((RadioHistory) obj).getDuration());
            }
            else if (obj instanceof Contact) {
                ps = connection.prepareStatement(
                        "INSERT INTO CONTACTS   (DRIVER_ID, PHONE_NUMBER) " + "VALUES(?, ?)"
                );
                ps.setInt(1, ((Contact) obj).getDriverID());
                ps.setString(2, ((Contact) obj).getPhoneNumber());
            }

            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        if (obj instanceof Driver) {
            setDriverIDFromRecord((Driver) obj);
        }
    }

    public static String[] findBy(String table, String column, String value) {
        String[] array = new String[0];
        String select = "";
        switch(table) {
            case "DRIVERS":
                select = "SELECT * FROM DRIVERS WHERE " + column + " = '" + value + "'";
                break;
        }
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_NAME);
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(select);
            ResultSetMetaData rsData = rs.getMetaData();
            int columnsInRow = rsData.getColumnCount();
            array = new String[columnsInRow];
            if (rs.isBeforeFirst()) {
                for (int i = 0; i < columnsInRow; i++) {
                    array[i] = rs.getString(i + 1);
                }
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        return array;
    }

    public static List<String> getRecords(String table) {
        String select = "SELECT * FROM " + table.toUpperCase();
        ResultSet rs = null;
        List results = new ArrayList<String>();
        try {
            Class.forName(LIBRARY);
            connection = DriverManager.getConnection(DB_NAME);
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            rs = stmt.executeQuery(select);
            ResultSetMetaData rsData = rs.getMetaData();
            int columnsInRow = rsData.getColumnCount();
            while (rs.next()) {
                String row = "";
                for (int i = 1; i <= columnsInRow; i++) {
                    row += rs.getString(i) + " ";
                }
                results.add(row);
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return results;
    }

    public static void updateRecord(String table, String column, int ID, Object value) {
        try {
            Class.forName(LIBRARY);
            connection = DriverManager.getConnection(DB_NAME);

            ps = connection.prepareStatement(
                "UPDATE " + table.toUpperCase() + " " +
                "SET " + column.toUpperCase() + " = ? " +
                "WHERE ID = ?"
            );

            if (value instanceof String) {
                ps.setString(1, value.toString());
            } else {
                ps.setInt(1, Integer.parseInt(value.toString()));
            }
            ps.setInt(2, ID);

            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    private static void setDriverIDFromRecord(Driver driver) {
        try {
            Class.forName(LIBRARY);
            connection = DriverManager.getConnection(DB_NAME);
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID FROM DRIVERS WHERE USERNAME = '" + driver.getUsername() + "'");
            while (rs.next()) {
                int id = rs.getInt("ID");
                driver.setID(id);
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    private static boolean isRecord(Object obj) {
        String select = "";
        if (obj instanceof Driver) {
            select = "SELECT ID FROM DRIVERS WHERE USERNAME = '" + ((Driver) obj).getUsername() + "'";
        }
        try {
            Class.forName(LIBRARY);
            connection = DriverManager.getConnection(DB_NAME);
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(select);
            if (rs.isBeforeFirst()) {
                return true;
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return false;
    }

}
