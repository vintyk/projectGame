package by.ecp.controller;

import by.ecp.entity.Gender;
import by.ecp.entity.SystemUser;
import by.ecp.services.CountryService;
import by.ecp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Vinty on 02.07.2017.
 */
@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService){
        this.userService = userService;
    }

    @ModelAttribute("systemuser")
    public SystemUser systemUser() {
        return new SystemUser();
    }
    @ModelAttribute("genders")
    public List<Gender> genders() {
        return Arrays.asList(Gender.values());
    }

    @GetMapping(path = "/registration")
    public  String showRegistrationForm(){
        return "Registration";
    }
    @PostMapping(path = "/registration")
    public String saveUser(SystemUser systemUser, Model model){
        model.addAttribute("systemuser", systemUser);
        return "/Registration";
    }
}
