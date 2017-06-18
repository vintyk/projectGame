package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by User on 09.06.2017.
 */
public class PaymentModelDao extends BaseDao<PaymentModel>{
    public PaymentModelDao() {
        super(PaymentModel.class);
    }

    public List<PaymentModel> findAll(Session session) {
        QPaymentModel paymentModel = new QPaymentModel("myPayment");
        JPAQuery<PaymentModel> query = new JPAQuery<>(session);
        query.select(paymentModel).from(paymentModel);
        return query.fetchResults().getResults();
    }
}
