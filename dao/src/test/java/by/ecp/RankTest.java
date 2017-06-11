package by.ecp;

import by.ecp.entity.Country;
import by.ecp.entity.QCountry;
import by.ecp.entity.QRank;
import by.ecp.entity.Rank;
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
public class RankTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testListRankFromDaoQueryDSL() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Rank rank = new Rank();
        rank.setValue(5);
        session.save(rank);

        QRank rank1 = new QRank("myRank");
        JPAQuery<Rank> query = new JPAQuery<>(session);
        query.select(rank1).from(rank1);
        System.out.println(query.fetchResults().getResults());
        assertThat(rank1, notNullValue());
        transaction.commit();
        session.close();
    }
    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
