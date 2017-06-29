package by.ecp.controller;

import by.ecp.entity.Job;
import by.ecp.entity.Vacancy;
import by.ecp.services.JobService;
import by.ecp.services.VacancyService;
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
public class JobTest {

    private final JobService jobService;
    private final VacancyService vacancyService;

    @Autowired
    public JobTest(JobService jobService, VacancyService vacancyService) {
        this.jobService = jobService;
        this.vacancyService = vacancyService;
    }

    @ModelAttribute("job")
    public Job job() {
        return new Job();
    }

    @ModelAttribute("vacancies")
    public List<Vacancy> vacancies() {
        return vacancyService.findAll();
    }

    @GetMapping(path = "/JobTest")
    public String showGameProjectForm() {
        return "JobTest";
    }

    @PostMapping(path = "/JobTest")
    public String saveJob(Job job) {
        jobService.save(job);
        return "/JobTest";
    }
}
