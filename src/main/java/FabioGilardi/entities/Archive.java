package FabioGilardi.entities;

import jakarta.persistence.*;

@Entity
@Table
public abstract class Archive {
    //    ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected int isbn;
    protected String title;
    @Column(name = "pages_number")
    protected int pagesNumber;
    @Column(name = "publication_date")
    protected int publicationDate;

    //    CONSTRUCTORS
    public Archive(String title, int pagesNumber, int publicationDate) {
        this.title = title;
        this.pagesNumber = pagesNumber;
        this.publicationDate = publicationDate;
    }

    public Archive() {

    }

    //    GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(int publicationDate) {
        this.publicationDate = publicationDate;
    }

    //    TO STRING
    @Override
    public String toString() {
        return "Archive{" +
                "id=" + id +
                ", isbn=" + isbn +
                ", title='" + title + '\'' +
                ", pagesNumber=" + pagesNumber +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
