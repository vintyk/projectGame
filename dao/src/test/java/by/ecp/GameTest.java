package by.ecp;

import by.ecp.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 05.06.2017.
 */
public class GameTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void getGameList() {
        Session session = SESSION_FACTORY.openSession();
        List<Game> resultSetGame = session.createQuery("from Game ", Game.class).getResultList();
        resultSetGame.forEach(System.out::println);
        session.close();
    }

    @Test
    public void addGamesToExistingPlatforms() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Company company = new Company();
        company.setNameCompany("Blizzzzz");
        session.save(company);
        Company company2 = session.get(Company.class, 1L);

        Genre genre = new Genre();
        genre.setName("MMORPG");
        session.save(genre);
        Genre genre2 = session.get(Genre.class, 1L);

        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setName("Бесплатная");
        session.save(paymentModel);
        PaymentModel paymentModel2 = session.get(PaymentModel.class, 1L);

        Setting setting = new Setting();
        setting.setName("Фэнтези");
        session.save(setting);
        Setting setting2 = session.get(Setting.class, 1L);

        Stage stage = new Stage();
        stage.setName("В разработке");
        session.save(stage);
        Stage stage2 = session.get(Stage.class, 1L);

        Platform platform1 = new Platform();
        platform1.setName("X-Box");
        session.save(platform1);
        Platform platform2 = new Platform();
        platform2.setName("PlayStation");
        session.save(platform2);
        Platform platform3 = new Platform();
        platform3.setName("PC");
        session.save(platform3);

        Platform platform4 = session.get(Platform.class, 1L);
        Platform platform5 = session.get(Platform.class, 2L);
        Platform platform6 = session.get(Platform.class, 3L);

        Game game = new Game();
        game.setNameGame("Эльфы на дереве");
        game.setCompany(company2);
        game.setGenre(genre2);
        game.setPaymentModel(paymentModel2);
        game.setSetting(setting2);
        game.setStage(stage2);
        game.getPlatforms().add(platform4);
        game.getPlatforms().add(platform5);
        game.getPlatforms().add(platform6);
        session.save(game);
        System.out.println("------------------------------------------------");
        System.out.println(game);
        System.out.println("------------------------------------------------");
        transaction.commit();
        session.close();
    }
    @Test
    public void saveGame() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Company company = new Company();
        company.setNameCompany("Blizzzzz");
        session.save(company);
        Company company2 = session.get(Company.class, 1L);

        Genre genre = new Genre();
        genre.setName("MMORPG");
        session.save(genre);
        Genre genre2 = session.get(Genre.class, 1L);

        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setName("Бесплатная");
        session.save(paymentModel);
        PaymentModel paymentModel2 = session.get(PaymentModel.class, 1L);

        Setting setting = new Setting();
        setting.setName("Фэнтези");
        session.save(setting);
        Setting setting2 = session.get(Setting.class, 1L);

        Stage stage = new Stage();
        stage.setName("В разработке");
        session.save(stage);
        Stage stage2 = session.get(Stage.class, 1L);

        Game game = new Game();
        game.setNameGame("Эльфы на дереве");
        game.setCompany(company2);
        game.setGenre(genre2);
        game.setPaymentModel(paymentModel2);
        game.setSetting(setting2);
        game.setStage(stage2);
        session.save(game);

        QGame game1 = new QGame("myGame");
        JPAQuery<Company> query = new JPAQuery<>(session);
        query.select(game1).from(game1);
        System.out.println(query.fetchResults().getResults());
        assertThat(game1, notNullValue());

        transaction.commit();
        session.close();
    }



    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
