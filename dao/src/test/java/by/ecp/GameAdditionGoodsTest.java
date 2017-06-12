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

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 12.06.2017.
 */
public class GameAdditionGoodsTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void saveGameAdditionalGoods() {
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

        GameAdditionGoods gameAdditionGoods = new GameAdditionGoods();
        gameAdditionGoods.setNameGame("Волчонок");
        gameAdditionGoods.setCompany(company2);
        gameAdditionGoods.setGenre(genre2);
        gameAdditionGoods.setPaymentModel(paymentModel2);
        gameAdditionGoods.setSetting(setting2);
        gameAdditionGoods.setStage(stage2);

        gameAdditionGoods.setNameGoods("Майка с логотипом волка");
        session.save(gameAdditionGoods);

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
