package by.ecp.entity.temp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by User on 25.05.2017.
 */
public class MyQuery {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Session session2 = sessionFactory.openSession();
        Transaction transaction2 = session2.beginTransaction();


//        Test001 test1 = new Test001();
//        test1.setName("aaa");
//        session.save(test1);
//        transaction.commit();
//        session.close();
//
//        Test001 test2 = new Test001();
//        test2.setName("bbb");
//        session2.save(test2);
//        transaction2.commit();
//        session2.close();


//        Query query = session.createQuery("from Country where id = :id2");
//        query.setParameter("id2", 4L);
//        List list = query.list();
//        list.forEach(System.out::println);
//
//        Query query2 = session.createQuery("from Country where id > 2 ");
//        List list2 =  query2.list();
//        list2.forEach(System.out::println);
//
//        session.close();
        sessionFactory.close();

    }

}
