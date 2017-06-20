package by.dao;

import by.ecp.common.BaseDaoImpl;
import by.ecp.db.CompanyDaoImpl;
import by.ecp.entity.Company;

/**
 * Created by Vinty on 11.06.2017.
 */
public class CompanyDaoTest extends BaseDaoTest<Company>{

    private BaseDaoImpl<Company> dao = new CompanyDaoImpl();

    @Override
    protected BaseDaoImpl<Company> getDao() {
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
