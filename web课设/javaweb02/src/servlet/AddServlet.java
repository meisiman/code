package servlet;

import domain.Article;
import service.ArticleService;
import serviceimpl.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mei Siman
 * @date 2019/12/11  18:51
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //获取客户端提交上来的数据
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String context = request.getParameter("context");

            //添加到数据库
            Article article = new Article(title,author,context);
            ArticleService service = new ArticleServiceImpl();
            service.addArticle(article);

            //跳转界面
            request.getRequestDispatcher("ArticleServlet").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
