package by.ecp;

import by.ecp.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by User on 05.06.2017.
 */
public class VacancyTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testSaveVacancy() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Company company = new Company();
        company.setNameCompany("Mamba");
        session.save(company);
        Company company2 = session.get(Company.class, 1L);

        Vacancy vacancy = new Vacancy();
        vacancy.setNameVacancy("Director");
        vacancy.setCompany(company2);
        session.save(vacancy);
        System.out.println("------------------------------------------------");
        System.out.println(company2);
        System.out.println("------------------------------------------------");
        System.out.println(vacancy);
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
