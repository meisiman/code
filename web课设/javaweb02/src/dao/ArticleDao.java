package dao;

import domain.Article;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Mei Siman
 * @date 2019/11/26  19:59
 */
public interface ArticleDao {
    public List<Article> findArticle() throws SQLException;

    public List<Article> searchArticle(String title) throws SQLException;

    public void deleteArticle(int id) throws SQLException;

    public Article findOne(int id) throws SQLException;

    public void addArticle(Article article) throws SQLException;

    public void changeArticle(Article article) throws SQLException;

    public int countArticle() throws SQLException;

    public List<Article> findAll() throws SQLException;
}
