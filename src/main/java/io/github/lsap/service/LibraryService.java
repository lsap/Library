package io.github.lsap.service;

import io.github.lsap.persistence.Book;

import java.util.List;

public interface LibraryService {
    List<Book> getAllBooks();
}

