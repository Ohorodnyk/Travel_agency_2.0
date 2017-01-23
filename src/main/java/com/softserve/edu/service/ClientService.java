package com.softserve.edu.service;

import java.util.List;

import com.softserve.edu.dao.DaoFactory;
import com.softserve.edu.entity.Client;
import com.softserve.edu.entity.Country;

public class ClientService {

    public void addClient(Client client) {
        DaoFactory.getInstance().getClientDao().add(client);
    }

    public void updateClient(Client client) {
        DaoFactory.getInstance().getClientDao().update(client);
    }

    public Client getClientById(Integer id) {
        return DaoFactory.getInstance().getClientDao().getById(id);
    }

    public List<Client> getAllClients() {
        return DaoFactory.getInstance().getClientDao().getAllElements();
    }

    public void deleteClient(Client client) {
        DaoFactory.getInstance().getClientDao().delete(client);
    }
    
    public Client findClient(String firstName, String lastName){
        return  DaoFactory.getInstance().getClientDao().findClient(firstName, lastName);
    }
    
   

}



