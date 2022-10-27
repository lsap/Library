package io.github.lsap.repository;

import io.github.lsap.persistence.Book;
import io.github.lsap.persistence.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class Storage {

    private static final AtomicLong bookId = new AtomicLong(500);

    private static final AtomicLong readerId = new AtomicLong(500);

    private static final List<Book> books = new ArrayList<>();
    private static final List<Reader> readers = new ArrayList<>();
    private static final Map<Long, List<Long>> readerBooks = new HashMap<>();

    static {
        var book0 = new Book();
        book0.setId(497L);
        book0.setTitle("Anthem");
        book0.setAuthor("Ayn Rand");
        var book1 = new Book();
        book1.setId(498L);
        book1.setTitle("Atlas shrugged");
        book1.setAuthor("Alisa Rosenbaum");
        var book2 = new Book();
        book2.setId(499L);
        book2.setTitle("Spacepilot");
        book2.setAuthor("Stanislav Lem");
        books.addAll(List.of(book0, book1, book2));
        var reader0 = new Reader();
        reader0.setId(497L);
        reader0.setName("John");
        var reader1 = new Reader();
        reader1.setId(498L);
        reader1.setName("Jane");
        var reader2 = new Reader();
        reader2.setId(499L);
        reader2.setName("Ijon");
        readers.addAll(List.of(reader0, reader1, reader2));
    }

    private Storage() {}

    public static List<Book> getAllBooks() {
        return books;
    }

    public static List<Reader> getAllReaders() {
        return readers;
    }

    public static AtomicLong addReader(Reader reader) {
        reader.setId(readerId.incrementAndGet());
        readers.add(reader);
        readerBooks.put(reader.getId(), new ArrayList<>());
        return readerId;
    }

    public static AtomicLong addBook(Book book) {
        book.setId(bookId.incrementAndGet());
        books.add(book);
        return bookId;
    }

    public static void lendBookToReader(Long bookId, Long readerId) {
        var readerBooks = getReaderBooks().get(readerId);
        readerBooks.add(bookId);
    }

    public static Map<Long, List<Long>> getReaderBooks() {
        return readerBooks;
    }

    public static boolean containsBookWithId(Long bookId) {
        return books.stream().anyMatch(e -> e.getId().equals(bookId));
    }

    public static boolean containsReaderWithId(Long readerId) {
        return readers.stream().anyMatch(e -> e.getId().equals(readerId));
    }

    public static void returnBookFromReader(Long bookId, Long readerId) {
        var readerBooks = getReaderBooks().get(readerId);
        readerBooks.remove(bookId);
    }

    public static Optional<Long> getReaderIdByBookId(Long bookId) {
        return getReaderBooks().entrySet()
                .stream()
                .filter(entry -> entry.getValue().contains(bookId))
                .findFirst()
                .map(Map.Entry::getKey);
    }

    public static Optional<Reader> getReaderById(Long id) {
        return getAllReaders()
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public static Optional<Book> getBookById(Long id) {
        return getAllBooks()
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public static List<Long> getBooksIdsByReaderId(Long readerId) {
        return getReaderBooks().get(readerId);
    }

}
