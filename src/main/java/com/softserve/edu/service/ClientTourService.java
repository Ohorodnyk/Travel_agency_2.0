package com.softserve.edu.service;

import java.util.List;

import com.softserve.edu.dao.DaoFactory;
import com.softserve.edu.entity.ClientTour;

public class ClientTourService {

    public void addClientTour(ClientTour clientTour) {
        DaoFactory.getInstance().getClientTourDao().add(clientTour);
    }

    public void updateClientTour(ClientTour clientTour) {
        DaoFactory.getInstance().getClientTourDao().update(clientTour);
    }

    public ClientTour getClientTourById(Integer id) {
        return DaoFactory.getInstance().getClientTourDao().getById(id);
    }

    public List<ClientTour> getAllClientTours() {
        return DaoFactory.getInstance().getClientTourDao().getAllElements();
    }

    public void deleteClientTour(ClientTour clientTour) {
        DaoFactory.getInstance().getClientTourDao().delete(clientTour);
    }

}




