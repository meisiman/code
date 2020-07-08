package daoimpl;

import dao.UserDao;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.JDBCUtil;

import java.sql.SQLException;

/**
 * @author Mei Siman
 * @date 2019/12/13  20:43
 */
public class UserDaoImpl implements UserDao {
    public void addUser(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        runner.update("insert into user values(null,?,?)",
                user.getUsername(),
                user.getPassword()
        );
    }

    public User findUser(String username,String password) throws SQLException {
        //得到连接对象
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());

        String sql = "select * from user where username=? and password=?";
        return runner.query(sql, new BeanHandler<User>(User.class),username,password);

    }
}
