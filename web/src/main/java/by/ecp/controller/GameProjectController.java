package by.ecp.controller;

import by.ecp.entity.*;
import by.ecp.services.JobService;
import by.ecp.services.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

/**
 * Created by SystemUser on 28.06.2017.
 */
@Controller
public class GameProjectController {

    private final JobService jobService;
    private final VacancyService vacancyService;

    @Autowired
    public GameProjectController(JobService jobService, VacancyService vacancyService) {
        this.jobService = jobService;
        this.vacancyService = vacancyService;
    }
    @ModelAttribute("vacancy")
    public Vacancy vacancy() {
        return new Vacancy();
    }

    @ModelAttribute("job")
    public Job job() {
        return new Job();
    }
    @ModelAttribute("vacancies")
    public List<Vacancy> vacancies() {
        return vacancyService.findAll();
    }
    @ModelAttribute("genders")
    public List<Gender> genders() {
        return Arrays.asList(Gender.values());
    }
    @ModelAttribute("englishes")
    public List<English> englishes() {
        return Arrays.asList(English.values());
    }

    @GetMapping(path = "/GameProject")
    public String showGameProjectForm() {
        return "GameProject";
    }
    @PostMapping(path = "/GameProject")
    public String saveJob(Job job, Model model) {
        jobService.save(job);
        return "GameProject";
    }
}
