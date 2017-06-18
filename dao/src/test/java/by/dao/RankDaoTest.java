package by.dao;

import by.ecp.common.BaseDao;
import by.ecp.db.RankDao;
import by.ecp.entity.Rank;
import org.hibernate.SessionFactory;

/**
 * Created by User on 16.06.2017.
 */
public class RankDaoTest extends BaseDaoTest<Rank> {

    private BaseDao<Rank> dao = new RankDao();

    @Override
    protected BaseDao<Rank> getDao() {
        return dao;
    }
    @Override
    protected Rank getModel() {
        return new Rank();
    }
}
