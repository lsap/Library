package io.github.lsap;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

class LibraryApplication {

    static String header() {
        """
                Welcome to the Library!
                        
                """
    }

    static String disclaimer() {
        return """
               
               Please select the action by typing an option number
               and pressing Enter key:
               
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

    public static void main(String[] args) {
        System.out.println(header());
        var books = List.of(
                Map.of("id", "0","title", "Anthem", "author", "Ayn Rand"),
                Map.of("id", "1", "title", "Atlas shrugged", "author", "Alisa Rosenbaum"),
                Map.of("id", "2", "title", "Spacepilot", "author", "Stanislav Lem")
        );
        var readers = List.of(
                Map.of("id", "0", "name", "John"),
                Map.of("id", "1", "name", "Jane"),
                Map.of("id", "2", "name", "Ijon"));
        try (var scanner = new Scanner(System.in)) {
            var input = "";
            while (!"exit".equals(input)) {
                System.out.println(disclaimer());
                input = scanner.nextLine();
                switch (input) {
                    case "1"    -> System.out.println(books);
                    case "2"    -> System.out.println(readers);
                    case "exit" -> System.out.println("Bye!");
                    default     -> {}
                }
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
