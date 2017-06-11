package by.ecp;

import by.ecp.db.CountryDao;
import by.ecp.entity.Company;
import by.ecp.entity.Country;
import by.ecp.entity.QCompany;
import by.ecp.entity.QCountry;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 05.06.2017.
 */
public class CountryTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testListCountryFromDaoQueryDSL() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        Country country = new Country();
        country.setName("Russia");
        session.save(country);
        Country country2 = new Country();
        country2.setName("Belarus");
        session.save(country2);

        QCountry country1 = new QCountry("myCountry");
        JPAQuery<Country> query = new JPAQuery<>(session);
        query.select(country1).from(country1);
        System.out.println(query.fetchResults().getResults());
        assertThat(country1, notNullValue());
        transaction.commit();
        session.close();
    }

//        List<Country> countryList = CountryDao.getInstance().findAll(session);
//        assertThat(countryList, hasSize(2));
//        List<String> namesInBD = countryList
//                .stream()
//                .map(Country::getName)
//                .collect(toList());
//        assertThat(namesInBD, containsInAnyOrder("Russia", "Belarus"));
//        transaction.commit();
//        session.close();
//    }

//    @Test
//    public void testFindAllFromEntity() {
//        Session session = SESSION_FACTORY.openSession();
//        Transaction transaction = session.beginTransaction();
//        Country country = new Country();
//        country.setName("USA");
//        session.save(country);
//        Country country2 = new Country();
//        country2.setName("GB");
//        session.save(country2);
//
//        QCountry country3 = new QCountry("myCountry");
//        JPAQuery<Country> query = new JPAQuery<>(session);
//        query.select(country3).from(country3);
//        System.out.println(query.fetchResults().getResults());
//        transaction.commit();
//        session.close();
//


        @AfterClass
        public static void finish() {
            SESSION_FACTORY.close();
        }
}
