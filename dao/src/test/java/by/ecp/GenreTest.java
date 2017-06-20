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
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * Created by Vinty on 06.06.2017.
 */
public class GenreTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testListGenre() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Genre genre = new Genre();
        genre.setName("постапокалиптика");
        session.save(genre);
        Genre genre2 = new Genre();
        genre2.setName("постапокалиптика2");
        session.save(genre2);

        QGenre genre1 = new QGenre("myGenre");
        JPAQuery<Genre> query = new JPAQuery<>(session);
        query.select(genre1).from(genre1);
        System.out.println(query.fetchResults().getResults());
        assertThat(genre1, notNullValue());
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
