package FabioGilardi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D5");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        System.out.println("Hello World!");

        em.close();
        emf.close();
    }
}
