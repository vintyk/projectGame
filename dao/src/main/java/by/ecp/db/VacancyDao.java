package by.ecp.db;

import by.ecp.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by User on 02.06.2017.
 */
public class VacancyDao {
    private static final Object LOCK = new Object();
    private static VacancyDao INSTANCE = null;

    public static VacancyDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new VacancyDao();
                }
            }
        }
        return INSTANCE;
    }

    public void saveVacancy(String nameVacancy, Long companies_id, Session session) {
        Transaction transaction = session.beginTransaction();

        Company company = new Company();
        company.setId(companies_id);

        Vacancy vacancy = new Vacancy();
        vacancy.setNameVacancy(nameVacancy);
        vacancy.setCompany(company);
        session.save(vacancy);

        transaction.commit();
    }
}
