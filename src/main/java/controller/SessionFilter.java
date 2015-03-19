package controller;

import auxiliaryClasses.Pages;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * This filter calls after each request of a user.
 * It checks a session of the user and passes on the request if session is valid,
 * and forwards to the login page in the other way.
 * Created by Andrey on 20.02.2015.
 */
public class SessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    /**
     * Checks a request for active session. If there i no session or
     * a session is not valid - redirects to login page. In other way - forwards the request.
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);

        if (session != null) {
            filterChain.doFilter(req, res);
        } else if (req.getRequestURI().equals(Pages.USER_DEFAULT_PAGE)) {
            filterChain.doFilter(req, res);
        } else {
            req.getRequestDispatcher(Pages.LOGIN_PAGE).forward(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
