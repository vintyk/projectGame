package by.ecp.services;

import by.ecp.db.UserDao;
import by.ecp.entity.Gender;
import by.ecp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 20.06.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public User findByEmail(String name) {
        return userDao.findByEmail(name);
    }

    @Override
    public void saveUser(
            String nameUser,
            Long privilegeId,
            String family,
            String eMail,
            Gender gender,
            String pass) {
    userDao.saveUser(
            nameUser,
            family,
            eMail,
            pass,
            gender,
            privilegeId
    );
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Long id) {
        return userDao.findOne(id);
    }
}
