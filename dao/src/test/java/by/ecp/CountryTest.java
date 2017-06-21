package by.ecp;

import by.ecp.common.BaseDaoImpl;
import by.ecp.db.CountryDao;
import by.ecp.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 05.06.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:application_content.xml"})
@Transactional
public class CountryTest extends BaseDaoImpl<Country> implements CountryDao{

    @Autowired
    private CountryDao countryDao;

    @BeforeClass
    public static void init(){}

    @Test
    public void testListCountryFromDaoQueryDSL() {
        Session session = getSessionFactory().getCurrentSession();
        Country country = new Country();
        country.setName("Russia");
        session.save(country);

        Session session2 = getSessionFactory().openSession();
        Country country2 = new Country();
        country2.setName("Belarus");
        session2.save(country2);
        System.out.println(session.getStatistics());
        System.out.println(session2.getStatistics());
    }
        @AfterClass
        public static void finish(){}
}
