package by.ecp;

import by.ecp.db.ToolsDataBase;
import by.ecp.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.io.Serializable;
import java.util.List;


/**
 * Created by Vinty on 24.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

//        Country country = new Country();
//        country.setName("Нет такой страны");
//        session.saveOrUpdate(country);

//        Country retriveCountry = session.find(Country.class, 1L);
//        System.out.println(retriveCountry);


//        Transaction transaction = session.beginTransaction();
//        try {
//            Country country = new Country();
//            country.setId(9);
//            session.delete(country);
//
//            transaction.commit();
//        }catch (Throwable throwable){
//            transaction.rollback();
//            throw throwable;
//        }

//        Transaction transaction = session.beginTransaction();
//        try{
//            MyQuery query = session.createQuery("delete from Country where id > :id_country");
//            query.setParameter("id_country",  new Long(9L));
//            int result = query.executeUpdate();
//
//            transaction.commit();
//    }catch (Throwable throwable){
//        transaction.rollback();
//        throw throwable;
//    }
//        boolean result = deleteById(Country.class, new Long(13));

        deleteById(Country.class, new Long(14));

        List<Country> resultSetCountry = session.createQuery("from Country", Country.class).getResultList();
        resultSetCountry.forEach(System.out::println);
        session.close();
        sessionFactory.close();
    }
    private static boolean deleteById(Class<?> type, Serializable id) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Object persistentInstance = session.load(type, id);
            if (persistentInstance != null) {
                session.delete(persistentInstance);
                transaction.commit();
                return true;
            } else {
                return false;
            }
            } catch (Throwable throwable) {
            transaction.rollback();
            System.out.println("Не вернулось ни одной строки с Id= "+ id);
            throw throwable;
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
