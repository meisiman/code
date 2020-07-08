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
 * @date 2019/12/15  11:19
 */
@WebServlet("/CollectListServlet")
public class CollectListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //查询出来所有的收藏
            ArticleService service = new ArticleServiceImpl();
            List<Article> list = service.findAll();

            //把数据存储到作用域中
            request.setAttribute("list", list);

            //跳转页面
            request.getRequestDispatcher("collect.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
