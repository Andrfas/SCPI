package actions;

import entities.employees.Employee;
import entities.employees.EmployeeGroup;
import entities.employees.GroupActions;
import org.hibernate.Hibernate;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    @Transactional
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        Employee employee = (Employee) session.getAttribute("employee");

        EmployeeGroup emplGroup = employee.getEmployeeGroup();

        List<GroupActions> gActions = emplGroup.getActions();

        int listSize = gActions.size();
        List<String[]> actionsList = new ArrayList<String[]>(listSize);
        for (int i=0; i<listSize; i++) {
            actionsList.add(new String[]{gActions.get(i).getName(), gActions.get(i).getClassName()});
        }

        req.setAttribute("actionsList", actionsList);

                req.getRequestDispatcher("/pages/actions/authorisedUser.jsp").forward(req, resp);
    }
}
