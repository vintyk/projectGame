package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.Privilege;

/**
 * Created by User on 16.06.2017.
 */
public class PrivilegeDao extends BaseDao<Privilege> {
    public PrivilegeDao() {
        super(Privilege.class);
    }
}
