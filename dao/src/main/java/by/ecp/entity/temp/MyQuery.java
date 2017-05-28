package by.ecp.entity.temp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by User on 25.05.2017.
 */
public class MyQuery {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("from Country where id = :id2");
        query.setParameter("id2", 4L);
        List list = query.list();
        list.forEach(System.out::println);

        Query query2 = session.createQuery("from Country where id > 2 ");
        List list2 =  query2.list();
        list2.forEach(System.out::println);

        session.close();
        sessionFactory.close();

    }

}
