package com.softserve.edu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.softserve.edu.entity.Country;

public class CountryDao extends GenericDaoImpl<Country> {

    public CountryDao() {
        super(Country.class);
    }
    
    public List<Country> findVisitedCountries(String firstName, String lastName) {

        Session session = null;
        List<Country> countries = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session
                    .createQuery("Select t.tour.country from ClientTour t where " + 
                            " t.client.firstName =:fName and t.client.lastName =:lName");
            query.setParameter("fName", firstName);
            query.setParameter("lName", lastName);
            countries = query.list();
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return countries;
    }

}
