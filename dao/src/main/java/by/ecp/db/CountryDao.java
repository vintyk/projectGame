package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.Country;

import java.util.List;

/**
 * Created by User on 20.06.2017.
 */

public interface CountryDao extends BaseDao<Country>{

    List<Country> ListAll();

}
