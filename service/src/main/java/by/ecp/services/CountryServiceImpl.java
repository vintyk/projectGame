package by.ecp.services;

import by.ecp.db.CountryDao;
import by.ecp.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SystemUser on 20.06.2017.
 */
@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;

    @Autowired
    public CountryServiceImpl (CountryDao countryDao){
        this.countryDao = countryDao;
    }

    @Override
    public Long save(Country country) {
        countryDao.save(country);
        return country.getId();
    }

    @Override
    public Country findOne(Long id) {
        return countryDao.findOne(id);
    }

    @Override
    public List<Country> findAll() {
        return countryDao.findAll();
    }
}
