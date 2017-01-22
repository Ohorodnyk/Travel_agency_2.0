package com.softserve.edu.service;

import java.util.List;

import com.softserve.edu.dao.DaoFactory;
import com.softserve.edu.entity.Booking;

public class BookingService {

    public void addBooking(Booking booking) {
        DaoFactory.getInstance().getBookingDao().add(booking);
    }

    public void updateBooking(Booking booking) {
        DaoFactory.getInstance().getBookingDao().update(booking);
    }

    public Booking getBookingById(Integer id) {
        return DaoFactory.getInstance().getBookingDao().getById(id);
    }

    public List<Booking> getAllBookings() {
        return DaoFactory.getInstance().getBookingDao().getAllElements();
    }

    public void deleteBooking(Booking booking) {
        DaoFactory.getInstance().getBookingDao().delete(booking);
    }

}
