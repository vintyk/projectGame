package by.ecp.services;

import by.ecp.db.VacancyDao;
import by.ecp.entity.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SystemUser on 28.06.2017.
 */
@Service
@Transactional
public class VacancyServiceImpl implements VacancyService {

    private final VacancyDao vacancyDao;

    @Autowired
    public VacancyServiceImpl(VacancyDao vacancyDao) {
        this.vacancyDao = vacancyDao;
    }
    @Override
    public List<Vacancy> findAll() {
        return vacancyDao.findAll();
    }

    @Override
    public Vacancy findOne(Long id) {
        return vacancyDao.findOne(id);
    }
}
