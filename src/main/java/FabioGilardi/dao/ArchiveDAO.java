package FabioGilardi.dao;

import FabioGilardi.entities.Archive;
import FabioGilardi.entities.Book;
import FabioGilardi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ArchiveDAO {
    //    ATTRIBUTES
    private final EntityManager em;

    //    CONSTRUCTOR
    public ArchiveDAO(EntityManager em) {
        this.em = em;
    }

    //    DB METHODS
    public void saveOnDB(Archive archive) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(archive);
        transaction.commit();
        System.out.println("The archive " + archive.getIsbn() + " has been saved correctly");
    }

    public Archive findById(long id) {
        Archive archiveFound = em.find(Archive.class, id);
        if (archiveFound == null) throw new NotFoundException(id);
        return archiveFound;
    }

    public void deletFromDB(long id) {
        Archive archiveFound = this.findById(id);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(archiveFound);
        transaction.commit();
        System.out.println("The archive " + archiveFound.getIsbn() + " has been deleted correctly");
    }

    //    RICERCA DI UN ELEMENTO CON ISBN
    public Archive findByIsbn(int isbn) {
        TypedQuery<Archive> query = em.createQuery("SELECT a FROM Archive a WHERE a.isbn = :isbn", Archive.class);
        query.setParameter("isbn", isbn);
        return query.getSingleResult();
    }

    //    ELIMINAZIONE DI UN ELEMENTO CON ISBN
    public void deleteByIsbn(int isbn) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("DELETE FROM Archive a WHERE a.isbn = :isbn");
        query.setParameter("isbn", isbn);
        query.executeUpdate();
        transaction.commit();
        System.out.println("The element " + isbn + " has been deleted correctly");
    }

    //    RICERCA PER ANNO DI PUBBLICAZIONE
    public List<Archive> findByAge(int age) {
        TypedQuery<Archive> query = em.createQuery("SELECT a FROM Archive a WHERE a.publicationDate = :age", Archive.class);
        query.setParameter("age", age);
        return query.getResultList();
    }

    //    RICERCA PER AUTORE
    public List<Book> findByAuthor(String author) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Archive b WHERE LOWER(b.author) = LOWER(:author)", Book.class);
        query.setParameter("author", author);
        return query.getResultList();
    }

    //    RICERCA PER TITOLO
    public List<Archive> findByTitle(String title) {
        TypedQuery<Archive> query = em.createQuery("SELECT a FROM Archive a WHERE LOWER(a.title) LIKE LOWER(:title)", Archive.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }

}
