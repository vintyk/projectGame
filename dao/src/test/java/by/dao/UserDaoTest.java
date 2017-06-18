package by.dao;

import by.ecp.db.PrivilegeDao;
import by.ecp.db.UserDao;
import by.ecp.entity.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vinty on 18.06.2017.
 */
public class UserDaoTest {
    @Test
    public void getByEmailTest() {
        PrivilegeDao privilegeDao = new PrivilegeDao();
        UserDao userDao = new UserDao();
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
}

