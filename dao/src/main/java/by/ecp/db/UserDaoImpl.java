package by.ecp.db;

import by.ecp.common.BaseDaoImpl;
import by.ecp.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 02.06.2017.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

    @Override
    public User findByEmail(String name){
        Session session = getSessionFactory().getCurrentSession();
        QUser user = new QUser("myNewUser");
        JPAQuery<User> query = new JPAQuery<>(session);
        query.select(user).from(user).where(user.eMailUser.eq(name));
        User result = query.fetchOne();
        return result;
    }
    @Override
    public void saveUser(String nameUser,
                         String family,
                         String eMail,
                         String pass,
                         Gender gender,
                         Long privilegeId
                         ) {
        Session session = getSessionFactory().getCurrentSession();

        Privilege privilege = new Privilege();
        privilege.setId(privilegeId);

        User user = new User();
        user.setNameUser(nameUser);
        user.setPrivilege(privilege);
        user.setFamilyUser(family);
        user.setEMailUser(eMail);
        user.setGender(gender);
        user.setPasswordUser(pass);
        session.save(user);
    }
}
