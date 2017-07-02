package by.ecp.services;

import by.ecp.entity.Gender;
import by.ecp.entity.SystemUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;

/**
 * Created by SystemUser on 20.06.2017.
 */
public interface UserService extends UserDetailsService {

    SystemUser findByEmail(String name);

    void saveUser(String nameUser,
                  Set<Long> privilegeId,
                  String family,
                  String eMail,
                  Gender gender,
                  String pass
    );

    List<SystemUser> findAll();

    SystemUser findById(Long id);
}
