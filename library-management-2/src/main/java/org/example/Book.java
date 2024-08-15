package org.example;

import java.time.LocalDate;

// Defines a public class named Book within the package org.example.
public class Book {
    // Declares private instance variables to hold the book's title, author, publication year, page count, category, 
    // whether it is on loan, and the date it was loaned.
    private String title;
    private String author;
    private int publicationYear;
    private int pages;
    private String category;
    private boolean isOnLoan;
    private LocalDate loanDate;

    // Constructor for the Book class, which initializes a new Book object with the provided title, author,
    // publication year, pages, and category. The isOnLoan is set to false, and loanDate is initialized to null.
    public Book(String title, String author, int publicationYear, int pages, String category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.category = category;
        this.isOnLoan = false; // Initially, the book is not on loan.
        this.loanDate = null;  // Initially, there is no loan date.
    }

    // Getter method for the title field.
    public String getTitle() {
        return title;
    }

    // Getter method for the author field.
    public String getAuthor() {
        return author;
    }

    // Getter method for the publicationYear field.
    public int getPublicationYear() {
        return publicationYear;
    }

    // Getter method for the pages field.
    public int getPages() {
        return pages;
    }

    // Getter method for the category field.
    public String getCategory() {
        return category;
    }

    // Getter method for the isOnLoan field. Returns true if the book is currently on loan.
    public boolean isOnLoan() {
        return isOnLoan;
    }

    // Getter method for the loanDate field. Returns the date the book was loaned.
    public LocalDate getLoanDate() {
        return loanDate;
    }

    // Setter method for the isOnLoan field. When a book is set as on loan, the loanDate is set to the current date.
    // If the book is not on loan, the loanDate is reset to null.
    public void setOnLoan(boolean onLoan) {
        isOnLoan = onLoan; 
        this.loanDate = onLoan ? LocalDate.now() : null; // Conditional assignment based on whether the book is on loan.
    }

    // Setter method for the loanDate field. Allows manual setting of the loanDate.
    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }
}
