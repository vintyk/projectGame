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

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

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
    public void testListCompanyFromDaoQueryDSL() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Company company = new Company();
        company.setNameCompany("Wargaming");
        session.save(company);

        QCompany company1 = new QCompany("myCompany");
        JPAQuery<Company> query = new JPAQuery<>(session);
        query.select(company1).from(company1);
        System.out.println(query.fetchResults().getResults());
        assertThat(company1, notNullValue());
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
