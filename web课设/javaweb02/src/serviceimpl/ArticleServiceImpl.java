package serviceimpl;

import dao.ArticleDao;
import daoimpl.ArticleDaoImpl;
import domain.Article;
import service.ArticleService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Mei Siman
 * @date 2019/11/27  16:39
 */
public class ArticleServiceImpl implements ArticleService {
    public List<Article> findArticle() throws SQLException {
        ArticleDao dao = new ArticleDaoImpl();
        return dao.findArticle();
    }

    public List<Article> searchArticle(String title) throws SQLException {
        ArticleDao dao = new ArticleDaoImpl();
        return dao.searchArticle(title);
    }

    public void deleteArticle(int id) throws SQLException {
        ArticleDao dao = new ArticleDaoImpl();
        dao.deleteArticle(id);
    }

    public Article findOne(int id) throws SQLException {
        ArticleDao dao = new ArticleDaoImpl();
        return dao.findOne(id);
    }

    public void addArticle(Article article) throws SQLException {
        ArticleDao dao = new ArticleDaoImpl();
        dao.addArticle(article);
    }

    public void changeArticle(Article article) throws SQLException {
        ArticleDao dao = new ArticleDaoImpl();
        dao.changeArticle(article);
    }

    public int countArticle() throws SQLException {
        ArticleDao dao = new ArticleDaoImpl();
        return dao.countArticle();
    }

    public List<Article> findAll() throws SQLException {
        ArticleDao dao = new ArticleDaoImpl();
        return dao.findAll();
    }
}
