package listeners;

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
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    public Listener() {
    }
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        List<String> listasNomes = new ArrayList<>();

        var nome1 = "Bananinha";
        var nome2 = "Pipoquinha";
        var nome3 = "Balãozinho";
        var nome4 = "Coxinha";

        listasNomes.add(nome1);
        listasNomes.add(nome2);
        listasNomes.add(nome3);
        listasNomes.add(nome4);

        servletContext.setAttribute("listaDeNomesGlobal", listasNomes);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
