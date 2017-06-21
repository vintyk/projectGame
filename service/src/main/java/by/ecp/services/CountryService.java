package by.ecp.services;

import by.ecp.entity.Country;

import java.util.List;

/**
 * Created by User on 20.06.2017.
 */
public interface CountryService  {

    void save(Country country);

    Country findOne(Long id);

    List<Country> findAll();
}
