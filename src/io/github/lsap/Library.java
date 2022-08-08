package io.github.lsap;

public class Library {

    public static void main(String[] args) {
        assert null != Book.getInstance();
        System.out.println("""
        Welcome to the Library!
        
        Please select the action by typing an option number
        and pressing Enter key:
        
         [1] Show all books in the library
         [2] Show all readers in the library
         
        Type "exit" to stop the program and exit!
                """);
    }

}
