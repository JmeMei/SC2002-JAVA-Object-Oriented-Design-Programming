package lab5;

import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library<Book> library = new Library<>();

        Scanner sc = new Scanner(System.in);
        int choice;

        // Sample data for testing

        library.addItem(new Book("1984", "George Orwell", "Fiction", 1949));
        library.addItem(new Book("A Brief History of Time", "Stephen Hawking", "Science", 1988));
        library.addItem(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960));
        library.addItem(new Book("Sapiens", "Yuval Noah Harari", "History", 2011));



        do {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Display all books");
            System.out.println("4. Filter books by genre");
            System.out.println("5. Filter books by author");
            System.out.println("6. Get Recommendation by Genre");
            System.out.println("7. Sort Order By Title");
            System.out.println("8. Find By Keyword");
            System.out.println("8. Borrow Book");
            System.out.println("9. Return Book");
            System.out.println("10. List Borrowers");
            System.out.println("11. Quit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add a book
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Enter publication year: ");
                    int year = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    Book newBook = new Book(title, author, genre, year);
                    library.addItem(newBook);
                    break;

                case 2:
                    // Remove a book by title
                    System.out.print("Enter the title of the book to remove: ");
                    String titleToRemove = sc.nextLine();
                    List<Book> booksToRemove = library.filterItems(
                            b -> b.getTitle().equalsIgnoreCase(titleToRemove)
                    );

                    if (booksToRemove.isEmpty()) {
                        System.out.println("Book not found.");
                    } else {
                        library.removeItem(booksToRemove.get(0));
                    }
                    break;

                case 3:
                    // Display all books
                    library.displayItems();
                    break;

                case 4:
                    // Filter books by genre
                    System.out.print("Enter genre to filter by: ");
                    String genreFilter = sc.nextLine();
                    List<Book> booksByGenre = library.filterItems(
                            b -> b.getGenre().equalsIgnoreCase(genreFilter)
                    );
                    System.out.println("Books in the genre \"" + genreFilter + "\":");
                    booksByGenre.forEach(System.out::println);
                    break;

                case 5:
                    // Filter books by author
                    System.out.print("Enter author to filter by: ");
                    String authorFilter = sc.nextLine();
                    List<Book> booksByAuthor = library.filterItems(
                            b -> b.getAuthor().equalsIgnoreCase(authorFilter)
                    );
                    System.out.println("Books by \"" + authorFilter + "\":");
                    booksByAuthor.forEach(System.out::println);
                    break;
                case 6:
                    System.out.print("Category: ");
                    String getCategory = sc.nextLine();
                    library.recommendBook(getCategory);
                    break;
                case 7:
                    //sort by order of alphabetical
                    library.listBooksInAlphabetical();
                    break;
                case 8:
                    System.out.print("Keyword: ");
                    library.searchByKeyword(sc.nextLine());
                    //find by keyword
                    break;
                case 9:
                    //borrow book
                    System.out.print("Name: ");
                    String borrowername = sc.nextLine();
                    System.out.print("Book Title: ");
                    String borrowingBookTitle = sc.nextLine();
                    library.borrowBook(borrowername, borrowingBookTitle);

                    break;
                case 10:
                    System.out.print("Name: ");
                    String returnername = sc.nextLine();
                    System.out.print("Book Title: ");
                    String returningBookTitle = sc.nextLine();
                    library.returnBook(returnername, returningBookTitle);
                    break;
                case 11:
                    library.listBorrowers();
                    break;
                case 12:
                    // Quit
                    System.out.println("Exiting the Library System...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 12);

        sc.close();
    }
}

