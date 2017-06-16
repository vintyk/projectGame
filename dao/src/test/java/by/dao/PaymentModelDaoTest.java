package by.dao;

import by.ecp.common.BaseDao;
import by.ecp.db.CountryDao;
import by.ecp.db.PaymentModelDao;
import by.ecp.entity.Country;
import by.ecp.entity.PaymentModel;
import org.hibernate.SessionFactory;

/**
 * Created by User on 16.06.2017.
 */
public class PaymentModelDaoTest extends BaseDaoTest<PaymentModel> {
    private static SessionFactory SESSION_FACTORY;

    private BaseDao<PaymentModel> dao = new PaymentModelDao();

    @Override
    protected BaseDao<PaymentModel> getDao() {
        return dao;
    }

    @Override
    protected PaymentModel getModel() {
        return new PaymentModel();
    }

}
