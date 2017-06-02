package by.ecp.entity.temp;

import by.ecp.db.CountryDao;
import by.ecp.db.ToolsDataBase;
import by.ecp.db.UserDao;
import by.ecp.db.VacancyDao;
import by.ecp.entity.Country;
import by.ecp.entity.Gender;
import by.ecp.entity.Privilege;
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

//        UserDao.getInstance().saveUser("Vitaliy", 1L,"Ushakov", "vinty@i.ua", Gender.MALE, "12345");
//        VacancyDao.getInstance().saveVacancy("Financial Controller", 1L);
//        ToolsDataBase.getInstance().savePrivilege();

//        List<Country> list = CountryDao.getInstance().getCountryList();
//        list.forEach(System.out::println);

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

//        deleteById(Country.class, new Long(14));

    }
}
