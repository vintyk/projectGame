package by.dao;

import by.ecp.common.BaseDaoImpl;
import by.ecp.db.PaymentModelDaoImpl;
import by.ecp.entity.PaymentModel;

/**
 * Created by User on 16.06.2017.
 */
public class PaymentModelDaoTest extends BaseDaoTest<PaymentModel> {

    private BaseDaoImpl<PaymentModel> dao = new PaymentModelDaoImpl();

    @Override
    protected BaseDaoImpl<PaymentModel> getDao() {
        return dao;
    }

    @Override
    protected PaymentModel getModel() {
        return new PaymentModel();
    }

}
