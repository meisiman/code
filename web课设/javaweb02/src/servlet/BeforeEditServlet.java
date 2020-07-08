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
 * @date 2019/12/11  19:56
 */
@WebServlet("/BeforeEditServlet")
public class BeforeEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //获取客户端提交上来的数据
            int id = Integer.parseInt(request.getParameter("id"));

            //查找文章
            ArticleService service = new ArticleServiceImpl();
            Article article = service.findOne(id);

            //存数据
            request.setAttribute("article", article);

            //跳转界面
            request.getRequestDispatcher("edit.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
