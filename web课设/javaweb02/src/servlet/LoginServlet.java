package servlet;

import domain.User;
import service.UserService;
import serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Mei Siman
 * @date 2019/12/14  20:02
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            UserService service = new UserServiceImpl();
            User user = service.login(username, password);

            //创建session对象
            HttpSession session = request.getSession();
            //把用户数据保存在session域对象中
            //session.setAttribute("user", user);

            if (user != null) {
                request.getSession().setAttribute("user", user);
                //跳转界面
                request.getRequestDispatcher("ArticleServlet").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
