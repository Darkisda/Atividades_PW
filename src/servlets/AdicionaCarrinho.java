package servlets;

import models.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "AdicionaCarrinho", urlPatterns = {"/lista_produtos/carrinho"})
public class AdicionaCarrinho extends HttpServlet {

    Double precoTotal;
    List<Produto> listaProdutos;
    DecimalFormat precoDecimal = new DecimalFormat("0.00");

    public AdicionaCarrinho() {
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

        precoTotal = 0.0;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(true);

        var print = response.getWriter();

        var idProduto = Integer.parseInt(request.getParameter("id"));

        List<Produto> produtosSessao = (List<Produto>) sessao.getAttribute("listaProdutos");

        if(produtosSessao == null){
            produtosSessao = new ArrayList<>();
        }

        for (var produto: listaProdutos) {
            if(produto.get_id() == idProduto){
                produtosSessao.add(produto);
                precoTotal = precoTotal + produto.getPreco();
                sessao.setAttribute("listaProdutos", produtosSessao);
                sessao.setAttribute("precototal", precoTotal);
                break;
            }
        }
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
            if(produtosSessao.size() == 0) {
                response.getWriter().println("<h1>Carrinho vazio</h1>");
            } else {
                print.println("<table>");
                print.println("<tr>");
                print.println("<th> ID: </th>");
                print.println("<th> Nome: </th>");
                print.println("<th> Preço: </th>");
                print.println("</tr>");

                for (var produto: produtosSessao) {
                    print.println("<tr>");
                    print.println("<td>" + produto.get_id() + "</td>");
                    print.println("<td>" + produto.getNome() + "</td>");
                    print.println("<td>" + produto.getPreco() + "</td>");
                    print.println("</tr>");
                }

                print.println("<tr>");
                print.println("<th> Preço Total: </th>");
                print.println("<th></th>");
                print.println("<td>" + precoDecimal.format(precoTotal) + "</td>");
                print.println("</tr>");
                print.println("</table>");
            }
        print.println("</body>");
        print.println("</html>");
    }
}
