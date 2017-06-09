package by.ecp;

import by.ecp.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
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

        QVacancy vacancy1 = new QVacancy("myVacancy");
        JPAQuery<Vacancy> query = new JPAQuery<>(session);
        query.select(vacancy1).from(vacancy1);
        System.out.println(query.fetchResults().getResults());
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
