package by.ecp.entity.temp;

import by.ecp.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Vinty on 24.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("application_content.xml");
//        Vacancy vacancy = context.getBean(Vacancy.class);
//        User user  = context.getBean(User.class);
//        Game game = context.getBean(Game.class);
//        GameAdditionGoods gameAdditionGoods = context.getBean(GameAdditionGoods.class);
//        System.out.println(vacancy.toString());
//        System.out.println(user.toString());
//        System.out.println(game.toString());
//        System.out.println(gameAdditionGoods);
        session.close();
        sessionFactory.close();
    }
}

//        CountryDaoImpl countryDao = new CountryDaoImpl();
//        Country country = countryDao.findOne(25L);
//        System.out.println(country);
//        session.close();
//        sessionFactory.close();

//        CountryDaoImpl countryDao = new CountryDaoImpl();
//        Country country = new Country();
//        country.setName("ghjcghjc");
//        countryDao.save(country);
//        session.close();


//        CountryDaoImpl countryDao1 = new CountryDaoImpl();
//        List<Country> country1 = countryDao1.findAll();
//        country1.forEach(System.out::println);



//        CountryDaoImpl countryDao1 = new CountryDaoImpl();
//        Country country1 = countryDao1.delete(25L);

//        CountryDaoImpl countryDao1 = new CountryDaoImpl();
//        Country country1 = countryDao1.findAll();
//        System.out.println(country1);
//        session.close();
//        sessionFactory.close();

//          List<Country> countries2 = CountryDaoImpl.getInstance().getCountryList(session);
//        countries2.forEach(System.out::println);
//        List<Country> countries = CountryDaoImpl.getInstance().findAll(session);
//        countries.forEach(System.out::println);


//        Set<Long> platformLongs = new HashSet<>();
//        platformLongs.add(1L);
//        platformLongs.add(2L);
//        GameDaoImpl.getInstance().saveGameToExistingPlatform(
//                "Герои адского пламени",
//                3L,
//                2L,
//                3L,
//                2L,
//                3L,
//                platformLongs);

        //        GameDaoImpl.getInstance().saveGame("Герои адского пламени", 3L, 2L, 3L, 2L, 3L);
//        UserDaoImpl.getInstance().saveUser("Vitaliy", 1L,"Ushakov", "vinty@i.ua", Gender.MALE, "12345");
//        VacancyDaoImpl.getInstance().saveVacancy("Financial Controller", 1L);
//        ToolsDataBase.getInstance().savePrivilege();


//           List<Genre> listGenre = GenreDaoImpl.getInstance().getGenreList();
//           listGenre.forEach(System.out::println);
//
//           List<Country> list = CountryDaoImpl.getInstance().getCountryList();
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



