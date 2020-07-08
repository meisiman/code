package daoimpl;

import dao.CollectDao;
import domain.Collect;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.JDBCUtil;

import java.sql.SQLException;

/**
 * @author Mei Siman
 * @date 2019/12/13  21:11
 */
public class CollectDaoImpl implements CollectDao {

    public void collectArticle(Collect collect) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "insert into collect values(?,?)";
        runner.update(sql, collect.getArticleId(),collect.getUserId());
    }

    public void deleteCollect(int id) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "delete from collect where articleId=?";
        runner.update(sql,id);
    }

    public Collect findCollect(int articleId, int userId) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from collect where articleId=? and userId=?";
        return runner.query(sql, new BeanHandler<Collect>(Collect.class),articleId,userId);
    }
}
