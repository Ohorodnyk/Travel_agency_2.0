package com.softserve.edu.service;

import java.util.List;
import java.util.Set;

import com.softserve.edu.dao.DaoFactory;
import com.softserve.edu.entity.Visa;

public class VisaService {

    public void addVisa(Visa visa) {
        DaoFactory.getInstance().getVisaDao().add(visa);
    }

    public void updateVisa(Visa visa) {
        DaoFactory.getInstance().getVisaDao().update(visa);
    }

    public Visa getVisaById(Integer id) {
        return DaoFactory.getInstance().getVisaDao().getById(id);
    }

    public List<Visa> getAllVisas() {
        return DaoFactory.getInstance().getVisaDao().getAllElements();
    }

    public void deleteVisa(Visa visa) {
        DaoFactory.getInstance().getVisaDao().delete(visa);
    }

    public Set<Visa> findVisas(String firstName, String lastName) {
        return DaoFactory.getInstance().getVisaDao().findVisas(firstName, lastName);
    }

    public int countOfVisas(String country) {
        return DaoFactory.getInstance().getVisaDao().countOfVisas(country);
    }

    public List<Visa> findValidVisas(String firstName, String lastName, String country) {
        return DaoFactory.getInstance().getVisaDao().findValidVisas(firstName, lastName, country);
    }

}
