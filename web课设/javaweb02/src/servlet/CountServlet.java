package servlet;

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
 * @date 2019/12/11  20:09
 */
@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //得到文章总数
            ArticleService service = new ArticleServiceImpl();
            int number = service.countArticle();

            //把数据存储到作用域中
            request.setAttribute("number", number);

            //跳转页面
            request.getRequestDispatcher("home.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
