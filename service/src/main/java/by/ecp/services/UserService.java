package by.ecp.services;

import by.ecp.entity.Gender;
import by.ecp.entity.User;

import java.util.List;

/**
 * Created by User on 20.06.2017.
 */
public interface UserService {

    User findByEmail(String name);

    void saveUser(String nameUser,
                  Long privilegeId,
                  String family,
                  String eMail,
                  Gender gender,
                  String pass
    );
    List<User> findAll();
    User findById(Long id);
}
