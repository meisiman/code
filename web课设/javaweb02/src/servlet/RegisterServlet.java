package servlet;

import domain.User;
import service.UserService;
import serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mei Siman
 * @date 2019/12/13  20:59
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //获取客户端提交上来的数据
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            //判断用户是否被注册过
            UserService service = new UserServiceImpl();
            User user1 = service.login(username, password);
            if (user1 == null) {
                //添加到数据库
                User user = new User(username, password);
                service.addUser(user);
            }

            //跳转到登录界面
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
