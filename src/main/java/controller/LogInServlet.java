package controller;

import auxiliaryClasses.Pages;
import model.dao.EmployeeDAO;
import model.entities.employees.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * This class is responsible for guest identification.
 * It shows a login page and creates session if user's login and pass are valid.
 * Created by Andrey on 21.02.2015.
 */
@WebServlet("/login")
public class LogInServlet extends HttpServlet {

    /**
     * Receives a login and password, and if a user with that login data exists -
     * sets a session with with attribute of employee and redirects to the user page.
     * If login and pass are not valid - redirects to the login page.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");


        EmployeeDAO emplDAO = new EmployeeDAO();
        Employee employee = emplDAO.getEmployeeByLoginAndPass(login, password);
        if (employee != null) {
            HttpSession session = req.getSession();
            session.setAttribute("employee", employee);
            session.setMaxInactiveInterval(30*60);

            resp.sendRedirect(Pages.USER_DEFAULT_PAGE);
        } else {//login or pass is not valid
            req.getRequestDispatcher(Pages.LOGIN_PAGE).forward(req, resp);
        }

    }

    /**
     * If session is not valid - redirects to the login page. If valid - forwards the request.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession(false) != null)  {
            resp.sendRedirect(Pages.USER_DEFAULT_PAGE);
            return;
        }
        req.getRequestDispatcher(Pages.LOGIN_PAGE).forward(req, resp);
    }
}
