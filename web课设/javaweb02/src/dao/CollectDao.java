package dao;

import domain.Collect;

import java.sql.SQLException;

/**
 * @author Mei Siman
 * @date 2019/12/13  21:10
 */
public interface CollectDao {
    public void collectArticle(Collect collect) throws SQLException;

    public void deleteCollect(int id) throws SQLException;

    public Collect findCollect(int articleId, int userId) throws SQLException;
}
