package by.dao;

import by.ecp.common.BaseDao;
import by.ecp.common.BaseDaoImpl;
import by.ecp.db.CompanyDaoImpl;
import by.ecp.entity.Company;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vinty on 11.06.2017.
 */
public class CompanyDaoTest extends BaseDaoTest<Company>{

    @Autowired
    private BaseDao<Company> dao = new CompanyDaoImpl();

    @Override
    protected BaseDao<Company> getDao() {
        return dao;
    }

    @Override
    protected Company getModel() {
        return new Company();
    }
//    @BeforeClass
//    public static void init() {
//        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
//    }
//
//    @Test
//    public void testGetCompany() {
//        Session session = SESSION_FACTORY.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        Company company = new Company();
//        company.setNameCompany("США");
//        session.save(company);
//
//        CompanyDaoImpl companyDao = new CompanyDaoImpl();
//        Company company1 = companyDao.findOne(1L);
//        assertThat(company1, notNullValue());
//        transaction.commit();
//        session.close();
//    }
//    @AfterClass
//    public static void finish() {
//        SESSION_FACTORY.close();
//    }
}
