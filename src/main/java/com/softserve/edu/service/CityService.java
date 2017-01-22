package com.softserve.edu.service;

import java.util.List;

import com.softserve.edu.dao.DaoFactory;
import com.softserve.edu.entity.City;

public class CityService {

    public void addCity(City city) {
        DaoFactory.getInstance().getCityDao().add(city);
    }

    public void updateCity(City city) {
        DaoFactory.getInstance().getCityDao().update(city);
    }

    public City getCityById(Integer id) {
        return DaoFactory.getInstance().getCityDao().getById(id);
    }

    public List<City> getAllCities() {
        return DaoFactory.getInstance().getCityDao().getAllElements();
    }

    public void deleteCity(City city) {
        DaoFactory.getInstance().getCityDao().delete(city);
    }

}
