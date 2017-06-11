package by.ecp;

import by.ecp.db.CountryDao;
import by.ecp.entity.Country;
import by.ecp.entity.Privilege;
import by.ecp.entity.QCountry;
import by.ecp.entity.QPrivilege;
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
public class PrivilegeDao {
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

        QPrivilege privilege = new QPrivilege("myPrivilege");
        JPAQuery<Privilege> query = new JPAQuery<>(session);
        query.select(privilege).from(privilege);
        System.out.println(query.fetchResults().getResults());
        assertThat(privilege, notNullValue());
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
