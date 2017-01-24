package com.softserve.edu.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public int findCountOfFreeRooms(String hotel, Date date) {
        Session session = null;
        int count = 0;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("select count(r.id) from Booking as b " + " inner join  b.room as r "
                    + " inner join  r.hotel as h " + " where h.name  =:hotel "
                    + " and  :date1 NOT BETWEEN b.startData AND b.endDate " + "AND  :date2 >b.endDate ");
            query.setParameter("hotel", hotel);
            query.setParameter("date1", date);
            query.setParameter("date2", date);
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

    public List<Object[]> findFreeHotels(String city, Date date) {
        Session session = null;
        List<Object[]> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("select h.name, count(*) from Hotel as h "
                    + " inner join  h.city as c  with c.name = :city " + " left join  h.hotelRooms as hr "
                    + " left join hr.booking as b " + " where b.endDate is null "
                    + " OR :date NOT BETWEEN b.startData AND b.endDate " + "group by h.name");
            query.setParameter("city", city);
            query.setParameter("date", date);
            list = query.list();
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }

        }
        return list;
    }

    public int findCountOfClients(String hotel) {
        Session session = null;
        int count = 0;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session
                    .createQuery("select count(distinct ct.id) from Booking as b  " + "inner join b.clientTour as ct "
                            + "inner join b.room as r " + "inner join r.hotel as h " + " where h.name= :hotel");
            query.setParameter("hotel", hotel);
            List list = query.list();
            count = ((Number) list.get(0)).intValue();
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return count;
    }

    public int averageTimeOfBooking(String hotel) {
        Session session = null;
        int days = 0;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createSQLQuery("SELECT AVG( DATEDIFF(br.end_date, br.start_date) ) "
                    + "FROM booking br " + "JOIN client_tours ct ON br.client_tour_id=ct.client_tour_id "
                    + " JOIN hotel_rooms r on br.room_id=r.room_id " + "  JOIN hotels h on r.hotel_id=h.hotel_id "
                    + " WHERE h.name= :hotel");
            query.setParameter("hotel", "Hotel Metropol");
            List list = query.list();
            days = ((Number) list.get(0)).intValue();
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return days;
    }
}