package by.ecp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 08.06.2017.
 */
public class PaymentModelTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

//    @Test
//    public void testListPaymentModel() {
//        Session session = SESSION_FACTORY.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        PaymentModel paymentModel = new PaymentModel();
//        paymentModel.setName("разовая покупка");
//        session.save(paymentModel);
//
//        PaymentModel paymentModel2 = new PaymentModel();
//        paymentModel2.setName("подписка");
//        session.save(paymentModel2);
//
//        List<PaymentModel> paymentModelsList = PaymentModelDaoImpl.getInstance().findAll(session);
//        assertThat(paymentModelsList, hasSize(2));
//        List<String> namesInBD = paymentModelsList
//                .stream()
//                .map(PaymentModel::getName)
//                .collect(toList());
//        assertThat(namesInBD, containsInAnyOrder("разовая покупка", "подписка"));
//        transaction.commit();
//        session.close();
//    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
