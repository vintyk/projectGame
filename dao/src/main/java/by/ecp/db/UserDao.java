package by.ecp.db;

import by.ecp.entity.Gender;
import by.ecp.entity.Privilege;
import by.ecp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by User on 02.06.2017.
 */
public class UserDao {
    private static final Object LOCK = new Object();
    private static UserDao INSTANCE = null;

    public static UserDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDao();
                }
            }
        }
        return INSTANCE;
    }

    public void saveUser(String userName,
                         Long privilege_id,
                         String family,
                         String eMail,
                         Gender gender,
                         String pass) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Privilege privilege = new Privilege();
        privilege.setId(privilege_id);

        User user = new User();
        user.setNameUser(userName);
        user.setPrivilege(privilege);
        user.setFamilyUser(family);
        user.setEMailUser(eMail);
        user.setGender(gender);
        user.setPasswordUser(pass);
        session.save(user);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
