package by.ecp;

import by.ecp.db.CountryDao;
import by.ecp.db.GenreDao;
import by.ecp.db.PublicationDao;
import by.ecp.entity.Country;
import by.ecp.entity.Genre;
import by.ecp.entity.Publication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
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
        genre2.setName("постапокалиптика");
        session.save(genre2);

        List<Genre> genreList = GenreDao.getInstance().getGenreList(session);
        genreList.forEach(System.out::println);
        transaction.commit();
        session.close();
    }

//        List<Genre> listGenre = GenreDao.getInstance().getGenreList();
//        assertThat(listGenre, hasSize(1));
//        listGenre.forEach(System.out::println);
//        transaction.commit();
//        session.close();
//    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
