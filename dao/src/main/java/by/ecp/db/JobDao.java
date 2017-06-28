package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.Country;
import by.ecp.entity.English;
import by.ecp.entity.Gender;
import by.ecp.entity.Job;

/**
 * Created by User on 28.06.2017.
 */
public interface JobDao extends BaseDao<Job> {

    void save(
            String nameUser,
            String familyUser,
            String eMailUser,
            Gender gender,
            English english,
            String comment,
            Long vacancyId);
}
