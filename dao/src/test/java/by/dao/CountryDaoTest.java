package by.dao;

import by.ecp.common.BaseDao;
import by.ecp.db.CountryDao;
import by.ecp.entity.Country;
import org.hibernate.SessionFactory;

/**
 * Created by Vinty on 10.06.2017.
 */
public class CountryDaoTest extends BaseDaoTest<Country> {

    private BaseDao<Country> dao = new CountryDao();

    @Override
    protected BaseDao<Country> getDao() {
        return dao;
    }

    @Override
    protected Country getModel() {
        return new Country();
    }
}