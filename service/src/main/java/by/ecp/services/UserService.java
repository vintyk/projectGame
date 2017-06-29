package by.ecp.services;

import by.ecp.entity.Gender;
import by.ecp.entity.SystemUser;

import java.util.List;

/**
 * Created by SystemUser on 20.06.2017.
 */
public interface UserService {

    SystemUser findByEmail(String name);

    void saveUser(String nameUser,
                  Long privilegeId,
                  String family,
                  String eMail,
                  Gender gender,
                  String pass
    );
    List<SystemUser> findAll();
    SystemUser findById(Long id);
}
