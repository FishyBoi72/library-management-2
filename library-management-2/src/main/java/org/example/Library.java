package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Library {
// Defines the Library class, which will manage a collection of books.

    private List<Book> books;
    // Declares a private field 'books' that will store a list of Book objects.

    public Library() {
        books = new ArrayList<>();
    }
    // Constructor for the Library class. Initializes the 'books' list as an empty ArrayList.

    public void addBook(Book book) {
        books.add(book);
    }
    // Adds a new book to the 'books' list.

    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }
    // Removes a book from the 'books' list based on its title. It performs a case-insensitive comparison.

    public List<Book> findBooksByYear(int year) {
        return books.stream()
                .filter(book -> book.getPublicationYear() == year)
                .collect(Collectors.toList());
    }
    // Finds and returns a list of books published in a specific year.

    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }
    // Finds and returns a list of books written by a specific author (case-insensitive).

    public Optional<Book> findBookWithMostPages() {
        return books.stream()
                .max((b1, b2) -> Integer.compare(b1.getPages(), b2.getPages()));
    }
    // Finds and returns the book with the most pages, wrapped in an Optional. If no books exist, the Optional will be empty.

    public List<Book> findBooksWithMoreThanNPages(int n) {
        return books.stream()
                .filter(book -> book.getPages() > n)
                .collect(Collectors.toList());
    }
    // Finds and returns a list of books that have more than 'n' pages.

    public List<String> getAllBookTitlesSorted() {
        return books.stream()
                .map(Book::getTitle)
                .sorted()
                .collect(Collectors.toList());
    }
    // Retrieves and returns a list of all book titles, sorted alphabetically.

    public List<Book> findBooksByCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }
    // Finds and returns a list of books that belong to a specific category (case-insensitive).

    public boolean loanBook(String title) {
        Optional<Book> bookOptional = books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .filter(book -> !book.isOnLoan())
                .findFirst();
        // Finds the first book with the given title that is not currently on loan.

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setOnLoan(true);
            return true;
        }
        // If such a book is found, it is marked as on loan and the method returns true.

        return false;
    }
    // If no such book is found, the method returns false.

    public boolean returnBook(String title) {
        Optional<Book> bookOptional = books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .filter(Book::isOnLoan)
                .findFirst();
        // Finds the first book with the given title that is currently on loan.

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setOnLoan(false);
            return true;
        }
        // If such a book is found, it is marked as returned (not on loan anymore) and the method returns true.

        return false;
    }
    // If no such book is found, the method returns false.

    public double calculateLateFees(String title) {
        Optional<Book> bookOptional = books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .filter(Book::isOnLoan)
                .findFirst();
        // Finds the first book with the given title that is currently on loan.

        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            long daysOnLoan = ChronoUnit.DAYS.between(book.getLoanDate(), LocalDate.now());
            // Calculates the number of days the book has been on loan.

            if (daysOnLoan > 14) {
                return (daysOnLoan - 14) * 0.50;
            }
            // If the book has been on loan for more than 14 days, calculates the late fee at $0.50 per day overdue.
        }

        return 0.0;
    }
    // If the book is not on loan or no late fees apply, returns 0.0.
}
