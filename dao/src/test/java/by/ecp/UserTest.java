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
public class UserTest {
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

        QUser user1 = new QUser("myUser");
        JPAQuery<User> query = new JPAQuery<>(session);
        query.select(user1).from(user1);
        System.out.println(query.fetchResults().getResults());
        assertThat(user1, notNullValue());
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
