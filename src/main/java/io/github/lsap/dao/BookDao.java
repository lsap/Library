package io.github.lsap.dao;

import io.github.lsap.persistence.Book;
import java.util.List;

public interface BookDao {

    List<Book> getAll();
}

