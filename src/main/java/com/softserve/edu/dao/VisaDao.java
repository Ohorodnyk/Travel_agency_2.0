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

    public Set<Visa> findVisas(String firstName, String lastName) {
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

    public int countOfVisas(String country) {
        Session session = null;
        int count = 0;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("select count(country.id) from Visa  where country.name =:country");
            query.setParameter("country", country);
            List list = query.list();
            count = ((Number) list.get(0)).intValue();
            transaction.commit();
        }
        finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return count;
    }

    public List<Visa> findValidVisas(String firstName, String lastName, String country) {
        Session session = null;
        List<Visa> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("select v from Client as c join c.visas v "
                    + "where c.firstName = :fName and lastName = :lName "
                    +" and v.endDate > CURRENT_DATE() and v.country.name= :country" );     
            query.setParameter("fName",firstName);
            query.setParameter("lName",lastName);
            query.setParameter("country",country);
            list = query.list();
            transaction.commit();
        }
        finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }

        }
       return list;
   
    }

}
