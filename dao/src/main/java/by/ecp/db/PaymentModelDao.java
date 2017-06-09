package by.ecp.db;

import by.ecp.entity.PaymentModel;
import by.ecp.entity.Publication;
import by.ecp.entity.QPaymentModel;
import by.ecp.entity.QPublication;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by User on 09.06.2017.
 */
public class PaymentModelDao {
    private static final Object LOCK = new Object();
    private static PaymentModelDao INSTANCE = null;

    public static PaymentModelDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new PaymentModelDao();
                }
            }
        }
        return INSTANCE;
    }

    public List<PaymentModel> findAll(Session session) {
        QPaymentModel paymentModel = new QPaymentModel("myPayment");
        JPAQuery<PaymentModel> query = new JPAQuery<>(session);
        query.select(paymentModel).from(paymentModel);
        return query.fetchResults().getResults();
    }
}
