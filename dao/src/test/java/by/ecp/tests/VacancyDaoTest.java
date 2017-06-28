package by.ecp.tests;


import by.ecp.common.BaseDaoImpl;
import by.ecp.db.CompanyDao;
import by.ecp.db.VacancyDao;
import by.ecp.entity.Company;
import by.ecp.entity.Vacancy;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

/**
 * Created by Vinty on 18.06.2017.
 */
public class VacancyDaoTest extends BaseTest{
    @Autowired
    private VacancyDao vacancyDao;
    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testFindByName(){
        Company company = new Company();
        company.setName("My-new-Company");
        companyDao.save(company);

        Vacancy vacancy = new Vacancy();
        vacancy.setNameVacancy("vac");
        vacancy.setCompany(company);
        vacancyDao.save(vacancy);

        Vacancy result = vacancyDao.findByName("vac");
        System.out.println(result);
        assertEquals(vacancy.getNameVacancy(), "vac");
    }
}
