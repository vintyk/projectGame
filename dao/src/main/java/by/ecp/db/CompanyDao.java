package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.Company;
import by.ecp.entity.Country;

/**
 * Created by Vinty on 11.06.2017.
 */
public class CompanyDao extends BaseDao<Company> {
    public CompanyDao() {
        super(Company.class);
    }

}
