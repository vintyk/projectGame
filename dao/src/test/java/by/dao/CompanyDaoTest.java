package by.dao;

import by.ecp.common.BaseDao;
import by.ecp.db.CompanyDao;
import by.ecp.entity.Company;
import org.hibernate.SessionFactory;

/**
 * Created by Vinty on 11.06.2017.
 */
public class CompanyDaoTest extends BaseDaoTest<Company>{

    private static SessionFactory SESSION_FACTORY;
    private BaseDao<Company> dao = new CompanyDao();

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
//        CompanyDao companyDao = new CompanyDao();
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
