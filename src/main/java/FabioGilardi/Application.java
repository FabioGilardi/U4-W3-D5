package FabioGilardi;

import FabioGilardi.dao.ArchiveDAO;
import FabioGilardi.dao.LoanDAO;
import FabioGilardi.dao.UserDAO;
import FabioGilardi.entities.Archive;
import FabioGilardi.entities.Book;
import FabioGilardi.entities.Loan;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D5");

    public static void main(String[] args) {

        Faker faker = new Faker(Locale.ITALY);
        Random random = new Random();

        EntityManager em = emf.createEntityManager();
        ArchiveDAO archiveDAO = new ArchiveDAO(em);
        LoanDAO loanDAO = new LoanDAO(em);
        UserDAO userDAO = new UserDAO(em);

//        POPOLAMENTO RANDOMICO DEL DATABASE

//        for (int i = 0; i < 20; i++) {
//            userDAO.saveOnDB(new User(faker.name().firstName(), faker.name().lastName(), LocalDate.of(random.nextInt(1968, 2002),
//                    random.nextInt(1, 13),
//                    random.nextInt(1, 29))));
//        }
//
//        for (int i = 0; i < 20; i++) {
//            loanDAO.saveOnDB(new Loan(LocalDate.now(), LocalDate.now().plusDays(random.nextInt(20, 41)), userDAO.findById(random.nextInt(2, 21))));
//        }
//
//        for (int i = 0; i < 20; i++) {
//            if (random.nextInt(1, 3) % 2 == 0) {
//                archiveDAO.saveOnDB(new Book(random.nextInt(10000, 100000), faker.book().title(), random.nextInt(50, 501), random.nextInt(1968, 2024)
//                        , loanDAO.findById(i + 1), faker.book().author(), faker.book().genre()));
//            } else {
//                List<Periodicity> periodicityList = new ArrayList<>();
//                periodicityList.add(Periodicity.WEEKLY);
//                periodicityList.add(Periodicity.MONTHLY);
//                periodicityList.add(Periodicity.SEMESTRAL);
//                int randomPeriodicity = random.nextInt(0, 3);
//                archiveDAO.saveOnDB(new Magazine(random.nextInt(10000, 100000), faker.book().title(), random.nextInt(50, 501), random.nextInt(1968, 2024), loanDAO.findById(i + 1), periodicityList.get(randomPeriodicity)));
//            }
//        }

        //    RICERCA DI UN ELEMENTO CON ISBN (GESTIONE DELL'ERRORE TRAMITE EXCEPTION IN DAO)
        System.out.println(archiveDAO.findByIsbn(73993));

        //    ELIMINAZIONE DI UN ELEMENTO CON ISBN
        archiveDAO.deleteByIsbn(1);

        //    RICERCA PER ANNO DI PUBBLICAZIONE
        List<Archive> archivesByYear = archiveDAO.findByAge(2014);
        if (archivesByYear.isEmpty()) System.err.println("No element has been found in this year");
        else archivesByYear.forEach(System.out::println);

        //    RICERCA PER AUTORE
        List<Book> booksByAuthor = archiveDAO.findByAuthor("bobby");
        if (booksByAuthor.isEmpty()) System.err.println("No element has been found for this author");
        else booksByAuthor.forEach(System.out::println);

        //    RICERCA PER TITOLO
        List<Archive> archivesByTitle = archiveDAO.findByTitle("wild");
        if (archivesByTitle.isEmpty()) System.err.println("No element has been found with this title");
        else archivesByTitle.forEach(System.out::println);

        //    RICERCA UTENTE PER USER CARD
        List<Archive> archivesByUserCard = archiveDAO.findByUserCard(25);
        if (archivesByUserCard.isEmpty()) System.err.println("No element has been found for this user");
        else archivesByUserCard.forEach(System.out::println);

        //    RICERCA LIBRI OLTRE LA SCADENZA
        List<Loan> expiredLoans = archiveDAO.findExpiredLoans();
        if (expiredLoans.isEmpty()) System.err.println("All books have been returned in time");
        else expiredLoans.forEach(System.out::println);


        em.close();
        emf.close();

        System.out.println("Created By Fabio Gilardi " + LocalDate.now().getYear());
        
    }
}
