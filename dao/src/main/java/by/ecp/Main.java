package by.ecp;

import entity.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Vinty on 24.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Message message = new Message();
        message.setName("Vitaly");
        session.saveOrUpdate(message);

        Message retrievedMessage = session.find(Message.class, 1L);
        System.out.println(retrievedMessage);

        List<Message> resultSet = session.createQuery("from Message", Message.class).getResultList();
        resultSet.forEach(System.out::println);
        session.close();
        sessionFactory.close();
    }
}
