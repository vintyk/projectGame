package by.dao;

import by.ecp.common.BaseDaoImpl;
import by.ecp.db.RankDaoImpl;
import by.ecp.entity.Rank;

/**
 * Created by User on 16.06.2017.
 */
public class RankDaoTest extends BaseDaoTest<Rank> {

    private BaseDaoImpl<Rank> dao = new RankDaoImpl();

    @Override
    protected BaseDaoImpl<Rank> getDao() {
        return dao;
    }
    @Override
    protected Rank getModel() {
        return new Rank();
    }
}
