package by.ecp;

import by.ecp.db.CountryDao;
import by.ecp.db.PublicationDao;
import by.ecp.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 09.06.2017.
 */
public class PublicationTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testListPublicationFromDao() {
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

        Publication publication = new Publication();
        publication.setNamePublication("Это же звиздец, дорогая редакция!");
        publication.setText("Это долгая история. О том как один геймер бла бла бла бла бла бла бла" +
                "но не как в прошлый бла бла бла бла бла. Итог очевиден и предсказуем. БЛА!!!");
        publication.setGame(game);
        session.save(publication);

        Publication publication2 = new Publication();
        publication2.setNamePublication("Встречаем!");
        publication2.setText("Вы охренеете-2 !!!. БЛА!!! Бла и немного Бла-бла-бла!!!");
        publication2.setGame(game);
        session.save(publication2);

        List<Publication> publicationList = PublicationDao.getInstance().findAll(session);
        assertThat(publicationList, hasSize(2));
        List<String> namesInBD = publicationList
                .stream()
                .map(Publication::getNamePublication)
                .collect(toList());
        assertThat(namesInBD, containsInAnyOrder("Это же звиздец, дорогая редакция!", "Встречаем!"));
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }

}
