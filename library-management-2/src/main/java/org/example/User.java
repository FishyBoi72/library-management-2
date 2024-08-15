package org.example;

import java.util.ArrayList;
import java.util.List;

public class User { // Defines a public class named 'User'.
    private String name; // Declares a private variable 'name' of type String to store the user's name.
    private String libraryCardNumber; // Declares a private variable 'libraryCardNumber' of type String to store the user's library card number.
    private List<Book> booksOnLoan; // Declares a private variable 'booksOnLoan' which is a list of 'Book' objects representing books currently on loan to the user.

    public User(String name, String libraryCardNumber) { // Constructor for the 'User' class, taking 'name' and 'libraryCardNumber' as parameters.
        this.name = name; // Assigns the value of the 'name' parameter to the 'name' instance variable.
        this.libraryCardNumber = libraryCardNumber; // Assigns the value of the 'libraryCardNumber' parameter to the 'libraryCardNumber' instance variable.
        this.booksOnLoan = new ArrayList<>(); // Initializes 'booksOnLoan' as a new, empty ArrayList of 'Book' objects.
    }

    public String getName() { // Getter method to retrieve the value of the 'name' instance variable.
        return name; // Returns the value of 'name'.
    }

    public String getLibraryCardNumber() { // Getter method to retrieve the value of the 'libraryCardNumber' instance variable.
        return libraryCardNumber; // Returns the value of 'libraryCardNumber'.
    }

    public List<Book> getBooksOnLoan() { // Getter method to retrieve the list of books currently on loan.
        return booksOnLoan; // Returns the 'booksOnLoan' list.
    }

    public void loanBook(Book book) { // Method to add a book to the user's list of books on loan.
        booksOnLoan.add(book); // Adds the given 'book' to the 'booksOnLoan' list.
    }

    public void returnBook(Book book) { // Method to remove a book from the user's list of books on loan.
        booksOnLoan.remove(book); // Removes the given 'book' from the 'booksOnLoan' list.
    }
}
