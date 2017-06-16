package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.Country;
import by.ecp.entity.Setting;

/**
 * Created by User on 16.06.2017.
 */
public class SettingDao extends BaseDao<Setting> {
    public SettingDao() {
        super(Setting.class);
    }
}
