package dao;

import domain.User;

import java.sql.SQLException;

/**
 * @author Mei Siman
 * @date 2019/12/13  20:42
 */
public interface UserDao {
    public void addUser(User user) throws SQLException;

    public User findUser(String username,String password) throws SQLException;
}
