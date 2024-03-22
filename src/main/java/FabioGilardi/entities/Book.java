package FabioGilardi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "archive")
public class Book extends Archive {
    //    ATTRIBUTES
    private String author;
    private String genre;

    //    CONSTRUCTORS
    public Book(int isbn, String title, int pagesNumber, int publicationDate, String author, String genre) {
        super(isbn, title, pagesNumber, publicationDate);
        this.author = author;
        this.genre = genre;
    }

    public Book() {

    }

    //    GETTERS AND SETTERS
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //    TO STRING
    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", id=" + id +
                ", isbn=" + isbn +
                ", title='" + title + '\'' +
                ", pagesNumber=" + pagesNumber +
                ", publicationDate=" + publicationDate +
                ", loan=" + loan +
                '}';
    }
}
