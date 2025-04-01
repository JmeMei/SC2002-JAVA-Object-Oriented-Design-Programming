package lab5;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Library<T> { //Java generics
    private List<T> items; //ArrayList
    private Set<String> genres; //HashSet
    private Map<String, List<Book>> authorMap; //HashMap
    private Map<String, Borrower> borrowers; //HashMap

    // Constructor
    public Library() {
        this.items = new ArrayList<>();
        this.genres = new HashSet<>();
        this.authorMap = new HashMap<>();
        this.borrowers = new HashMap<>();
    }

    // Add an item to the library, 
    public void addItem(T item) {
        items.add(item);
        if (item instanceof Book) { //this item is a book
            Book book = (Book) item;
            genres.add(book.getGenre()); //add the book genre to this.genre (HashSet)

            // Add to authorMap
            authorMap.computeIfAbsent(book.getAuthor(), k -> new ArrayList<>()).add(book);
        }
        System.out.println(item + " added to the library.");
    }

    // Remove an item from the library
    public void removeItem(T item) {
        if (items.remove(item)) {
            if (item instanceof Book) {
                Book book = (Book) item;
                authorMap.get(book.getAuthor()).remove(book);
            }
            System.out.println(item + " removed from the library.");
        } else {
            System.out.println(item + " not found in the library.");
        }
    }

    // Retrieve all items in the library
    public List<T> getAllItems() {
        return new ArrayList<>(items);
    }

    // Filter items based on a condition
    public List<T> filterItems(Predicate<T> condition) {
        return items.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    // Display all items
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the library.");
        } else {
            System.out.println("Items in the library:");
            items.forEach(System.out::println);
        }
    }

    // Display all genres
    public void displayGenres() {
        System.out.println("Available genres: " + genres);
    }

    // Display books by author
    public void displayBooksByAuthor(String author) {
        List<Book> books = authorMap.get(author);
        if (books == null || books.isEmpty()) {
            System.out.println("No books found by " + author);
        } else {
            System.out.println("Books by " + author + ":");
            books.forEach(System.out::println);
        }
    }

    public void addBorrower(String borrower)
    {
        borrowers.put(borrower, new Borrower(borrower));
    }

    public void removeBorrower(String borrower)
    {
        borrowers.remove(borrower);
    }


    public void borrowBook(String borrower, String BookTitle)
    {
        //check if book is in library
        Book book_to_borrow = items.stream()
                .filter(item -> item instanceof Book)
                .map(item -> (Book) item)
                .filter(item -> item.getTitle().equals(BookTitle))
                .findFirst()
                .orElse(null);

        if(book_to_borrow == null) {
            System.out.println("Book Doesnt Exist");
            return;
        }
        if(!borrowers.containsKey(borrower))
        {
            addBorrower(borrower);
        }
        borrowers.get(borrower).borrowBook(book_to_borrow);
        //if need to remove book, uncomment this
        //items.remove(book_to_borrow);
    }

    public void returnBook(String borrower, String book)
    {
        if(!borrowers.containsKey(borrower))
        {
            System.out.println("Borrower Does Not Exist");
            return;
        }

        if(!borrowers.get(borrower).hasBook(book))
        {
            System.out.println("Borrower Does Not Have Book");
            return;
        }

        borrowers.get(borrower).returnBookByString(book);
        //addItem((T) borrowers.get(borrower).returnBookByString(book));
    }

    public void listBorrowers()
    {
        if (borrowers.isEmpty()) {
            System.out.println("No borrowers found.");
            return;
        }

        borrowers.forEach((name, borrower) -> {
            // Get the list of borrowed books
            List<Book> borrowedBooks = borrower.getBorrowedBooks();
            if (borrowedBooks.isEmpty()) {
                // Display No Books if the list is empty
                System.out.println(name + " : No Books");
            } else {
                List<String> bookTitles = borrowedBooks.stream()
                        .map(Book::getTitle)
                        .collect(Collectors.toList());
                // Display the borrower's name and list of book titles
                System.out.println(name + " : " + bookTitles);
            }
        });
    }

    public void recommendBook(String genre)
    {
        List<Book> books = items.stream()
                .filter(item -> item instanceof Book)
                .map(item -> (Book) item)
                .filter(book-> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());

        if(books.isEmpty())
        {
            System.out.println("No Recommendations");
        }
        else {
            System.out.print("Recommendation: Try ");
            books.forEach(book -> System.out.println("'" + book.getTitle() + "' by " + book.getAuthor()));
        }
    }

    public void searchByKeyword(String keyword) {
        List<Book> books = items.stream()
                .filter(item -> item instanceof Book)
                .map(item -> (Book) item)
                .filter(book -> book.containsKeyword(keyword))
                .collect(Collectors.toList());

        books.forEach(System.out::println);
    }

    public void listBooksInAlphabetical()
    {
        List<Book> books = new ArrayList<>();

        // Filter and cast each item as Book if it is an instance of Book
        for (Object item : items) {
            if (item instanceof Book) {
                books.add((Book) item);
            }
        }

        Collections.sort(books);

        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }
}
