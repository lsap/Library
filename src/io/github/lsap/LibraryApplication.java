package io.github.lsap;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Library {

    static String disclaimer() {
        return """
               
               Please select the action by typing an option number
               and pressing Enter key:
               
                [1] Show all books in the library
                [2] Show all readers in the library
               
               Type "exit" to stop the program!
               """;
    }

    public static void main(String[] args) {
        System.out.println("""
                Welcome to the Library!
                        
                """);
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
                    default     -> System.out.println(disclaimer());
                }
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
