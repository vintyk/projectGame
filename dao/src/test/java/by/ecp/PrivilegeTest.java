package by.ecp;

import by.ecp.db.CountryDao;
import by.ecp.entity.Country;
import by.ecp.entity.Privilege;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * Created by User on 05.06.2017.
 */
public class PrivilegeTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void TestSavePrivilege() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Privilege privilege1 = new Privilege();
        privilege1.setNamePrivilege("Admin");
        session.save(privilege1);
        Privilege privilege2 = new Privilege();
        privilege2.setNamePrivilege("User");
        session.save(privilege2);
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
