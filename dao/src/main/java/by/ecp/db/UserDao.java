package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by User on 02.06.2017.
 */
public class UserDao extends BaseDao<User>{
    public UserDao() {
        super(User.class);
    }

    public User findByEmail(String name){
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        QUser user = new QUser("myNewUser");
        JPAQuery<User> query = new JPAQuery<>(session);
        query.select(user).from(user).where(user.eMailUser.eq(name));
        User result = query.fetchOne();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public void saveUser(String nameUser,
                         Long privilege_id,
                         String family,
                         String eMail,
                         Gender gender,
                         String pass
                         ) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Privilege privilege = new Privilege();
        privilege.setId(privilege_id);

        User user = new User();
        user.setNameUser(nameUser);
        user.setPrivilege(privilege);
        user.setFamilyUser(family);
        user.setEMailUser(eMail);
        user.setGender(gender);
        user.setPasswordUser(pass);
        session.save(user);

        transaction.commit();
    }
}
