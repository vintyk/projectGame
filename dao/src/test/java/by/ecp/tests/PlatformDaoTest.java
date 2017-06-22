package by.ecp.tests;

import by.ecp.common.BaseDao;
import by.ecp.db.PlatformDaoImpl;
import by.ecp.entity.Platform;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by User on 16.06.2017.
 */
public class PlatformDaoTest extends BaseDaoTest<Platform> {
    @Autowired
    private BaseDao<Platform> dao = new PlatformDaoImpl();

    @Override
    protected BaseDao<Platform> getDao() {
        return dao;
    }

    @Override
    protected Platform getModel() {
        return new Platform();
    }
}
