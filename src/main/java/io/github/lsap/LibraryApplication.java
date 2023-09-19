package io.github.lsap;

import io.github.lsap.exception.NoEntityWithSuchIdException;
import io.github.lsap.persistence.Book;
import io.github.lsap.persistence.Reader;
import io.github.lsap.repository.Storage;
import io.github.lsap.service.LibraryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LibraryApplication {

    private static final Scanner scanner = new Scanner(System.in);
    private static final LibraryService libraryService = new LibraryService();

    public static void main(String[] args) {
        System.out.println(header());
        System.out.println(disclaimer());
        var input = "";
        while (!"exit".equals(input)) {
            input = scanner.nextLine();
            switch (input) {
                case "1"    -> libraryService.showAllBooks();
                case "2"    -> libraryService.showAllReaders();
                case "3"    -> libraryService.addNewReader();
                case "4"    -> libraryService.addNewBook();
                case "5"    -> libraryService.lendBookToReader();
                case "6"    -> libraryService.returnBook();
                case "7"    -> libraryService.showAllReaderBooks();
                case "8"    -> libraryService.showReaderOfBook();
                case "exit" -> { System.out.println("Bye!"); System.exit(0); }
                default     -> {}
            }
            System.out.println(disclaimer());
        }

    }

    static String header() {
        return """
               Welcome to the Library!
               """;
    }

    static String disclaimer() {
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

