/* Problem 1: Library and Books (Aggregation)
Description: Create a Library class that contains multiple Book objects. Model the relationship such that a library can have many books, but a book can exist independently (outside of a specific library).
Tasks:
Define a Library class with an ArrayList of Book objects.
Define a Book class with attributes such as title and author.
Demonstrate the aggregation relationship by creating books and adding them to different libraries.
Goal: Understand aggregation by modeling a real-world relationship where the Library aggregates Book objects. */

import java.util.ArrayList;
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public void showBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}
class Library {
    private String libraryName;
    private ArrayList<Book> books;  

    public Library(String libraryName) {
        this.libraryName = libraryName;
        books = new ArrayList<>();
    }

    public void addBook(Book b) {
        books.add(b);
    }

    public void showLibraryBooks() {
        System.out.println("\nLibrary: " + libraryName);
        for (Book b : books) {
            b.showBook();
        }
    }
}

public class LibraryAndBooks {
    public static void main(String[] args) {
        Book b1 = new Book("Rich Dad Poor Dad", "Robert Kiyosaki");
        Book b2 = new Book("Wings of Fire", "A.P.J. Abdul Kalam");
        Book b3 = new Book("The Alchemist", "Paulo Coelho");
        Library cityLibrary = new Library("City Library");
        Library collegeLibrary = new Library("College Library");
        cityLibrary.addBook(b1);
        cityLibrary.addBook(b3);
        collegeLibrary.addBook(b2);
        collegeLibrary.addBook(b3);   
        cityLibrary.showLibraryBooks();
        collegeLibrary.showLibraryBooks();
    }
}
