package app;

import app.models.Driver;
import app.models.DriverHistory;
import app.models.Session;

import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.List;

import app.models.Session;

/**
 * Created by anthonymace on 10/24/15.
 */
public class SqlDriver {
    private static Connection connection;
    private static Statement stmt;

    public void createTestDBFile() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        createDriverTable();
    }

    public void createDriverTable() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            stmt = connection.createStatement();
            String sql = "CREATE TABLE DRIVER " +
                    "(ID    INTEGER     PRIMARY KEY    autoincrement    NOT NULL," +
                    " FIRST_NAME    CHAR(50)    NOT NULL, " +
                    " LAST_NAME     CHAR(50)    NOT NULL, " +
                    " USERNAME      CHAR(50)    NOT NULL, " +
                    " PASSWORD      CHAR(50)    NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public void createDriverHistoryTable() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            stmt = connection.createStatement();
            String sql = "CREATE TABLE DRIVER_HISTORY " +
                    "(ID    INTEGER     PRIMARY KEY    autoincrement    NOT NULL," +
                    " FIRST_NAME    CHAR(50)    NOT NULL, " +
                    " DATE          CHAR(50)    NOT NULL, " +
                    " DURATION      REAL        NOT NULL, " +
                    " MAX_SPEED     REAL        NOT NULL, " +
                    " AVG_SPEED     REAL        NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public static void insertRecord(Object obj) {
        String sql = "";
        if (obj instanceof Driver && !isRecord(obj)) {
            sql = "INSERT INTO DRIVER  (FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) ";
            sql += "VALUES ('" + ((Driver) obj).getFirstName() + "', '" + ((Driver) obj).getLastName() + "', '";
            sql += ((Driver) obj).getUsername() + "', '" + ((Driver) obj).getPassword() + "');";
        } else if (obj instanceof DriverHistory && !isRecord(obj)) {
            sql = "INSERT INTO DRIVER_HISTORY (FIRST_NAME, DATE, DURATION, MAX_SPEED, AVG_SPEED) ";
            sql += "VALUES ('" + ((DriverHistory) obj).getName() + "', '" + ((DriverHistory) obj).getDate() + "', '";
            sql += ((DriverHistory) obj).getDuration() + "', '" + ((DriverHistory) obj).getMaxSpeed() + "', '";
            sql += ((DriverHistory) obj).getAvgSpeed() + "');";
        }
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            connection.commit();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        if (obj instanceof Driver) {
            setDriverIDFromRecord((Driver) obj);
        }
    }

    public static List<String> getRecords(String table) {
        String select = "SELECT * FROM " + table.toUpperCase();
        ResultSet rs = null;
        List results = new ArrayList<String>();
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
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

    private static void setDriverIDFromRecord(Driver driver) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID FROM DRIVER WHERE USERNAME = '" + driver.getUsername() + "'");
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
            select = "SELECT ID FROM DRIVER WHERE USERNAME = '" + ((Driver) obj).getUsername() + "'";
        }
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
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
