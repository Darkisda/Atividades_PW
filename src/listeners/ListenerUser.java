package listeners;

import models.Usuario;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;
import java.util.List;

@WebListener()
public class ListenerUser implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public ListenerUser() {
    }

    public void contextInitialized(ServletContextEvent sce) {

        ServletContext servletContext = sce.getServletContext();
        List<Usuario> listusers = new ArrayList<>();
        List<String> listtoken = new ArrayList<>();

        var user1 = new Usuario(1, "Luan", "2410", "luan@email.com");
        var user2 = new Usuario(1, "Lauro", "2410", "lauro@email.com");
        var user3 = new Usuario(1, "Banana", "2410", "banana@email.com");

        listusers.add(user1);
        listusers.add(user2);
        listusers.add(user3);

        servletContext.setAttribute("usuarios", listusers);
        servletContext.setAttribute("tokens", listtoken);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
