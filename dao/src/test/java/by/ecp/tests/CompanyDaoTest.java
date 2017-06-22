package by.ecp.tests;

import by.ecp.common.BaseDao;
import by.ecp.db.CompanyDaoImpl;
import by.ecp.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Vinty on 11.06.2017.
 */

public class CompanyDaoTest extends BaseDaoTest<Company>{

    @Autowired
    private BaseDao<Company> dao = new CompanyDaoImpl();

    @Override
    protected BaseDao<Company> getDao() {
        return dao;
    }

    @Override
    protected Company getModel() {
        return new Company();
    }
}
