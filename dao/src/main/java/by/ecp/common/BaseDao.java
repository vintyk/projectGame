package by.ecp.common;

import by.ecp.entity.IdMotherClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Vinty on 09.06.2017.
 */
public class BaseDao<T> extends IdMotherClass {

    protected static SessionFactory SESSION_FACTORY =
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
    public List<T> findAll() {
        Session session = SESSION_FACTORY.openSession();
        return session.createQuery("FROM " + entityClass.getSimpleName(), entityClass).list();
    }
    public void  save(T o){
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }
    public void  delete(T o){
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }
    public void update (T entity) {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        session.update(entityClass.getSimpleName(), entity);
        session.getTransaction().commit();
        session.close();
    }
}
