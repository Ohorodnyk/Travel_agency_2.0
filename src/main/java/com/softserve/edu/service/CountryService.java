package com.softserve.edu.service;

import java.util.List;

import com.softserve.edu.dao.DaoFactory;
import com.softserve.edu.entity.Country;

public class CountryService {

    public void addCountry(Country country) {
        DaoFactory.getInstance().getCountryDao().add(country);
    }

    public void updateCountry(Country country) {
        DaoFactory.getInstance().getCountryDao().update(country);
    }

    public Country getCountryById(Integer id) {
        return DaoFactory.getInstance().getCountryDao().getById(id);
    }

    public List<Country> getAllCountries() {
        return DaoFactory.getInstance().getCountryDao().getAllElements();
    }

    public void deleteCountry(Country country) {
        DaoFactory.getInstance().getCountryDao().delete(country);
    }
    
    public List<Country> findVisitedCountries(String firstName, String lastName) {
        return DaoFactory.getInstance().getCountryDao().findVisitedCountries(firstName, lastName);
    }

}




