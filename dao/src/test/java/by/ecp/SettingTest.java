package by.ecp;

import by.ecp.entity.Company;
import by.ecp.entity.QCompany;
import by.ecp.entity.QSetting;
import by.ecp.entity.Setting;
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
 * Created by Vinty on 11.06.2017.
 */
public class SettingTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }
    @Test
    public void testListSettingFromDaoQueryDSL() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Setting setting = new Setting();
        setting.setName("Фэнтези");
        session.save(setting);

        QSetting setting1 = new QSetting("mySetting");
        JPAQuery<Setting> query = new JPAQuery<>(session);
        query.select(setting1).from(setting1);
        System.out.println(query.fetchResults().getResults());
        assertThat(setting1, notNullValue());
        transaction.commit();
        session.close();
    }
    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
