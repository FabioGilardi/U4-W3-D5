package FabioGilardi;

import FabioGilardi.dao.ArchiveDAO;
import FabioGilardi.dao.LoanDAO;
import FabioGilardi.dao.UserDAO;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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
//            if (random.nextInt(1, 3) % 2 == 0) {
//                archiveDAO.saveOnDB(new Book(faker.book().hashCode(), faker.book().title(), random.nextInt(50, 501), random.nextInt(1968, 2024)
//                        , faker.book().author(), faker.book().genre()));
//            } else {
//                List<Periodicity> periodicityList = new ArrayList<>();
//                periodicityList.add(Periodicity.WEEKLY);
//                periodicityList.add(Periodicity.MONTHLY);
//                periodicityList.add(Periodicity.SEMESTRAL);
//                int randomPeriodicity = random.nextInt(0, 3);
//                archiveDAO.saveOnDB(new Magazine(faker.book().hashCode(), faker.book().title(), random.nextInt(50, 501), random.nextInt(1968, 2024), periodicityList.get(randomPeriodicity)));
//            }
//        }
//
//        for (int i = 0; i < 20; i++) {
//            loanDAO.saveOnDB(new Loan(LocalDate.now(), LocalDate.of(2024,
//                    random.nextInt(3, 5),
//                    random.nextInt(1, 29)), archiveDAO.findById(i + 1), userDAO.findById(random.nextInt(2, 21))));
//        }


        em.close();
        emf.close();
    }
}
