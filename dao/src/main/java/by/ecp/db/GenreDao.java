package by.ecp.db;

import by.ecp.entity.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

/**
 * Created by Vinty on 06.06.2017.
 */
public class GenreDao {
    private static final Object LOCK = new Object();
    private static GenreDao INSTANCE = null;

    public static GenreDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new GenreDao();
                }
            }
        }
        return INSTANCE;
    }

    public List<Genre> getGenreList(Session session) {
        List<Genre> resultSetGenre = session.createQuery("from Genre ", Genre.class).getResultList();
        return resultSetGenre;
    }
}
