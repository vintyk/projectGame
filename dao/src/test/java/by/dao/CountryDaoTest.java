package by.dao;

import by.ecp.common.BaseDao;
import by.ecp.db.CountryDao;
import by.ecp.entity.Company;
import by.ecp.entity.Country;
import by.ecp.entity.QCompany;
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
 * Created by Vinty on 10.06.2017.
 */
public class CountryDaoTest extends BaseDaoTest<Country> {
    private static SessionFactory SESSION_FACTORY;

    private BaseDao<Country> dao = new CountryDao();

    @Override
    protected BaseDao<Country> getDao() {
        return dao;
    }

    @Override
    protected Country getModel() {
        return new Country();
    }

}
//    @BeforeClass
//    public static void init() {
//        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
//    }

    //    @Test
//    public void testGetCountry() {
//        Session session = SESSION_FACTORY.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        Country country = new Country();
//        country.setName("США");
//        session.save(country);
//
//        CountryDao countryDao = new CountryDao();
//        Country country2 = countryDao.findOne(1L);
//        assertThat(country2, notNullValue());
//        transaction.commit();
//        session.close();
//    }
//    @AfterClass
//    public static void finish() {
//        SESSION_FACTORY.close();
//    }
