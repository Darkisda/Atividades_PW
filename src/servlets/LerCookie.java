package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LerCookie", urlPatterns = {"/cookies/ler-cookies"})
public class LerCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var print = response.getWriter();

        Cookie cookies[] = request.getCookies();

        print.println("<html>");
        print.println("<head>");
        print.println("<style>");
        print.println("table, th, td {\n" +
                "  border: 1px solid black;\n" +
                "  padding: 8px 8px;\n" +
                "  border-collapse: collapse;\n" +
                "}");
        print.println("</style>");
        print.println("<head>");
        print.println("<body>");

        if(cookies == null) {
            print.println("<h1>Cookies Inexistentes</h1>");
        }else {
            print.println("<table>");
            print.println("<tr>");
            print.println("<th> Nome do Cookie: </th>");
            print.println("<th> Valor do Cookie: </th>");
            print.println("</tr>");

            for (var cookie: cookies) {
                print.println("<tr>");
                print.println("<td>" +  cookie.getName() + "</td>");
                print.println("<td>" + cookie.getValue() + "</td>");
                print.println("</tr>");
            }

            print.println("<table>");
        }

        print.println("</body>");
        print.println("</html>");
    }
}
