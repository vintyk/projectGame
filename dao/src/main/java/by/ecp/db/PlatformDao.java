package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.Country;
import by.ecp.entity.Platform;

/**
 * Created by User on 16.06.2017.
 */
public class PlatformDao extends BaseDao<Platform> {
    public PlatformDao() {
        super(Platform.class);
    }
}
