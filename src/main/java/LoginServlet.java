import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserData userData = new UserData();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/lab12/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rememberme = req.getParameter("rememberme");
        HttpSession session = req.getSession();
        //resp.getWriter().println(username + password);
        User user = userData.getUser(username);
        if (user == null) {
            session.setAttribute("err_msg","Username is not correct!");
            resp.sendRedirect("login");
        } else if (user.getUsername().equals(password)) {
            session.setAttribute("user", user);

            Cookie cookie = new Cookie("username", username);
            if ("true".equals(rememberme)) cookie.setMaxAge(30 * 24 * 60 * 60);
            else cookie.setMaxAge(0);
            resp.addCookie(cookie);

            Cookie promo = new Cookie("promo", "$100");
            promo.setMaxAge(30 * 24 * 60 * 60);
            resp.addCookie(promo);

            resp.sendRedirect("welcome.jsp");
        } else {
            session.setAttribute("err_msg","Password is not correct!");
            resp.sendRedirect("login");
        }
    }
}
