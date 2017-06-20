package by.ecp.common;

/**
 * Created by Vinty on 20.06.2017.
 */
import by.ecp.entity.BaseEntity;
import java.util.List;

public interface BaseDao<T extends BaseEntity> {

    void save(T entity);

    void  delete(T entity);

    void update (T entity);

    List<T> findAll();

    T findOne(Long id);


}
