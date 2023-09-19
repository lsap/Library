package io.github.lsap.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

    public Connection getConnection() {
        var uri = "jdbc:postgresql://localhost/library";
        var login = "lsap";
        var password = "secret";
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(uri, login, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getLocalizedMessage());
            return null;
        }
    } 
}

