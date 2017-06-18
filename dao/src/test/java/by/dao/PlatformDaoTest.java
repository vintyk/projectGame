package by.dao;

import by.ecp.common.BaseDao;
import by.ecp.db.CompanyDao;
import by.ecp.db.PlatformDao;
import by.ecp.entity.Company;
import by.ecp.entity.Platform;
import org.hibernate.SessionFactory;

/**
 * Created by User on 16.06.2017.
 */
public class PlatformDaoTest extends BaseDaoTest<Platform> {

    private BaseDao<Platform> dao = new PlatformDao();

    @Override
    protected BaseDao<Platform> getDao() {
        return dao;
    }

    @Override
    protected Platform getModel() {
        return new Platform();
    }
}
