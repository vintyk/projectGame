package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.Country;
import by.ecp.entity.QCountry;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Vinty on 28.05.2017.
 */
public class CountryDao extends BaseDao<Country> {
    public CountryDao() {
        super(Country.class);
    }

//    public List<Country> getCountryList(Session session) {
//        List<Country> resultSetCountry = session.createQuery("from Country", Country.class).getResultList();
//        return resultSetCountry;
//        }
//
        public List<Country> findAll(Session session) {
        QCountry country = new QCountry("myCountry");
        JPAQuery<Country> query = new JPAQuery<>(session);
        query.select(country).from(country);
        return query.fetchResults().getResults();
    }
}

