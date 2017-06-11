package by.ecp;

import by.ecp.entity.Country;
import by.ecp.entity.Platform;
import by.ecp.entity.QCountry;
import by.ecp.entity.QPlatform;
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
 * Created by Vinty on 11.06.2017.
 */
public class PlatformTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testListPlatformFromDaoQueryDSL() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Platform platform = new Platform();
        platform.setName("X-Box");
        session.save(platform);

        QPlatform platform1 = new QPlatform("myPlatform");
        JPAQuery<Platform> query = new JPAQuery<>(session);
        query.select(platform1).from(platform1);
        System.out.println(query.fetchResults().getResults());
        assertThat(platform1, notNullValue());
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
