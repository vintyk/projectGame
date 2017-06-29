package by.ecp.services;

import by.ecp.entity.Country;

import java.util.List;

/**
 * Created by SystemUser on 20.06.2017.
 */
public interface CountryService  {

    Long save(Country country);

    Country findOne(Long id);

    List<Country> findAll();
}
