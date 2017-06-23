package by.ecp.servlet;

import by.ecp.Config;
import by.ecp.db.CountryDaoImpl;
import by.ecp.entity.Country;
import by.ecp.services.CountryService;
import by.ecp.services.PrivilegeService;
import by.ecp.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Vinty.
 */
@WebServlet("/testServlet")
public class ServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showPage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        showPage(req, resp);
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        CountryService countryService = context.getBean(CountryService.class);
        req.setAttribute("listCountries", countryService.findAll());
        req.setAttribute("country_name", countryService.findOne(1L));
        System.out.println("ВОЗВРАЩАЕМ ОДНОГО "+countryService.findOne(1L));
        PrivilegeService privilegeService = context.getBean(PrivilegeService.class);
        req.setAttribute("listPrivilege", privilegeService.findAll());

        UserService userService = context.getBean(UserService.class);
        req.setAttribute("listUser", userService.findAll());
        req.setAttribute("email", userService.findById(1L));
        System.out.println("ВОЗВРАЩАЕМ ОДНОГО "+userService.findById(1L));
        getServletContext().getRequestDispatcher("/WEB-INF/country.jsp").forward(req, resp);
    }
}
