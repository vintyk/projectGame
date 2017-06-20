package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.PaymentModel;

import java.util.List;

/**
 * Created by User on 20.06.2017.
 */
public interface PaymentModelDao extends BaseDao<PaymentModel> {

    List<PaymentModel> ListAll();
}
