package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LerListener", urlPatterns = {"/listener"})
public class LerListener extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var print = response.getWriter();
        ServletContext servletContext = getServletContext();

        List<String> listaNomeLocal = (ArrayList<String>) servletContext.getAttribute("listaDeNomesGlobal");

        print.println("<html>");
        print.println("<body>");
        for (var nome: listaNomeLocal ) {
            print.println("<p>" + nome + "</p>");
        }
        print.println("</body>");
        print.println("</html>");
    }
}
