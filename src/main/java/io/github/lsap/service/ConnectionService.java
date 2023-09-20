package io.github.lsap.service;

import io.github.lsap.exception.DaoLayerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

    public static Connection getConnection() {
        var uri = "jdbc:postgresql://localhost/library";
        var login = "lsap";
        var password = "secret";
        try {
            return DriverManager.getConnection(uri, login, password);
        } catch (SQLException e) {
            throw new DaoLayerException("Can't connect to DB " + e.getLocalizedMessage());
        }
    } 
}

