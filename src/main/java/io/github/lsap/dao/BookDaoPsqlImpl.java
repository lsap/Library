package io.github.lsap.dao;

import io.github.lsap.exception.DaoLayerException;
import io.github.lsap.persistence.Book;
import io.github.lsap.persistence.Reader;
import io.github.lsap.service.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDaoPsqlImpl implements BookDao {

    /*private Book mapRelationToBook(ResultSet resultSet) throws SQLException {
        var query = new Book();
        return book;
    }
*/
    @Override
    public List<Book> getAll() {
        var books = new ArrayList<Book>();
        var query = "SELECT * FROM books";
        try (var connection = ConnectionService.getConnection();
             var statement = connection.prepareStatement(query);
             var resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                books.add(new Book(resultSet.getInt(1),
                    resultSet.getString(2), resultSet.getString(3)));
            }
            return books;
        } catch (SQLException e) {
            throw new DaoLayerException(e);
        }
    }

}

