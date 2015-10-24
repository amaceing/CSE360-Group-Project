package app;

import app.models.Driver;
import app.models.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
        System.out.println("Opened database successfully");
        createDriverTable();
    }

    public void createDriverTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

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
        System.out.println("Table created successfully");
    }

    public static void insertRecord(Object obj) {
        String sql;
        if (obj instanceof Driver) {
            sql = "INSERT INTO DRIVER  (FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) ";
            sql += "VALUES ('" + ((Driver) obj).getFirstName() + "', '" + ((Driver) obj).getLastName() + "', '";
            sql += ((Driver) obj).getUsername()
        }
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO " +  table + " (FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) " +
                    "VALUES ('"+ this.session.getDriver().getFirstName() + "', '";
            sql += session.getDriver().getLastName() + "', '" + session.getDriver().getUsername() + "', '" + session.getDriver().getPassword() + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
        setDriverIDFromRecord();
    }

    public static void insertDriverRecord() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO DRIVER (FIRST_NAME, LAST_NAME, USERNAME, PASSWORD) " +
                    "VALUES ('"+ this.session.getDriver().getFirstName() + "', '";
            sql += session.getDriver().getLastName() + "', '" + session.getDriver().getUsername() + "', '" + session.getDriver().getPassword() + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
        setDriverIDFromRecord();
    }

    public static void setDriverIDFromRecord() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT ID FROM DRIVER WHERE USERNAME = '" + session.getDriver().getUsername() + "'");
            while ( rs.next() ) {
                int id = rs.getInt("id");
                session.getDriver().setID(id);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }


}
