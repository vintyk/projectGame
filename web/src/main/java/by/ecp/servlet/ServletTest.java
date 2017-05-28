package by.ecp.servlet;

import by.ecp.db.CountryDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        req.setAttribute("listCountries", CountryDao.getInstance().getCountryList());
      getServletContext().getRequestDispatcher("/WEB-INF/jsp/country.jsp").forward(req, resp);
    }
}
