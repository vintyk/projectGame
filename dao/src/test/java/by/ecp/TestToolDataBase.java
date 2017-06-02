package by.ecp;

import by.ecp.entity.Gender;
import by.ecp.entity.Privilege;
import by.ecp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by User on 02.06.2017.
 */
public class TestToolDataBase {
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
        privilege1.setName("Admin");
        Privilege privilege2 = new Privilege();
        privilege2.setName("User");
        session.save(privilege1);
        session.save(privilege2);
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
