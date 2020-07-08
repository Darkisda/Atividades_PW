import models.Pessoa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Cadastro", urlPatterns = {"/cadastrar"})
public class Cadastro extends HttpServlet {

    private List<Pessoa> listaPessoa;

    public Cadastro() {
        listaPessoa = new ArrayList<>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var nome = request.getParameter("nome");
        var idade = request.getParameter("idade");
        var preferencias = request.getParameterValues("preferencias");

        Pessoa novaPessoa = new Pessoa(nome, idade, preferencias);
        listaPessoa.add(novaPessoa);

        PrintWriter print = response.getWriter();
        print.println("<html>");
        print.println("<head>");
        print.println("<style>");
        print.println(".tabela: {" +
                "width: 1010px;"+
                "margin: 50px auto;"+
                "}");
        print.println("</style>");
        print.println("<title>Atividade 1</title>");
        print.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">\n");
        print.println("</head");
        print.println("<body class=\"container\" \"bg-primary\" >");
        print.println("<div class=\"tabela\" >");
        print.println("<h1>Cadastrado com sucesso!</h1> </hr>");
        print.println("<table class=\"table\" >");
        print.println("<tr>");
        print.println("<th scope=\"col\" >Nomes: </th>");
        print.println("<th scope=\"col\">Idade: </th>");
        print.println("<th scope=\"col\">Preferêncais: </th>");
        print.println("</tr>");
        for (var pessoa:listaPessoa) {
            print.println("<tr>");
            print.println("<td>" + pessoa.getNome() + "</td>");
            print.println("<td>" + pessoa.getIdade() + "</td>");
            print.println("<td>");
            for (var prefPessoa: pessoa.getPreferencias()) {
                print.println(prefPessoa.toUpperCase());
            }
            print.println("</td>");
            print.println("</tr>");
        }
        print.println("</table>");
        print.println("</div>");
        print.println("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\" integrity=\"sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI\" crossorigin=\"anonymous\"></script>");
        print.println("</body>");

        print.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Hello");
    }
}
