package by.ecp;

import by.ecp.db.GenreDao;
import by.ecp.entity.Genre;
import by.ecp.entity.PaymentModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * Created by User on 08.06.2017.
 */
public class PaymentModelTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testListPaymentModel() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setName("просто так, почти даром");
        session.save(paymentModel);
        transaction.commit();

        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
