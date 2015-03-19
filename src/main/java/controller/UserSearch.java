package controller;

import model.dao.EmployeeDAO;
import model.entities.employees.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Andrey on 03.03.2015.
 */
@WebServlet("/actions/userSearch")
public class UserSearch extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String emptyStr = "";
        String tmp = null;

        String id = null;
        String firstName = null;
        String lastName = null;

        tmp = req.getParameter("id");
        if (!tmp.equals(emptyStr)) {
            id = tmp;
        }

        tmp = req.getParameter("firstName");
        if (!tmp.equals(emptyStr)) {
            firstName = tmp;
        }

        tmp = req.getParameter("lastName");
        if (!tmp.equals(emptyStr)) {
            lastName = tmp;
        }

        List<Employee> eList = new EmployeeDAO().getEmployees(id, firstName, lastName);
        req.setAttribute("employeeList", eList);

        req.getRequestDispatcher("/pages/actions/userSearch/searchResult.jsp").forward(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/actions/userSearch/searchForm.jsp").forward(req, resp);
    }
}
