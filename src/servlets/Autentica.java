package servlets;

import models.Usuario;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Autentica", urlPatterns = {"/autentica"})
public class Autentica extends HttpServlet {

    public Autentica() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var emaillgoado = request.getParameter("email");
        var senhalogado = request.getParameter("senha");

        ServletContext servletContext = getServletContext();
        List<Usuario> usersList = (ArrayList<Usuario>) servletContext.getAttribute("usuarios");
        List<String> tokenList = (ArrayList<String>) servletContext.getAttribute("tokens");

        var watcher = false;

        for(var user: usersList) {

            if (user.getEmail().equals(emaillgoado) && user.getSenha().equals(senhalogado)) {

                watcher = true;
                var token = user.getEmail() + user.getSenha();
                Cookie cookie = new Cookie("authentication", token);
                tokenList.add(token);
                servletContext.setAttribute("tokens", tokenList);
                response.addCookie(cookie);

                var dispatcher = request.getRequestDispatcher("/public/user.html");
                dispatcher.forward(request,response);
            }

        }

        if (watcher==false) {
            response.sendRedirect("http://localhost:8080/Atividades_PW_war_exploded/public/login.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
