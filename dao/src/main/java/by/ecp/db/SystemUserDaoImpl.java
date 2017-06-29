package by.ecp.db;

import by.ecp.common.BaseDaoImpl;
import by.ecp.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by SystemUser on 02.06.2017.
 */
@Repository
public class SystemUserDaoImpl extends BaseDaoImpl<SystemUser> implements SystemUserDao {

    @Override
    public SystemUser findByEmail(String name){
        Session session = getSessionFactory().getCurrentSession();
        QSystemUser user = new QSystemUser("myNewUser");
        JPAQuery<SystemUser> query = new JPAQuery<>(session);
        query.select(user).from(user).where(user.email.eq(name));
        SystemUser result = query.fetchOne();
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

        SystemUser systemUser = new SystemUser();
        systemUser.setNameUser(nameUser);
        systemUser.setPrivilege(privilege);
        systemUser.setFamilyUser(family);
        systemUser.setEmail(eMail);
        systemUser.setGender(gender);
        systemUser.setPasswordUser(pass);
        session.save(systemUser);
    }
}
