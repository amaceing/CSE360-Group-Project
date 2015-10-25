package app;

import app.models.Driver;
import app.models.Session;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.List;

import app.models.Session;

/**
 * Created by anthonymace on 10/24/15.
 */
public class SqlDriver {

    public void createTestDBFile() {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        createDriverTable();
    }

    public void createDriverTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            stmt = c.createStatement();
            String sql = "CREATE TABLE DRIVER " +
                    "(ID    INTEGER     PRIMARY KEY    autoincrement    NOT NULL," +
                    " FIRST_NAME    CHAR(50)    NOT NULL, " +
                    " LAST_NAME     CHAR(50)    NOT NULL, " +
                    " USERNAME      CHAR(50)    NOT NULL, " +
                    " PASSWORD      CHAR(50)    NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public static void insertRecord(Object obj) {
        Connection c = null;
        Statement stmt = null;
        String sql = "";
        if (obj instanceof Driver && !isRecord(obj)) {
            sql = "INSERT INTO DRIVER  (FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) ";
            sql += "VALUES ('" + ((Driver) obj).getFirstName() + "', '" + ((Driver) obj).getLastName() + "', '";
            sql += ((Driver) obj).getUsername() + "', '" + ((Driver) obj).getPassword() + "');";
        }
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
        setDriverIDFromRecord((Driver) obj);
    }

    public static List<String> getRecords(String table) {
        Connection c = null;
        Statement stmt = null;
        String select = "SELECT * FROM " + table.toUpperCase();
        ResultSet rs = null;
        List results = new ArrayList<String>();
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            rs = stmt.executeQuery(select);
            while ( rs.next() ) {
                results.add(rs.getString(1));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return results;
    }

    public static void setDriverIDFromRecord(Driver driver) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID FROM DRIVER WHERE USERNAME = '" + driver.getUsername() + "'");
            while ( rs.next() ) {
                int id = rs.getInt("ID");
                driver.setID(id);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    private static boolean isRecord(Object obj) {
        Connection c = null;
        Statement stmt = null;
        String select = "";
        if (obj instanceof Driver) {
            select = "SELECT ID FROM DRIVER WHERE USERNAME = '" + ((Driver) obj).getUsername() + "'";
        }
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(select);
            if (rs.isBeforeFirst()) {
                return true;
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return false;
    }

}
