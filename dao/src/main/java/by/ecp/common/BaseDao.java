package by.ecp.common;

import by.ecp.entity.IdMotherClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

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
    public void delete(Long id) {
        Session session = SESSION_FACTORY.openSession();
        T entityClass = findOne(id);
        session.delete(entityClass);
        session.close();
    }
    public List<T> findAll() {
        Session session = SESSION_FACTORY.openSession();
        return session.createQuery("FROM " + entityClass.getSimpleName(), entityClass).list();
    }
    public void save(T o){
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(o);
        transaction.commit();
        session.close();
    }

//    public void addEntity(T t) {
//        Session session = SESSION_FACTORY.openSession();
//        session.persist(entityClass);
//    }


}
