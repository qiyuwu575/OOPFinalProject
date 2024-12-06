package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The DatabaseConnection class provides a utility for establishing connections to the MySQL database.
 * It includes methods for loading the database driver and creating database connections.
 */
public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/AEP?useSSL=false&serverTimezone=UTC";
    private static final String USER = "test";
    private static final String PASSWORD = "Test9900";

    // Static block to load the MySQL database driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates and returns a connection to the MySQL database.
     *
     * @return a Connection object for interacting with the database
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
