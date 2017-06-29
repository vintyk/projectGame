package by.ecp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by User on 29.06.2017.
 */
@Controller
public class AdminToolController {
    @GetMapping("/adminTool")
    public String showLoginPage() {
        return "AdminTool";
    }
}

