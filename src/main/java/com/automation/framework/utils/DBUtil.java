package com.automation.framework.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * Database utility class for handling SQL connections and queries
 */
public class DBUtil {
    private static Connection connection;
    
    public static void connect(String propertiesFile) {
        Properties props = PropertyReader.loadProperties(propertiesFile);
        try {
            Class.forName(props.getProperty("db.driver"));
            connection = DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
            );
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }

    public static ResultSet executeQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(query);
        } catch (Exception e) {
            throw new RuntimeException("Query execution failed", e);
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            System.err.println("Error closing database connection: " + e.getMessage());
        }
    }
}
