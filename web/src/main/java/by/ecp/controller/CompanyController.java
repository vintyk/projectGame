package by.ecp.controller;

import by.ecp.entity.Company;
import by.ecp.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @ModelAttribute("company")
    public Company company() {
        return new Company();
    }

    @ModelAttribute("companies")
    public List<Company> companies() {
        return companyService.findAll();
    }

    @GetMapping("/company")
    public String openMainPage(){
        return "GameProject";
    }

//    @PostMapping("/MainPage")
//    public String saveRegistrationVacancy( pizza) {
//        System.out.println(pizza);
//        return "pizza";
//    }
}
