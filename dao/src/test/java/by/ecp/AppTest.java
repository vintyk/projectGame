package by.ecp;

import entity.Message;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.*;

/**
 * Unit test for simple App.
 */
public class AppTest  {

  private  static SessionFactory SESSION_FACTORY;

  @BeforeClass
  public   static void init(){
  SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
}
  @Test
  public void testSaveMessage(){
    Session session = SESSION_FACTORY.openSession();

    Message message = new Message();
    message.setName("Maxxx");
    Long id = (Long) session.save(message);

    Message savedMessage = session.find(Message.class, id);
    Assert.assertEquals(savedMessage.getName(), "Maxxx");
    session.close();
  }
  @AfterClass
  public static void finish(){
    SESSION_FACTORY.close();
  }
}
