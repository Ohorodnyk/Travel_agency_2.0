package com.softserve.edu.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.softserve.edu.entity.Hotel;
import com.softserve.edu.entity.City;

public class HotelDao extends GenericDaoImpl<Hotel> {

    public HotelDao() {
        super(Hotel.class);
    }

    public Set<Hotel> findHotels(String city) {
        Session session = null;
        Set<Hotel> hotels = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("from City where name =:city");
            query.setParameter("city", city);
            List<City> list = query.list();
            hotels = list.get(0).getHotels();
            transaction.commit();
        }

        finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        
        return hotels;
    }
}