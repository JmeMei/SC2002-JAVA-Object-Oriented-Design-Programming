package lab5;

public class Book implements Searchable, Comparable<Book> {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;

    // Constructor
    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    // Search by keyword
    @Override
    public boolean containsKeyword(String keyword) {
        return title.toLowerCase().contains(keyword.toLowerCase());
    }

    // toString method for displaying book details
    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " (" + genre + ", " + publicationYear + ")";
    }

    @Override
    public int compareTo(Book o) {
        return this.title.compareToIgnoreCase(o.getTitle());
    }
}
