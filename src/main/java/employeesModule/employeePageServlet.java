package employeesModule;

import artifacts.ActionsDao;
import entities.artifacts.Action;
import entities.employees.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Andrey on 15.03.2015.
 */
@WebServlet("/employee")
public class employeePageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDAO emplDao = new EmployeeDAO();
        String id = req.getParameter("id");
        Employee empl = emplDao.getEmployee(id);

        ActionsDao actionDao = new ActionsDao();
        List<Action> actionList = actionDao.getActionsByEmployee(empl);

        req.setAttribute("employee", empl);
        req.setAttribute("actionList", actionList);
        req.getRequestDispatcher("/pages/actions/userSearch/employeeInfoPage.jsp").forward(req, resp);
    }
}
