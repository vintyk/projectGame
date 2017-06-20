package by.dao;

import by.ecp.common.BaseDaoImpl;
import by.ecp.db.SettingDaoImpl;
import by.ecp.entity.Setting;

/**
 * Created by User on 16.06.2017.
 */
public class SettingDaoTest extends BaseDaoTest<Setting> {

    private BaseDaoImpl<Setting> dao = new SettingDaoImpl();

    @Override
    protected BaseDaoImpl<Setting> getDao() {
        return dao;
    }

    @Override
    protected Setting getModel() {
        return new Setting();
    }
}
