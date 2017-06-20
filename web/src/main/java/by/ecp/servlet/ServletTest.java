package by.ecp.servlet;

import by.ecp.db.CountryDaoImpl;
import by.ecp.entity.Country;

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
        CountryDaoImpl countryDao = new CountryDaoImpl();
        Country country = countryDao.findOne(1L);
        req.setAttribute("Countries", country);
        CountryDaoImpl countryDao1 = new CountryDaoImpl();
        List<Country> country1 = countryDao1.findAll();
        req.setAttribute("listCountries", country1);
      getServletContext().getRequestDispatcher("/WEB-INF/jsp/country.jsp").forward(req, resp);
    }
}
