package FabioGilardi.dao;

import FabioGilardi.entities.Archive;
import FabioGilardi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

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
    

}
