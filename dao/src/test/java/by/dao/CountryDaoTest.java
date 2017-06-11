package by.dao;

import by.ecp.db.CountryDao;
import by.ecp.entity.Company;
import by.ecp.entity.Country;
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
public class CountryDaoTest {
    private static SessionFactory SESSION_FACTORY;

    @Test
    public void testGetCountry() {
        CountryDao countryDao = new CountryDao();
        Country country2 = countryDao.findOne(1L);
        assertThat(country2, notNullValue());
    }
}
