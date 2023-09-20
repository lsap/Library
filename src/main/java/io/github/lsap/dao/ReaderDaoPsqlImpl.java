package io.github.lsap.dao;

import io.github.lsap.exception.DaoLayerException;
import io.github.lsap.persistence.Book;
import io.github.lsap.persistence.Reader;
import io.github.lsap.service.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReaderDaoPsqlImpl implements ReaderDao {

    @Override
    public List<Reader> getAll() {
        var readers = new ArrayList<Reader>();
        var query = "SELECT * FROM readers";
        try (var connection = ConnectionService.getConnection();
             var statement = connection.prepareStatement(query);
             var resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                readers.add(new Reader(resultSet.getInt(1),
                    resultSet.getString(2)));
            }
            return readers;
        } catch (SQLException e) {
            throw new DaoLayerException(e);
        }
    }
}

