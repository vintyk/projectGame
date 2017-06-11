package by.ecp.common;

import by.ecp.entity.IdMotherClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Vinty on 09.06.2017.
 */
public class BaseDao<T> extends IdMotherClass {

    private static SessionFactory SESSION_FACTORY =
            new Configuration().configure().buildSessionFactory();

    private Class<T> entityClass;

    public BaseDao(Class<T> entityClass)
    {
        this.entityClass = entityClass;
    }

    public T findOne(Long id) {
        Session session = SESSION_FACTORY.openSession();
        T result = session.get(entityClass, id);
        session.close();
        return result;
    }
}
