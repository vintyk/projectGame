package by.ecp;

import by.ecp.entity.*;
import by.ecp.services.CountryService;
import by.ecp.services.JobService;
import by.ecp.services.UserService;
import by.ecp.services.VacancyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by SystemUser on 20.06.2017.
 */
public class Starter {
      public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);

                JobService jobService = context.getBean(JobService.class);
        List<Job> jobList = jobService.findAll();
        System.out.println(jobList);

//          JobService jobService = context.getBean(JobService.class);
//          Job job = new Job();
//          Vacancy vacancy = new Vacancy();
//          VacancyService vacancyService = context.getBean(VacancyService.class);
//          job.setNameUser("Vital");
//          job.setFamilyUser("Ushakov");
//          job.setEmail("vinty1978@gmail.com");
//          job.setComment("я клевый!");
//          job.setGender(Gender.MALE);
//          job.setEnglish(English.EXELLENCE);
//          job.setVacancy(vacancy);
//          jobService.save(job);

//                UserService userService = context.getBean(UserService.class);
//          Set<Long> longSet = new HashSet<>();
//          longSet.add(2L);
//        userService.saveUser(
//                "Valera",
//                longSet,
//                "Nechay",
//                "vn@ecp.by",
//                Gender.MALE,
//                "1");
//
//        CountryService countryService = context.getBean(CountryService.class);
//        List<Country> countryList = countryService.findAll();
//        System.out.println(countryList);

//        UserService userService = context.getBean(UserService.class);
//        List<SystemUser> users = userService.findAll();
//        users.forEach(System.out::println);
//        System.out.println(userService.findById(1L));

//        Address address = new Address();
//        address.setCountry("РБ");
//        address.setCity("Минск");
//        Address address1 = new Address();
//        address1.setCountry("Великобритания");
//        address1.setCity("Лондон");
//        SystemUser user = new SystemUser();
//        user.setNameUser("Valera");
//        user.setFamilyUser("Nechay");
//        user.setPrivilege(privilege);
//        user.setFirstAddress(address);
//        user.setSecondAddress(address1);
//        user.setPasswordUser("12345");
//        user.setGender(Gender.MALE);
//        user.setemail("vn@ecp.by");
    }

}
