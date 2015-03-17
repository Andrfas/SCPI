package actions;

import entities.employees.Employee;
import entities.employees.EmployeeGroup;
import entities.employees.GroupActions;
import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

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
