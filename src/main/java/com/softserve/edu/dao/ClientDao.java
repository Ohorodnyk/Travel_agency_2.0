package com.softserve.edu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.softserve.edu.entity.Client;
import com.softserve.edu.entity.Country;

public class ClientDao extends GenericDaoImpl<Client> {

    public ClientDao() {
        super(Client.class);
    }

    public Client findClient(String firstName, String lastName) {
        Session session = null;
        Client client = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from Client where firstName =:fName and lastName =:lName");
            query.setParameter("fName", firstName);
            query.setParameter("lName", lastName);
            List<Client> list = query.list();
            client = list.get(0);
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return client;
    }

    

}
