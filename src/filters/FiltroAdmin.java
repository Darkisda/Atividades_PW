package filters;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "FiltroAdmin", urlPatterns = {"/*"})
public class FiltroAdmin implements Filter {

    FilterConfig filterConfig;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        Cookie[] cookies = ((HttpServletRequest)req).getCookies();
        ServletContext servletContext = filterConfig.getServletContext();

        List<String> tokens = (ArrayList<String>) servletContext.getAttribute("tokens");

        for (var cookie : cookies) {
            if(cookie.getName().equals("authentication")){
                for (var token: tokens) {
                    if(token.equals(cookie.getValue())){
                        chain.doFilter(req, resp);
                    }
                }
            }
        }

        ((HttpServletResponse)resp).sendRedirect("http://localhost:8080/Atividades_PW_war_exploded/public/login.html");
    }

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }

}
