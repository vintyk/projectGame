package by.dao;

import by.ecp.common.BaseDaoImpl;
import by.ecp.db.PrivilegeDaoImpl;
import by.ecp.entity.Privilege;

/**
 * Created by User on 16.06.2017.
 */
public class PrivilegeDaoTest extends BaseDaoTest<Privilege> {

    private BaseDaoImpl<Privilege> dao = new PrivilegeDaoImpl();

    @Override
    protected BaseDaoImpl<Privilege> getDao() {
        return dao;
    }

    @Override
    protected Privilege getModel() {
        return new Privilege();
    }
}
