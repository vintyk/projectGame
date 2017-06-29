package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.Gender;
import by.ecp.entity.SystemUser;

/**
 * Created by SystemUser on 20.06.2017.
 */
public interface SystemUserDao extends BaseDao<SystemUser> {

    SystemUser findByEmail(String name);

    void saveUser(String nameUser,
                  String family,
                  String eMail,
                  String pass,
                  Gender gender,
                  Long privilegeId
                  );
}
