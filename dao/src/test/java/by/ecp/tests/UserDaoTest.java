package by.ecp.tests;

import by.ecp.db.PrivilegeDao;
import by.ecp.db.UserDao;
import by.ecp.entity.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Vinty on 18.06.2017.
 */
public class UserDaoTest extends BaseTest {

    @Autowired
    private PrivilegeDao privilegeDao;
    @Autowired
    private UserDao userDao;

    @Test
    public void getByEmailTest() {
//        PrivilegeDaoImpl privilegeDao = new PrivilegeDaoImpl();
//        UserDaoImpl userDao = new UserDaoImpl();
        Privilege privilege = new Privilege();
        User user = new User();
        Address address = new Address();
        address.setCity("Minsk");
        address.setCountry("RB");

        privilege.setNamePrivilege("Главный_на_районе");
        privilegeDao.save(privilege);

        user.setNameUser("Vee");
        user.setEMailUser("vee@gmail.com");
        user.setFamilyUser("Loo");
        user.setFirstAddress(address);
        user.setGender(Gender.FEMALE);
        user.setPasswordUser("qwerty");
        user.setPrivilege(privilege);
        userDao.save(user);

        User result = userDao.findByEmail("vee@gmail.com");
        System.out.println(result);
        assertEquals(user.getEMailUser(), "vee@gmail.com");
    }

    @Test
    public void saveUserTest() {
        Privilege privilege = new Privilege();
        User user = new User();
        Address address = new Address();
        address.setCity("Minsk");
        address.setCountry("RB");

        privilege.setNamePrivilege("Админко");
        privilegeDao.save(privilege);

        userDao.saveUser(
                "MeeMo",
                "Loo_Lee",
                "MeeMo@gmail.com",
                "qwerty2",
                Gender.MALE,
                1L
        );
        List<User> result = userDao.findAll();
        System.out.println(result);
        assertNotNull(result);
    }
}

