package by.ecp.tests;


import by.ecp.common.BaseDao;
import by.ecp.db.CountryDaoImpl;
import by.ecp.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Vinty on 10.06.2017.
 */
public class CountryDaoTest extends BaseDaoTest<Country> {

    @Autowired
    private BaseDao<Country> dao = new CountryDaoImpl();

    @Override
    protected BaseDao<Country> getDao() {
        return dao;
    }

    @Override
    protected Country getModel() {
        return new Country();
    }
}