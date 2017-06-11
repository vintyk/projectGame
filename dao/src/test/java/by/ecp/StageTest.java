package by.ecp;

import by.ecp.entity.Company;
import by.ecp.entity.QCompany;
import by.ecp.entity.QStage;
import by.ecp.entity.Stage;
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
public class StageTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testListStageFromDaoQueryDSL() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Stage stage = new Stage();
        stage.setName("Ранний доступ");
        session.save(stage);

        QStage stage1 = new QStage("myStage");
        JPAQuery<Stage> query = new JPAQuery<>(session);
        query.select(stage1).from(stage1);
        System.out.println(query.fetchResults().getResults());
        assertThat(stage1, notNullValue());
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
