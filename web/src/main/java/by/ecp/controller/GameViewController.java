package by.ecp.controller;

import by.ecp.dto.SystemUserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Vinty on 09.07.2017.
 */
@Controller
public class GameViewController {

    @GetMapping(path = "/GameView")
    public String showGameViewForm() {
        return "GameView";
    }

    @PostMapping(path = "/GameView")
    public String tempGameDto(Model model){
        return "/GameView";
    }
}
