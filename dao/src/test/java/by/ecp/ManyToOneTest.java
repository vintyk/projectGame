package by.ecp;

import by.ecp.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.*;

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
    public void testSaveUser() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Privilege privilege = new Privilege();
        privilege.setNamePrivilege("Admin");
        session.save(privilege);
        Privilege privilege2 = session.get(Privilege.class, 1L);

        User user = new User();
        user.setNameUser("Vu");
        user.setPrivilege(privilege2);
        user.setFamilyUser("Lun");
        user.setEMailUser("sss@hhhh.com");
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

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
