package by.ecp.services;

import by.ecp.db.SystemUserDao;
import by.ecp.entity.Gender;
import by.ecp.entity.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SystemUser on 20.06.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final SystemUserDao systemUserDao;

    @Autowired
    public UserServiceImpl(SystemUserDao systemUserDao){
        this.systemUserDao = systemUserDao;
    }

    @Override
    public SystemUser findByEmail(String name) {
        return systemUserDao.findByEmail(name);
    }

    @Override
    public void saveUser(
            String nameUser,
            Long privilegeId,
            String family,
            String eMail,
            Gender gender,
            String pass) {
    systemUserDao.saveUser(
            nameUser,
            family,
            eMail,
            pass,
            gender,
            privilegeId
    );
    }

    @Override
    public List<SystemUser> findAll() {
        return systemUserDao.findAll();
    }

    @Override
    public SystemUser findById(Long id) {
        return systemUserDao.findOne(id);
    }
}
