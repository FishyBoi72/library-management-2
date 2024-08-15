package org.example;

import java.time.LocalDate;

public class Main {
    // Declares the Main class, which is the entry point of the application.

    public static void main(String[] args) {
        // The main method where the program execution begins.

        Library library = new Library();
        // Creates a new instance of the Library class to manage books.

        User user1 = new User("Alice", "12345");
        // Creates a new User object with the name "Alice" and ID "12345".

        User user2 = new User("Bob", "67890");
        // Creates a new User object with the name "Bob" and ID "67890".

        library.addBook(new Book("Book1", "Author1", 2000, 300, "Fiction"));
        // Adds a new Book object to the library with the title "Book1", author "Author1",
        // published in the year 2000, with 300 pages, and of genre "Fiction".

        library.addBook(new Book("Book2", "Author2", 2005, 150, "Science"));
        // Adds another Book object to the library with the title "Book2", author "Author2",
        // published in the year 2005, with 150 pages, and of genre "Science".

        library.addBook(new Book("Book3", "Author1", 2010, 450, "History"));
        // Adds another Book object to the library with the title "Book3", author "Author1",
        // published in the year 2010, with 450 pages, and of genre "History".

        library.loanBook("Book1");
        // Loans the book with the title "Book1" from the library.

        Book loanedBook = library.findBooksByYear(2000).get(0);
        // Finds all books published in the year 2000, retrieves the first book from the list,
        // and assigns it to the variable `loanedBook`.

        user1.loanBook(loanedBook);
        // User "Alice" loans the book `loanedBook`.

        loanedBook.setLoanDate(LocalDate.now().minusDays(20));
        // Sets the loan date of the book to 20 days ago from the current date.

        System.out.println("All book titles sorted:");
        // Prints a message indicating that the program will list all book titles in sorted order.

        library.getAllBookTitlesSorted().forEach(System.out::println);
        // Retrieves all book titles from the library, sorts them, and prints each title.

        System.out.println("Books by Author1:");
        // Prints a message indicating that the program will list all books by "Author1".

        library.findBooksByAuthor("Author1").forEach(book -> System.out.println(book.getTitle()));
        // Finds all books by "Author1" in the library and prints the title of each book.

        System.out.println("Late fees for Book1: " + library.calculateLateFees("Book1"));
        // Calculates the late fees for the book with the title "Book1" and prints the result.

        library.returnBook("Book1");
        // Returns the book "Book1" to the library, making it available again.

        user1.returnBook(loanedBook);
        // User "Alice" returns the `loanedBook` that was borrowed.
    }
}
