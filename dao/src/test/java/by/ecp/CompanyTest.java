package by.ecp;

import by.ecp.common.BaseDaoImpl;
import by.ecp.db.CompanyDao;
import by.ecp.db.CountryDao;
import by.ecp.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 05.06.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:application_content.xml"})
@Transactional
public class CompanyTest extends BaseDaoImpl<Company> implements CompanyDao {

    @Autowired
    private CountryDao countryDao;

    @BeforeClass
    public static void init() {
    }

    @Test
    public void testListCompanyFromDaoQueryDSL() {
        Session session = getSessionFactory().getCurrentSession();

        Company company = new Company();
        company.setNameCompany("Wargaming");
        session.save(company);

        QCompany company1 = new QCompany("myCompany");
        JPAQuery<Company> query = new JPAQuery<>(session);
        query.select(company1).from(company1);
        System.out.println(query.fetchResults().getResults());
        assertThat(company1, notNullValue());
    }

    @AfterClass
    public static void finish() {
    }
}
