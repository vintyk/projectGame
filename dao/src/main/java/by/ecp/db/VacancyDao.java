package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.*;

/**
 * Created by User on 02.06.2017.
 */
public class VacancyDao extends BaseDao<Vacancy>{

    public VacancyDao() {
        super(Vacancy.class);
    }
//
//
//    private static final Object LOCK = new Object();
//    private static VacancyDao INSTANCE = null;
//
//    public static VacancyDao getInstance() {
//        if (INSTANCE == null) {
//            synchronized (LOCK) {
//                if (INSTANCE == null) {
//                    INSTANCE = new VacancyDao();
//                }
//            }
//        }
//        return INSTANCE;
//    }
//
//    public void saveVacancy(String nameVacancy, Long companies_id, Session session) {
//        Transaction transaction = session.beginTransaction();
//
//        Company company = new Company();
//        company.setId(companies_id);
//
//        Vacancy vacancy = new Vacancy();
//        vacancy.setNameVacancy(nameVacancy);
//        vacancy.setCompany(company);
//        session.save(vacancy);
//
//        transaction.commit();
//    }
}
