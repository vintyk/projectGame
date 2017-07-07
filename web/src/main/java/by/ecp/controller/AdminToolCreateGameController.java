package by.ecp.controller;

import by.ecp.dto.GameDto;
import by.ecp.entity.*;
import by.ecp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by User on 07.07.2017.
 */
@Controller
public class AdminToolCreateGameController {

    private final CompanyService companyService;
    private final GenreService genreService;
    private final PaymentModelService paymentModelService;
    private final SettingService settingService;
    private final StageService stageService;

    @Autowired
    public AdminToolCreateGameController(CompanyService companyService,
                                         GenreService genreService,
                                         PaymentModelService paymentModelService,
                                         SettingService settingService,
                                         StageService stageService) {
        this.companyService = companyService;
        this.genreService = genreService;
        this.paymentModelService = paymentModelService;
        this.settingService = settingService;
        this.stageService = stageService;
    }

    @ModelAttribute("gameDto")
    public GameDto gameDto() {
        return new GameDto();
    }
    @ModelAttribute("companies")
    public List<Company> companies() {
        return companyService.findAll();
    }
    @ModelAttribute("genres")
    public List<Genre> genres() {
        return genreService.findAll();
    }
    @ModelAttribute("paymentModels")
    public List<PaymentModel> paymentModels() {
        return paymentModelService.findAll();
    }
    @ModelAttribute("settings")
    public List<Setting> settings() {
        return settingService.findAll();
    }
    @ModelAttribute("stages")
    public List<Stage> stages() {
        return stageService.findAll();
    }

    @GetMapping("/adminToolCreateGame")
    public String showCreateGamePage() {
        return "AdminToolCreateGame";
    }

    @PostMapping("/adminToolCreateGame")
    public String tempGameDtoPage() {
        return "AdminToolCreateGame";
    }
}
