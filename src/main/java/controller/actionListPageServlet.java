package controller;

import model.entities.employees.Employee;
import model.entities.employees.EmployeeGroup;
import model.entities.employees.GroupActions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

/**
 * Created by Andrey on 21.02.2015.
 */
@WebServlet("/actions")
public class actionListPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

    }


    @Override
//    @Transactional
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        Employee employee = (Employee) session.getAttribute("employee");

        EmployeeGroup emplGroup = employee.getEmployeeGroup();

        Set<GroupActions> gActions = emplGroup.getActions();

        req.setAttribute("actionsList", gActions);

                req.getRequestDispatcher("/pages/actions/actionListPage.jsp").forward(req, resp);
    }
}
