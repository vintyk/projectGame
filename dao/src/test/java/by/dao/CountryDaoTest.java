package by.dao;

import by.ecp.common.BaseDaoImpl;
import by.ecp.db.CountryDaoImpl;
import by.ecp.entity.Country;

/**
 * Created by Vinty on 10.06.2017.
 */
public class CountryDaoTest extends BaseDaoTest<Country> {

    private BaseDaoImpl<Country> dao = new CountryDaoImpl();

    @Override
    protected BaseDaoImpl<Country> getDao() {
        return dao;
    }

    @Override
    protected Country getModel() {
        return new Country();
    }
}