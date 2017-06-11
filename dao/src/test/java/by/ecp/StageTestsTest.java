package by.ecp;

import by.ecp.entity.QStage;
import by.ecp.entity.QStageTests;
import by.ecp.entity.Stage;
import by.ecp.entity.StageTests;
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
public class StageTestsTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testListStageTestsFromDaoQueryDSL() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        StageTests stageTests = new StageTests();
        stageTests.setName("ОБТ");
        session.save(stageTests);

        QStageTests stageTests1 = new QStageTests("myStageTests");
        JPAQuery<StageTests> query = new JPAQuery<>(session);
        query.select(stageTests1).from(stageTests1);
        System.out.println(query.fetchResults().getResults());
        assertThat(stageTests1, notNullValue());
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
