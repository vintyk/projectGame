package by.ecp.entity;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Vinty on 26.05.2017.
 */
public class PaintingTest {
    private  static SessionFactory SESSION_FACTORY;
    private static Logger LOGGER = Logger.getLogger(PaintingTest.class);

    @BeforeClass
    public   static void init(){
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }
    @Test
    public void testPainting() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        Painting painting = new Painting();
        painting.setName("Aid");
        painting.setAuthorName("Test777");
        Long id = (Long) session.save(painting);
        session.get(Painting.class, id);
        System.out.println(session.get(Painting.class, id));
        Assert.assertEquals(painting.getName(), "Aid");
        Assert.assertEquals(painting.getAuthorName(), "Test777");
        transaction.commit();
        session.close();
    }
    @Test
    public void testPaintingUpdate() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        Painting painting = new Painting();
        painting.setAuthorName("BUUU");
        painting.setName("Test222");
        System.out.println(painting.getId());
        Long idCol = painting.getId();
        session.saveOrUpdate(painting);
        session.get(Painting.class, painting.getId());
        System.out.println(painting.getId());
        Assert.assertNotEquals(painting.getId(), idCol.longValue());
        transaction.commit();
        session.close();
    }
    @AfterClass
    public static void finish(){
    SESSION_FACTORY.close();
    }
}