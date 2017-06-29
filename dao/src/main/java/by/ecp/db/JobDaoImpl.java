package by.ecp.db;

import by.ecp.common.BaseDaoImpl;
import by.ecp.entity.*;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by SystemUser on 28.06.2017.
 */
@Repository
public class JobDaoImpl extends BaseDaoImpl<Job> implements JobDao {

    @Override
    public void save(
            String nameUser,
            String familyUser,
            String eMailUser,
            Gender gender,
            English english,
            String comment,
            Long vacancyId) {
        Session session = getSessionFactory().getCurrentSession();
        Vacancy vacancy =  new Vacancy();
        vacancy.setId(vacancyId);

        Job job = new Job();
        job.setNameUser(nameUser);
        job.setFamilyUser(familyUser);
        job.setEmail(eMailUser);
        job.setGender(gender);
        job.setEnglish(english);
        job.setComment(comment);
        job.setVacancy(vacancy);
        session.save(job);
    }
}
