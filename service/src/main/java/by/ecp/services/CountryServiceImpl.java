package by.ecp.services;

import by.ecp.db.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by User on 20.06.2017.
 */
@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;

    @Autowired
    public CountryServiceImpl (CountryDao countryDao){
        this.countryDao = countryDao;
    }
}
