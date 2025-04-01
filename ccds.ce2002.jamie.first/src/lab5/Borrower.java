package lab5;

import java.util.ArrayList;
import java.util.List;

public class Borrower {
    private String name;
    private List<Book> borrowedBooks;

    // Constructor
    public Borrower(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Borrow a book
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println(name + " borrowed " + book.getTitle());
    }

    // Return a book
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        System.out.println(name + " returned " + book.getTitle());
    }

    public Book returnBookByString(String bookTitle) {
        if(borrowedBooks.stream().anyMatch(book->book.getTitle().equalsIgnoreCase(bookTitle)))
        {
            Book book_to_return = borrowedBooks.stream()
                    .filter(item -> item instanceof Book)
                    .map(item -> (Book) item)
                    .filter(item -> item.getTitle().equals(bookTitle))
                    .findFirst()
                    .orElse(null);
            borrowedBooks.remove(book_to_return);
            System.out.println(name + " returned " + book_to_return.getTitle());
            return book_to_return;

        }
        System.out.println("you do not have this book");
        return null;
        //
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean hasBook(String bookTitle)
    {
        return borrowedBooks.stream().anyMatch(book->book.getTitle().equalsIgnoreCase(bookTitle));
    }
}
