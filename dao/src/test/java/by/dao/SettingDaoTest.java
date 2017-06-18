package by.dao;

import by.ecp.common.BaseDao;
import by.ecp.db.CompanyDao;
import by.ecp.db.SettingDao;
import by.ecp.entity.Company;
import by.ecp.entity.Setting;
import org.hibernate.SessionFactory;

/**
 * Created by User on 16.06.2017.
 */
public class SettingDaoTest extends BaseDaoTest<Setting> {

    private BaseDao<Setting> dao = new SettingDao();

    @Override
    protected BaseDao<Setting> getDao() {
        return dao;
    }

    @Override
    protected Setting getModel() {
        return new Setting();
    }
}
