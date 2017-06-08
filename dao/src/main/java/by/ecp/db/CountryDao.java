package by.ecp.db;

import by.ecp.entity.Country;
import by.ecp.entity.QCountry;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Vinty on 28.05.2017.
 */
public class CountryDao {
    private static final Object LOCK = new Object();
    private static CountryDao INSTANCE = null;

    public static CountryDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new CountryDao();
                }
            }
        }
        return INSTANCE;
    }

    public List<Country> getCountryList() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<Country> resultSetCountry = session.createQuery("from Country", Country.class).getResultList();
        session.close();
        sessionFactory.close();
        return resultSetCountry;
        }

        public List<Country> findAll(Session session) {
        QCountry country = new QCountry("myCountry");
        JPAQuery<Country> query = new JPAQuery<>(session);
        query.select(country).from(country);
        return query.fetchResults().getResults();
    }
}

