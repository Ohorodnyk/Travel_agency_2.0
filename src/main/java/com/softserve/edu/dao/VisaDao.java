package com.softserve.edu.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.softserve.edu.entity.City;
import com.softserve.edu.entity.Client;
import com.softserve.edu.entity.Hotel;
import com.softserve.edu.entity.Visa;

public class VisaDao extends GenericDaoImpl<Visa> {

    public VisaDao() {
        super(Visa.class);
    }
    
    public Set<Visa> findVisas(String firstName, String lastName)
    {
        Session session = null;
        Set<Visa> visas = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("from Client where firstName =:fName and lastName =:lName");
            query.setParameter("fName", firstName);
            query.setParameter("lName", lastName);
            List<Client> list = query.list();
            visas = list.get(0).getVisas();
            transaction.commit();
        }

        finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        
        return visas;
    }

}

