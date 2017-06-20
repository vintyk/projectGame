package by.ecp;

import by.ecp.entity.Address;
import by.ecp.entity.Gender;
import by.ecp.entity.Privilege;
import by.ecp.entity.User;
import by.ecp.services.PrivilegeService;
import by.ecp.services.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by User on 20.06.2017.
 */
public class Starter {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                =new ClassPathXmlApplicationContext("application_service.content.xml");

        UserService userService = context.getBean(UserService.class);
        PrivilegeService privilegeService = context.getBean(PrivilegeService.class);



//        Privilege privilege = privilegeService.findOne(2L);
//        Address address = new Address();
//        address.setCountry("РБ");
//        address.setCity("Минск");
//        Address address1 = new Address();
//        address1.setCountry("Великобритания");
//        address1.setCity("Лондон");
//
//        User user = new User();
//        user.setNameUser("Valera");
//        user.setFamilyUser("Nechay");
//        user.setPrivilege(privilege);
//        user.setFirstAddress(address);
//        user.setSecondAddress(address1);
//        user.setPasswordUser("12345");
//        user.setGender(Gender.MALE);
//        user.setEMailUser("vn@ecp.by");
    }

}
