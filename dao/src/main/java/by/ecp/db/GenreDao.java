package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.Genre;

/**
 * Created by Vinty on 06.06.2017.
 */
public class GenreDao extends BaseDao<Genre> {
    public GenreDao() {
        super(Genre.class);
    }
}
