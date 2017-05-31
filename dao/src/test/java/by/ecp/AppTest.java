package by.ecp;

import by.ecp.db.CountryDao;
import by.ecp.db.ToolsDataBase;
import by.ecp.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.*;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testSaveCountry() {
        Session session = SESSION_FACTORY.openSession();
        Country country = new Country();
        country.setName("Test");
        Long id = (Long) session.save(country);
        Country saved = session.find(Country.class, id);
        Assert.assertEquals(saved.getName(), "Test");
        session.close();
    }

    @Test
    public void testDeleteCountry() {
        Session session = SESSION_FACTORY.openSession();
        Country country = new Country();
        country.setName("Test2");
        Long id = (Long) session.save(country);
        ToolsDataBase.getInstance().delStringFromDbById(Country.class, new Long(id));
        session.get(Country.class, id);
    }

    @Test
    public void testListCountry() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        Country country = new Country();
        country.setName("USA");
        session.saveOrUpdate(country);
        Country country2 = new Country();
        country2.setName("Франция");
        session.saveOrUpdate(country);
        transaction.commit();
        List<Country> listCountry = CountryDao.getInstance().getCountryList();
        System.out.println(listCountry.size());

    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
