package daoimpl;

import dao.ArticleDao;
import domain.Article;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JDBCUtil;
import util.TextUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Mei Siman
 * @date 2019/11/26  20:00
 */
public class ArticleDaoImpl implements ArticleDao {
    public List<Article> findArticle() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from article";
        return runner.query(sql, new BeanListHandler<Article>(Article.class));
    }

    public List<Article> searchArticle(String title) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from article where 1=1";
        List<String> list = new ArrayList<String>();

        //判断有没有标题，如果有就组拼到sql语句里面
        if(!TextUtils.isEmpty(title)) {
            sql = sql + " and title like ?";
            list.add("%" + title + "%");
        }
        return runner.query(sql, new BeanListHandler<Article>(Article.class),list.toArray());
    }

    public void deleteArticle(int id) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "delete from article where id =?";
        runner.update(sql,id);
    }

    public Article findOne(int id) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from article where id =?";
        return runner.query(sql, new BeanHandler<Article>(Article.class),id);
    }

    public void addArticle(Article article) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "insert into article values(null,?,?,?)";
        runner.update(sql,article.getTitle(),article.getAuthor(),article.getContext());
    }

    public void changeArticle(Article article) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        runner.update("update article set title=?,author=?,context=? where id=?",
                article.getTitle(),
                article.getAuthor(),
                article.getContext(),
                article.getId());
    }

    public int countArticle() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select count(*) from article";
        Long result = (Long) runner.query(sql, new ScalarHandler());
        return result.intValue();
    }

    public List<Article> findAll() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select article.id,article.title,article.author,article.context from article,collect where collect.articleId = article.id";
        return runner.query(sql, new BeanListHandler<Article>(Article.class));
    }
}
