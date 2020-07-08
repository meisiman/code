package servlet;

import domain.Collect;
import domain.User;
import service.CollectService;
import serviceimpl.CollectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Mei Siman
 * @date 2019/12/15  11:04
 */
@WebServlet("/CollectServlet")
public class CollectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //获取id
            int id = Integer.parseInt(request.getParameter("id"));

            //得到当前用户
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            //去数据库查询该文章是否被收藏
            CollectService service = new CollectServiceImpl();
            Collect collect1 = service.findCollect(id, user.getUserId());

            if (collect1==null) {
                //添加到数据库
                Collect collect = new Collect(id, user.getUserId());
                service.collectArticle(collect);
            }
            //跳转页面
            request.getRequestDispatcher("ArticleServlet").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
