package by.ecp.db;

import by.ecp.common.BaseDaoImpl;
import by.ecp.entity.Country;
import by.ecp.entity.QCountry;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vinty on 28.05.2017.
 */
@Repository
public class CountryDaoImpl extends BaseDaoImpl<Country> implements CountryDao {

    @Override
    public List<Country> ListAll() {
        Session session = getSessionFactory().getCurrentSession();
        QCountry country = new QCountry("myCountry");
        JPAQuery<Country> query = new JPAQuery<>(session);
        query.select(country).from(country);
        return query.fetchResults().getResults();
    }
}

