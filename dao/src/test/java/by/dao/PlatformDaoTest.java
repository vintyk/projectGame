package by.dao;

import by.ecp.common.BaseDaoImpl;
import by.ecp.db.PlatformDaoImpl;
import by.ecp.entity.Platform;

/**
 * Created by User on 16.06.2017.
 */
public class PlatformDaoTest extends BaseDaoTest<Platform> {

    private BaseDaoImpl<Platform> dao = new PlatformDaoImpl();

    @Override
    protected BaseDaoImpl<Platform> getDao() {
        return dao;
    }

    @Override
    protected Platform getModel() {
        return new Platform();
    }
}
