package by.ecp.controller;

import by.ecp.entity.Company;
import by.ecp.entity.Job;
import by.ecp.services.CompanyService;
import by.ecp.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by SystemUser on 28.06.2017.
 */
@Controller
public class JobController {

    private final JobService jobService;
    private final CompanyService companyService;

    @Autowired
    public JobController(JobService jobService, CompanyService companyService){
        this.jobService = jobService;
        this.companyService = companyService;
    }

    @ModelAttribute("job")
    public Job job() {
        return new Job();
    }

    @ModelAttribute("companies")
    public List<Company> companies(){
        return companyService.findAll();
    }

    @GetMapping(path = "/GameProject")
    public  String showGameProjectForm()
    {
        return "GameProject";
    }

    @PostMapping(path = "/GameProject")
    public String saveJob(Job job){
        jobService.save(job);
        return "/GameProject";
    }
}
