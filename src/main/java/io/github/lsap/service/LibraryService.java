package io.github.lsap.service;

import io.github.lsap.exception.NoEntityWithSuchIdException;
import io.github.lsap.persistence.Book;
import io.github.lsap.persistence.Reader;
import io.github.lsap.repository.Storage;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class LibraryService {

    private final Scanner scanner = new Scanner(System.in);
    private final Connection connection = new ConnectionService().getConnection();
    public void showAllBooks() {
        System.out.println(List.of(Storage.getAllBooks()));
    }

    public void showAllReaders() {
        System.out.println(List.of(Storage.getAllReaders()));
    }

    public void addNewReader() {
        System.out.println("Please enter new reader's full name!");
        var reader = new Reader(scanner.nextLine());
        var id = Storage.addReader(reader);
        System.out.println("Book with id " + id + " was added");
    }

    public void addNewBook() {
        System.out.println(
                "Please enter new book's title and author separated by “/”. E.g. name/author");
        var bookInput = scanner.nextLine();
        if (bookInput.contains("/")) {
            var splittedInput = bookInput.split("/");
            var book = new Book();
            try {
                book.setTitle(splittedInput[0]);
                book.setAuthor(splittedInput[1]);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.err.println(e.getLocalizedMessage());
            }
            var id = Storage.addBook(book);
            System.out.println("User with id " + id + " was added");
        } else {
            System.out.println("Please use '/' for separation");
        }
    }

    public void lendBookToReader() {
        System.out.println("Please enter bookID and reader's ID separated by “/”. E.g. d/f");
        var input = scanner.nextLine();
        if (input.contains("/")) {
            var splittedInput = input.split("/");
            var bookId = Long.parseLong(splittedInput[0]);
            var readerId = Long.parseLong(splittedInput[1]);
            try {
                bookLentToReader(bookId, readerId);
            } catch (NoEntityWithSuchIdException | NumberFormatException |
                    ArrayIndexOutOfBoundsException e) {
                System.err.println(e.getLocalizedMessage());
            }
        } else {
            System.out.println("Please use '/' for separation");
        }
    }

    public void returnBook() {
        System.out.println("Please enter book ID");
        var bookId = scanner.nextLong();
        try {
            returnBook(bookId);
        } catch (NoEntityWithSuchIdException | NumberFormatException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void showAllReaderBooks() {
        System.out.println("Please enter reader ID");
        var readerId = scanner.nextLong();
        try {
            var allBooksOfReader = getAllBooksByReader(readerId);
            if(allBooksOfReader.isEmpty()) {
                System.out.println("Reader with ID " + readerId + " has not borrowed books.");
            } else {
                allBooksOfReader.forEach(System.out::println);
            }
        } catch (NoEntityWithSuchIdException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void showReaderOfBook() {
        System.out.println("Please enter book ID");
        var bookId = scanner.nextLong();
        try {
            showReaderOfBookWithId(bookId);
        } catch (NoEntityWithSuchIdException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    private void showReaderOfBookWithId(Long bookId) {
        if(!Storage.containsBookWithId(bookId)) {
            throw new NoEntityWithSuchIdException(
                    "Book with a specified id " + bookId + " does not exist in the storage");
        }
        Storage.getReaderIdByBookId(bookId)
                .flatMap(Storage::getBookById)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println(
                                "Book with ID " + bookId + " is not borrowed. No reader to show.")
                );
    }

    private List<Long> getAllBooksByReader(Long readerId) {
        if(!Storage.containsReaderWithId(readerId)) {
            throw new NoEntityWithSuchIdException(
                    "Reader with a specified id " + readerId + " does not exist in the storage");
        }
        return Storage.getBooksIdsByReaderId(readerId);
    }

    private void returnBook(Long bookId) {
        if(!Storage.containsBookWithId(bookId)) {
            throw new NoEntityWithSuchIdException(
                    "Book with a specified id " + bookId + " does not exist in the storage");
        }
        Storage.getReaderIdByBookId(bookId).ifPresentOrElse(
                readerId -> Storage.returnBookFromReader(bookId, readerId),
                () -> System.err.println("Can't determine reader ID by book ID " + bookId)
        );
    }

    private void bookLentToReader(Long bookId, Long readerId) {
        if(!Storage.containsReaderWithId(readerId)) {
            throw new NoEntityWithSuchIdException(
                    "Reader with a specified id " + readerId + " does not exist in the storage");
        }
        else if(!Storage.containsBookWithId(bookId)) {
            throw new NoEntityWithSuchIdException(
                    "Book with a specified id " + bookId + " does not exist in the storage");
        } else Storage.lendBookToReader(bookId, readerId);
    }

}

