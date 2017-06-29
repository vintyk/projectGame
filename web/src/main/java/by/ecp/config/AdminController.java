package by.ecp.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by SystemUser on 29.06.2017.
 */
@Controller
public class AdminController {

    @GetMapping("/admin")
    public String showAdminPage() {
        return "admin";
    }
}
