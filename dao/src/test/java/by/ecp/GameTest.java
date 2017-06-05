package by.ecp;

import by.ecp.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

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
        System.out.println("------------------------------------------------");
        System.out.println(game);
        System.out.println("------------------------------------------------");
        System.out.println(company2);
        System.out.println(genre2);
        System.out.println(paymentModel2);
        System.out.println(setting2);
        System.out.println(stage2);
        transaction.commit();
        session.close();
    }
    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
