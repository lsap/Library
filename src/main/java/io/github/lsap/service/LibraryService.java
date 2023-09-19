package io.github.lsap.service;

import java.util.List;

import io.github.lsap.persistence.Book;

public interface LibraryService {
    List<Book> getAllBooks();
}

