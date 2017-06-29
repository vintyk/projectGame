package by.ecp.tests;

import by.ecp.db.PrivilegeDao;
import by.ecp.db.SystemUserDao;
import by.ecp.entity.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Vinty on 18.06.2017.
 */
public class SystemSystemUserDaoTest extends BaseTest {

    @Autowired
    private PrivilegeDao privilegeDao;
    @Autowired
    private SystemUserDao systemUserDao;

    @Test
    public void getByEmailTest() {
//        PrivilegeDaoImpl privilegeDao = new PrivilegeDaoImpl();
//        SystemUserDaoImpl systemUserDao = new SystemUserDaoImpl();
        Privilege privilege = new Privilege();
        SystemUser systemUser = new SystemUser();
        Address address = new Address();
        address.setCity("Minsk");
        address.setCountry("RB");

        privilege.setNamePrivilege("Главный_на_районе");
        privilegeDao.save(privilege);

        systemUser.setNameUser("Vee");
        systemUser.setEmail("vee@gmail.com");
        systemUser.setFamilyUser("Loo");
        systemUser.setFirstAddress(address);
        systemUser.setGender(Gender.FEMALE);
        systemUser.setPasswordUser("qwerty");
        systemUser.setPrivilege(privilege);
        systemUserDao.save(systemUser);

        SystemUser result = systemUserDao.findByEmail("vee@gmail.com");
        System.out.println(result);
        assertEquals(systemUser.getEmail(), "vee@gmail.com");
    }

    @Test
    public void saveUserTest() {
        Privilege privilege = new Privilege();
        SystemUser systemUser = new SystemUser();
        Address address = new Address();
        address.setCity("Minsk");
        address.setCountry("RB");

        privilege.setNamePrivilege("Админко");
        privilegeDao.save(privilege);

        systemUserDao.saveUser(
                "MeeMo",
                "Loo_Lee",
                "MeeMo@gmail.com",
                "qwerty2",
                Gender.MALE,
                1L
        );
        List<SystemUser> result = systemUserDao.findAll();
        System.out.println(result);
        assertNotNull(result);
    }
}

