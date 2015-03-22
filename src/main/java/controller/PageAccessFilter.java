package controller;

import auxiliaryClasses.Pages;
import model.entities.employees.Employee;
import model.entities.employees.EmployeeGroup;
import model.entities.employees.GroupActions;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Andrey on 19.03.2015.
 */
public class PageAccessFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        String reqUrl = ((HttpServletRequest) req).getRequestURI();
        if (reqUrl.startsWith("/SCPI/login")) {
            chain.doFilter(req, resp);
        } else {


            Employee empl = (Employee) ((HttpServletRequest) req).getSession(false).getAttribute("employee");
            EmployeeGroup g = empl.getEmployeeGroup();
            Set<GroupActions> actions = g.getActions();

            boolean permitted = false;
            Iterator<GroupActions> iter = actions.iterator();
            while (iter.hasNext()) {
                if (iter.next().getClassName().startsWith(reqUrl)) {
                    permitted = true;
                    break;
                }
            }

            if (permitted) {
                chain.doFilter(req, resp);
            }

        }

    }


    @Override
    public void destroy() {

    }
}
