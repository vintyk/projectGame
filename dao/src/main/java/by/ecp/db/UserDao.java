package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.Gender;
import by.ecp.entity.User;

/**
 * Created by User on 20.06.2017.
 */
public interface UserDao extends BaseDao<User> {

    User findByEmail(String name);

    void saveUser(String nameUser,
                  Long privilegeId,
                  String family,
                  String eMail,
                  Gender gender,
                  String pass
    );
}
