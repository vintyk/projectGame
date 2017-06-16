package by.dao;

import by.ecp.common.BaseDao;
import by.ecp.db.CompanyDao;
import by.ecp.db.PrivilegeDao;
import by.ecp.entity.Company;
import by.ecp.entity.Privilege;
import org.hibernate.SessionFactory;

/**
 * Created by User on 16.06.2017.
 */
public class PrivilegeDaoTest extends BaseDaoTest<Privilege> {
    private static SessionFactory SESSION_FACTORY;
    private BaseDao<Privilege> dao = new PrivilegeDao();

    @Override
    protected BaseDao<Privilege> getDao() {
        return dao;
    }

    @Override
    protected Privilege getModel() {
        return new Privilege();
    }
}
