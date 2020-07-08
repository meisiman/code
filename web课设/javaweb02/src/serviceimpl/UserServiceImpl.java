package serviceimpl;

import dao.UserDao;
import daoimpl.UserDaoImpl;
import domain.User;
import service.UserService;

import java.sql.SQLException;

/**
 * @author Mei Siman
 * @date 2019/12/13  20:43
 */
public class UserServiceImpl implements UserService {
    public void addUser(User user) throws SQLException {
        UserDao dao = new UserDaoImpl();
        dao.addUser(user);
    }

    public User login(String username, String password) throws SQLException {

        UserDao dao = new UserDaoImpl();
        User user = dao.findUser(username, password);

        if(user != null) {
            return user;
        }
        return null;
    }
}
