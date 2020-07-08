package servlet;

import service.CollectService;
import serviceimpl.CollectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mei Siman
 * @date 2019/12/15  11:27
 */
@WebServlet("/DeleteCollectServlet")
public class DeleteCollectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //获取id
            int id = Integer.parseInt(request.getParameter("id"));

            //执行删除
            CollectService service = new CollectServiceImpl();
            service.deleteCollect(id);

            //跳转到列表页
            request.getRequestDispatcher("CollectListServlet").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
