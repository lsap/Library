package io.github.lsap.service;

import io.github.lsap.dao.BookDao;
import io.github.lsap.dao.ReaderDao;
import io.github.lsap.exception.ServiceLayerException;
import io.github.lsap.persistence.Book;
import io.github.lsap.persistence.Reader;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    private final BookDao bookDao;
    private final ReaderDao readerDao;

    public LibraryServiceImpl(BookDao bookDao, ReaderDao readerDao) {
        this.bookDao = bookDao;
        this.readerDao = readerDao;
    }
    
    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAll();
    }

    @Override
    public List<Reader> getAllReaders() {
        return readerDao.getAll();
    }
}

