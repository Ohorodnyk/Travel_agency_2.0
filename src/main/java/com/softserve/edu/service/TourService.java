package com.softserve.edu.service;

import java.util.List;

import com.softserve.edu.dao.DaoFactory;
import com.softserve.edu.entity.Tour;

public class TourService {

    public void addTour(Tour tour) {
        DaoFactory.getInstance().getTourDao().add(tour);
    }

    public void updateTour(Tour tour) {
        DaoFactory.getInstance().getTourDao().update(tour);
    }

    public Tour getTourById(Integer id) {
        return DaoFactory.getInstance().getTourDao().getById(id);
    }

    public List<Tour> getAllTours() {
        return DaoFactory.getInstance().getTourDao().getAllElements();
    }

    public void deleteTour(Tour tour) {
        DaoFactory.getInstance().getTourDao().delete(tour);
    }

}





