package by.ecp;

import by.ecp.entity.Company;
import by.ecp.entity.Vacancy;
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
public class CompanyTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void saveVacancy() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Company company = new Company();
        company.setNameCompany("Wargaming");
        session.save(company);
        Company company2 = session.get(Company.class, 1L);

        Vacancy vacancy = new Vacancy();
        vacancy.setNameVacancy("Financial Controller");
        vacancy.setCompany(company2);
        session.saveOrUpdate(vacancy);

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
