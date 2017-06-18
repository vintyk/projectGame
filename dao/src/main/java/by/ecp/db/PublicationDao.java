package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by User on 09.06.2017.
 */
public class PublicationDao extends BaseDao<Publication>{
    public PublicationDao() {
        super(Publication.class);
    }
    public void savePublication(
            String namePublication,
            String textPublication,
            Long gameId,
            LocalDate datePublication) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Game game = new Game();
        game.setId(gameId);

        Publication publication = new Publication();
        publication.setNamePublication(namePublication);
        publication.setText(textPublication);
        publication.setDatePublication(datePublication);
        publication.setGame(game);
        session.save(publication);
        transaction.commit();
        session.close();
    }
        public List<Publication> findAllOrderDateDesc() {
            Session session = SESSION_FACTORY.openSession();
            QPublication publication = new QPublication("myPublication");
            JPAQuery<Publication> query = new JPAQuery<>(session);
            query.select(publication).from(publication).orderBy(publication.datePublication.desc());
            return query.fetchResults().getResults();
        }
}
