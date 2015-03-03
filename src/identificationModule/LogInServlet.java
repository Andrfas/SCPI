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

        String login = (String) req.getAttribute("login");
        String password = (String) req.getAttribute("password");

        EmployeeDAO emplDAO = new EmployeeDAO();
        Employee employee = emplDAO.getEmployee(login, password);
        if (employee != null) {
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            session.setAttribute("employee", employee);
            session.setMaxInactiveInterval(30*60);
            resp.sendRedirect("/SCPI/actions");
        } else {
            resp.sendRedirect("/SCPI/login");
        }



//        Cookie userName = new Cookie("user", "Igor");
//        userName.setMaxAge(30*60);
//        resp.addCookie(userName);

//        req.setAttribute("sessionId", session.getLastAccessedTime());
//        req.getRequestDispatcher("/index.html").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/pages/authentication/login.html").forward(req, resp);
    }
}
