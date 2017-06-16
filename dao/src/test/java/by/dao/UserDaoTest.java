package by.dao;

import by.ecp.common.BaseDao;
import by.ecp.db.UserDao;
import by.ecp.entity.User;
import org.hibernate.SessionFactory;

/**
 * Created by User on 16.06.2017.
 */
public class UserDaoTest extends BaseDaoTest<User>{
    private static SessionFactory SESSION_FACTORY;
    private BaseDao<User> dao = new UserDao();

    @Override
    protected BaseDao<User> getDao() {
        return dao;
    }

    @Override
    protected User getModel() {
        return new User();
    }
}
