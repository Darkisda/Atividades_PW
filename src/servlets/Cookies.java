package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookies", urlPatterns = {"/cookies"})
public class Cookies extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("cookie1", "um");
        Cookie cookie2 = new Cookie("cookie2", "doix");
        Cookie cookie3 = new Cookie("cookie3", "tles");
        Cookie cookie4 = new Cookie("cookie4", "catu");
        Cookie cookie5 = new Cookie("cookie5", "cincu");

        cookie1.setMaxAge(15);
        cookie3.setMaxAge(25);
        cookie5.setMaxAge(35);

        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        response.addCookie(cookie4);
        response.addCookie(cookie5);
    }
}
