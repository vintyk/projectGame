package by.ecp.entity.temp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
/**
 * Created by User on 25.05.2017.
 */
public class MyQueryUpdate {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("update Country set name = 'Беларусь' where id = 13");
//        query.setParameter("name", "Беларусь");
//        query.setParameter("id", "13");
        int result = query.executeUpdate();

        session.close();
        sessionFactory.close();
    }
}
