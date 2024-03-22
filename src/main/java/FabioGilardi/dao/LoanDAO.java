package FabioGilardi.dao;

import FabioGilardi.entities.Loan;
import FabioGilardi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LoanDAO {
    //    ATTRIBUTES
    private final EntityManager em;

    //    CONSTRUCTOR
    public LoanDAO(EntityManager em) {
        this.em = em;
    }

    //    DB METHODS
    public void saveOnDB(Loan loan) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(loan);
        transaction.commit();
        System.out.println("The loan " + loan.getId() + " has been saved correctly");
    }

    public Loan findById(long id) {
        Loan loanFound = em.find(Loan.class, id);
        if (loanFound == null) throw new NotFoundException(id);
        return loanFound;
    }

    public void deletFromDB(long id) {
        Loan loanFound = this.findById(id);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(loanFound);
        transaction.commit();
        System.out.println("The loan " + loanFound.getId() + " has been deleted correctly");
    }
}
