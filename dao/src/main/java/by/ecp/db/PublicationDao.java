package by.ecp.db;

import by.ecp.entity.Country;
import by.ecp.entity.Publication;
import by.ecp.entity.QCountry;
import by.ecp.entity.QPublication;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by User on 09.06.2017.
 */
public class PublicationDao {
    private static final Object LOCK = new Object();
    private static PublicationDao INSTANCE = null;

    public static PublicationDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new PublicationDao();
                }
            }
        }
        return INSTANCE;
    }

    public List<Publication> findAll(Session session) {
        QPublication publication = new QPublication("myPublic");
        JPAQuery<Publication> query = new JPAQuery<>(session);
        query.select(publication).from(publication);
        return query.fetchResults().getResults();
    }
}
