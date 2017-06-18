package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by User on 02.06.2017.
 */
public class VacancyDao extends BaseDao<Vacancy>{

    public VacancyDao() {
        super(Vacancy.class);
    }


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

    public List<Vacancy> findAll(Session session) {
        QVacancy vacancy = new QVacancy("myVacancy");
        JPAQuery<Vacancy> query = new JPAQuery<>(session);
        query.select(vacancy).from(vacancy);
        return query.fetchResults().getResults();
    }

    public Vacancy findByName(String name, Session session){
        session.beginTransaction();
        QVacancy vacancy = new QVacancy("myNewVacancy");
        JPAQuery<Vacancy> query = new JPAQuery<>(session);
        query.select(vacancy).from(vacancy).where(vacancy.nameVacancy.eq(name));
        Vacancy result = query.fetchOne();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
