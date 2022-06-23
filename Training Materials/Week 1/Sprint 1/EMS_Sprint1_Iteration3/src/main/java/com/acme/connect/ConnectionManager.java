package com.acme.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static String url = "jdbc:postgresql://127.0.0.1:5432/EMS";
//    private static String driverName = "com.mysql.jdbc.Driver";
    private static String username = "postgres";
    private static String password = "password";
    private static Connection con;
//    private static String urlstring;

    public static Connection getConnection() {

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            // log an exception-for example:
            System.out.println("Failed to create the database connection.");
        }

        return con;
    }
}
