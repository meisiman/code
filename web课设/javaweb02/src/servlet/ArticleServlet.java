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
import java.sql.SQLException;
import java.util.List;

/**
 * @author Mei Siman
 * @date 2019/11/26  19:42
 */
@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //查询出来所有的文章
            ArticleService service = new ArticleServiceImpl();
            List<Article> list = service.findArticle();

            //把数据存储到作用域中
            request.setAttribute("list", list);

            request.getRequestDispatcher("CountServlet").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
