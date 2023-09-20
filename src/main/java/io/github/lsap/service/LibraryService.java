package io.github.lsap.service;

import io.github.lsap.persistence.Book;
import io.github.lsap.persistence.Reader;

import java.util.List;

public interface LibraryService {

    List<Book> getAllBooks();

    List<Reader> getAllReaders();

}

