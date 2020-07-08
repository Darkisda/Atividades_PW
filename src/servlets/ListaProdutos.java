package servlets;

import models.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListaProdutos", urlPatterns = {"/lista_produtos"})
public class ListaProdutos extends HttpServlet {

    List<Produto> listaProdutos;

    public ListaProdutos(){
        listaProdutos = new ArrayList<>();

        var p1 = new Produto(1, "Violão Giannini", "Violão em maple com tampo em mogno", 750.9);
        var p2 = new Produto(2, "The Hobbit", "Livro The Hobbit por J.R.R.Tolkien", 59.9);
        var p3 = new Produto(3, "A arte da guerra", "Livro random que eu pensei aqui", 99.5);
        var p4 = new Produto(4, "Guitarra Ibanez PIA3761", "Guitarra do Steve Vai", 8999.9);
        var p5 = new Produto(5, "Placa Mãe Gigabyte 78LMT-USB3 REV.2", "Placa mãe para Socket AM3/AM3+", 375.9);

        listaProdutos.add(p1);
        listaProdutos.add(p2);
        listaProdutos.add(p3);
        listaProdutos.add(p4);
        listaProdutos.add(p5);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var print = response.getWriter();

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
        print.println("<table>");
        print.println("<tr>");
        print.println("<th> ID: </th>");
        print.println("<th> Nome: </th>");
        print.println("<th> Descrição: </th>");
        print.println("<th> Preço: </th>");
        print.println("<th> Link: </th>");
        print.println("</tr>");

        for (var listarProduto: listaProdutos) {
            print.println("<tr>");
            print.println("<td>" + listarProduto.get_id() + "</td>");
            print.println("<td>" + listarProduto.getNome() + "</td>");
            print.println("<td>" + listarProduto.getDescricao() + "</td>");
            print.println("<td>" + listarProduto.getPreco() + "</td>");
            print.println("<td> <a href='/Atividades_PW_war_exploded/lista_produtos/carrinho?id=" + listarProduto.get_id() + "'> Adicionar " + listarProduto.getNome() + " ao Carrinho </a> </td>");
            print.println("</tr>");
        }

        print.println("</table>");
        print.println("</body>");
        print.println("</html>");
    }
}
