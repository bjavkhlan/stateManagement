import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Authentication implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        Object user = ((HttpServletRequest) req).getSession().getAttribute("user");

        if ("POST".equals(((HttpServletRequest) req).getMethod()) || user != null) {
            filterChain.doFilter(req, resp);
            return;
        } else {
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
            return;
        }


    }

    @Override
    public void destroy() {

    }
}
