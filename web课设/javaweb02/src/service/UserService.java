package service;

import domain.User;

import java.sql.SQLException;

/**
 * @author Mei Siman
 * @date 2019/12/13  20:43
 */
public interface UserService {
    public void addUser(User user) throws SQLException;

    public User login(String username, String password) throws SQLException;
}
