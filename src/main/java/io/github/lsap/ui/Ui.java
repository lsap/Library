package io.github.lsap.ui;

import io.github.lsap.exception.DaoLayerException;
import io.github.lsap.persistence.Book;
import io.github.lsap.service.LibraryService;

import java.util.List;
import java.util.Scanner;

public class Ui {
    private static final Scanner scanner = new Scanner(System.in);
    private final LibraryService libraryService;

    public Ui(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void render() {
        System.out.println(getHeader());               
        System.out.println(getDisclaimer());
        var input = "";
        while (!"exit".equals(input)) {
            input = scanner.nextLine();
            switch (input) {
                case "1"    -> showAllBooks();
                case "2"    -> showAllReaders();
                case "exit" -> { System.out.println("Bye!"); System.exit(0); }
                default     -> {}
            }
            System.out.println(getDisclaimer());
        }
    }

    private void showAllBooks() {
        try {
            libraryService.getAllBooks()
            .forEach(book -> {
                System.out.println(book);
            });
        } catch (DaoLayerException e) {
            System.err.println("Can't get books due to persistence layer exception. "
                + e.getLocalizedMessage());
        }
    }

    private void showAllReaders() {
        try {
            libraryService.getAllReaders()
            .forEach(reader -> {
                System.out.println(reader);
            });
        } catch (DaoLayerException e) {
            System.err.println("Can't get readers due to persistence layer exception. "
                + e.getLocalizedMessage());
        }
    }

    private String getHeader() {
        return """
               Welcome to the Library!
               """;
    }

    private String getDisclaimer() {
        return """
               
               Please select the action by typing an option number and pressing Enter key:
               
                [1] Show all books in the library
                [2] Show all readers in the library
                [3] Register new reader
                [4] Add new book
                [5] Lend a book to a reader
                [6] Return a book
                [7] Show all reader's books
                [8] Show current reader of a book with id
               
               Type "exit" to stop the program!
               """;
    }

}

