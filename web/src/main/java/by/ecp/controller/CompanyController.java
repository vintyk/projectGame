package by.ecp.controller;

import by.ecp.db.CompanyDao;
import by.ecp.entity.Company;
import by.ecp.services.CompanyService;
import by.ecp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    @ModelAttribute("allCompanies")
    public List<Company> listCompany() {
        return companyService.findAll();
    }

    @GetMapping("/MainPage")
    public String openMainPage(){
        return "GameProject";
    }

//    @PostMapping("/MainPage")
//    public String saveRegistrationVacancy( pizza) {
//        System.out.println(pizza);
//        return "pizza";
//    }
}
