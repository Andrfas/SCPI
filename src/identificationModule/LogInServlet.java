package identificationModule;

import employeesModule.EmployeeDAO;
import entities.employees.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Andrey on 21.02.2015.
 */
@WebServlet("/login")
public class LogInServlet extends HttpServlet {
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

            resp.sendRedirect("/SCPI/actions");
        } else {
            resp.sendRedirect("/SCPI/login");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/pages/authentication/login.html").forward(req, resp);
    }
}
