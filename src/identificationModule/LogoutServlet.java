package identificationModule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Andrey on 21.02.2015.
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if(session != null){
            session.invalidate();
        }



        resp.sendRedirect("LoginSuccess.jsp");
//        req.getRequestDispatcher("/index.html").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/pages/authentication/login.html").forward(req, resp);
    }
}
