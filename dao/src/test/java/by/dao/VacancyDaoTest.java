package by.dao;


import by.ecp.common.BaseDao;
import by.ecp.db.CompanyDao;
import by.ecp.db.VacancyDao;
import by.ecp.entity.Company;
import by.ecp.entity.Vacancy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

/**
 * Created by Vinty on 18.06.2017.
 */
public class VacancyDaoTest {

    @Test
    public void getByNameTest(){
        VacancyDao vacancyDao = new VacancyDao();
        CompanyDao companyDao = new CompanyDao();
        Vacancy vacancy = new Vacancy();
        Company company = new Company();
        company.setNameCompany("My-new-Company");
        companyDao.save(company);
        vacancy.setNameVacancy("vac");
        vacancy.setCompany(company);
        vacancyDao.save(vacancy);

        Vacancy result = vacancyDao.findByName("vac");
        System.out.println(result);
        assertEquals(vacancy.getNameVacancy(), "vac");
    }
}
