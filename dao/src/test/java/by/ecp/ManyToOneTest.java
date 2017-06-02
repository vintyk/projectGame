package by.ecp;

import by.ecp.db.CountryDao;

import by.ecp.entity.Country;
import by.ecp.entity.Gender;
import by.ecp.entity.Privilege;
import by.ecp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.*;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class ManyToOneTest {

    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testGetPrivilege() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Privilege privilege = new Privilege();
        privilege.setName("Admin");
        session.save(privilege);
        Privilege privilege2 = session.get(Privilege.class, 1L);
        System.out.println("------------------------------------------------");
        System.out.println(privilege2);
        transaction.commit();
        session.close();
    }



    @Test
    public void testSaveUser() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Privilege privilege = new Privilege();
        privilege.setName("Admin");
        session.save(privilege);
        Privilege privilege2 = session.get(Privilege.class, 1L);

        User user = new User();
        user.setNameUser("Igor");
        user.setPrivilege(privilege2);
        user.setFamilyUser("Sukach");
        user.setEMailUser("ffff@hhhh.com");
        user.setGender(Gender.MALE);
        user.setPasswordUser("12345");
        session.save(user);

        System.out.println("------------------------------------------------");
        System.out.println(privilege2);
        System.out.println("------------------------------------------------");
        System.out.println(user);

        transaction.commit();
        session.close();
    }


    @Test
    public void testListCountry() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        Country country = new Country();
        country.setName("USA");
        session.save(country);
        transaction.commit();
        List<Country> listCountry = CountryDao.getInstance().getCountryList();
        listCountry.forEach(System.out::println);
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
