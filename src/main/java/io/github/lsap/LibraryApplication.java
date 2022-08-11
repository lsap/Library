package io.github.lsap;

import io.github.lsap.domain.model.OrderItem;

import java.util.ArrayList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

record LibraryApplication() {

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
                [7] Show all user's books
                [8] Show current reader of a book with id
               
               Type "exit" to stop the program!
               """;
    }

    static String newReader() {
        return "Please enter new reader's name!";
    }

    static String newBook() {
        return "Please enter new book title and book's author separated by /";
    }

    public static void main(String[] args) {
        System.out.println(header());
        System.out.println(disclaimer());
        var books = new ArrayList<Map<String, String>>();
        var readers = new ArrayList<Map<String, String>>();
        var readerId = 0;
        var bookId = 0;
        try (var scanner = new Scanner(System.in)) {
            var input = "";
            while (!"exit".equals(input)) {
                input = scanner.nextLine();
                switch (input) {
                    case "1"    -> System.out.println(books);
                    case "2"    -> System.out.println(readers);
                    case "3"    -> {
                        System.out.println(newReader());
                        input = scanner.nextLine();
                        readers.add(Map.of("id", readerId++ + "", "name", input));
                    }
                    case "4"    -> {
                        System.out.println(newBook());
                        input = scanner.nextLine();

                        books.add(Map.of(
                                "id", bookId++ + "", "title", input.split("/")[0]));
                    }
                    case "5" -> System.out.println("");
                    case "exit" -> System.out.println("Bye!");
                    default     -> {}
                }
                System.out.println(disclaimer());
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
