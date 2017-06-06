package by.ecp;

import by.ecp.db.CountryDao;
import by.ecp.db.GenreDao;
import by.ecp.entity.Country;
import by.ecp.entity.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

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
        transaction.commit();
        List<Genre> listGenre = GenreDao.getInstance().getGenreList();
        listGenre.forEach(System.out::println);
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
