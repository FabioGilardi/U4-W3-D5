package FabioGilardi.dao;

import FabioGilardi.entities.User;
import FabioGilardi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UserDAO {
    //    ATTRIBUTES
    private final EntityManager em;

    //    CONSTRUCTOR
    public UserDAO(EntityManager em) {
        this.em = em;
    }

    //    DB METHODS
    public void saveOnDB(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
        System.out.println("The user " + user.getName() + " has been saved correctly");
    }

    public User findById(long id) {
        User userFound = em.find(User.class, id);
        if (userFound == null) throw new NotFoundException(id);
        return userFound;
    }

    public void deletFromDB(long id) {
        User userFound = this.findById(id);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(userFound);
        transaction.commit();
        System.out.println("The user " + userFound.getName() + " has been deleted correctly");
    }
}
