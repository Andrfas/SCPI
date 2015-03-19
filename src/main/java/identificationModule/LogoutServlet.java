package identificationModule;

import auxiliaryClasses.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Andrey on 21.02.2015.
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session != null){
            session.invalidate();
            resp.sendRedirect(Pages.MAIN_PAGE);
        } else {
            req.getRequestDispatcher(Pages.LOGIN_PAGE).forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session != null){
            session.invalidate();
            resp.sendRedirect(Pages.MAIN_PAGE);
        } else {
            req.getRequestDispatcher(Pages.LOGIN_PAGE).forward(req, resp);
        }
    }
}
