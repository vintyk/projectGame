package by.ecp.entity.temp;

import by.ecp.db.*;
import by.ecp.entity.Country;
import by.ecp.entity.Genre;
import by.ecp.entity.Platform;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Vinty on 24.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        List<Country> countries = CountryDao.getInstance().findAll(session);
        countries.forEach(System.out::println);


//        Set<Long> platformLongs = new HashSet<>();
//        platformLongs.add(1L);
//        platformLongs.add(2L);
//        GameDao.getInstance().saveGameToExistingPlatform(
//                "Герои адского пламени",
//                3L,
//                2L,
//                3L,
//                2L,
//                3L,
//                platformLongs);

        //        GameDao.getInstance().saveGame("Герои адского пламени", 3L, 2L, 3L, 2L, 3L);
//        UserDao.getInstance().saveUser("Vitaliy", 1L,"Ushakov", "vinty@i.ua", Gender.MALE, "12345");
//        VacancyDao.getInstance().saveVacancy("Financial Controller", 1L);
//        ToolsDataBase.getInstance().savePrivilege();


//           List<Genre> listGenre = GenreDao.getInstance().getGenreList();
//           listGenre.forEach(System.out::println);
//
//           List<Country> list = CountryDao.getInstance().getCountryList();
//           list.forEach(System.out::println);

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
