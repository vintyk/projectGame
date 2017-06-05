package by.ecp.db;

import by.ecp.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by User on 05.06.2017.
 */
public class GameDao {
    private static final Object LOCK = new Object();
    private static GameDao INSTANCE = null;

    public static GameDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new GameDao();
                }
            }
        }
        return INSTANCE;
    }

    public List<Game> getGameList() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<Game> resultSetGame = session.createQuery("from Game ", Game.class).getResultList();
        session.close();
        sessionFactory.close();
        return resultSetGame;
    }
    public void saveGame(String nameGame,
                         Long companyId,
                         Long genreId,
                         Long paymentModelId,
                         Long settingId,
                         Long stageId) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Company company = new Company();
        company.setId(companyId);

        Genre genre = new Genre();
        genre.setId(genreId);

        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setId(paymentModelId);

        Setting setting = new Setting();
        setting.setId(settingId);

        Stage stage = new Stage();
        stage.setId(stageId);

        Game game = new Game();
        game.setNameGame(nameGame);
        game.setCompany(company);
        game.setGenre(genre);
        game.setPaymentModel(paymentModel);
        game.setSetting(setting);
        game.setStage(stage);
        session.save(game);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
