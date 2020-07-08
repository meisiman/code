package serviceimpl;

import dao.CollectDao;
import daoimpl.CollectDaoImpl;
import domain.Collect;
import service.CollectService;

import java.sql.SQLException;

/**
 * @author Mei Siman
 * @date 2019/12/13  21:11
 */
public class CollectServiceImpl implements CollectService {
    public void collectArticle(Collect collect) throws SQLException {
        CollectDao dao = new CollectDaoImpl();
        dao.collectArticle(collect);
    }

    public void deleteCollect(int id) throws SQLException {
        CollectDao dao = new CollectDaoImpl();
        dao.deleteCollect(id);
    }

    public Collect findCollect(int articleId, int userId) throws SQLException {
        CollectDao dao = new CollectDaoImpl();
        Collect collect = dao.findCollect(articleId, userId);
        if (collect!=null){
            return collect;
        }
        return null;
    }
}
