package by.ecp.services;

import by.ecp.db.JobDao;
import by.ecp.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by SystemUser on 28.06.2017.
 */
@Service
@Transactional
public class JobServiceImpl implements JobService {

    private final JobDao jobDao;

    @Autowired
    public JobServiceImpl (JobDao jobDao){
        this.jobDao = jobDao;
    }

    @Override
    public void save(Job job) {
        jobDao.save(job);
    }
}
