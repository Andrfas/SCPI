package identificationModule;

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

        HttpSession session = req.getSession();
        session.setAttribute("user", "Pankaj");
        session.setMaxInactiveInterval(30*60);

        Cookie userName = new Cookie("user", "Igor");
        userName.setMaxAge(30*60);
        resp.addCookie(userName);

        req.setAttribute("sessionId", session.getLastAccessedTime());
        resp.sendRedirect("/SCPI/pages/authentication/authorisedUser.jsp");
//        req.getRequestDispatcher("/index.html").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        req.getRequestDispatcher("/pages/authentication/login.html").forward(req, resp);
    }
}
