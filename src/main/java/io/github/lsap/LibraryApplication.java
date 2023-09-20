package io.github.lsap;

import io.github.lsap.dao.BookDao;
import io.github.lsap.dao.BookDaoPsqlImpl;
import io.github.lsap.dao.ReaderDao;
import io.github.lsap.dao.ReaderDaoPsqlImpl;
import io.github.lsap.exception.NoEntityWithSuchIdException;
import io.github.lsap.persistence.Book;
import io.github.lsap.persistence.Reader;
import io.github.lsap.service.LibraryService;
import io.github.lsap.service.LibraryServiceImpl;
import io.github.lsap.ui.Ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LibraryApplication {

    public static void main(String[] args) {
        var bookDao = new BookDaoPsqlImpl();
        var readerDao = new ReaderDaoPsqlImpl();
        var libraryService = new LibraryServiceImpl(bookDao, readerDao);
        var ui = new Ui(libraryService);
        ui.render();
    }

}

