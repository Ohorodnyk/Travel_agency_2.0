package com.softserve.edu.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.softserve.edu.dao.DaoFactory;
import com.softserve.edu.entity.Hotel;

public class HotelService {

    public void addHotel(Hotel hotel) {
        DaoFactory.getInstance().getHotelDao().add(hotel);
    }

    public void updateHotel(Hotel hotel) {
        DaoFactory.getInstance().getHotelDao().update(hotel);
    }

    public Hotel getHotelById(Integer id) {
        return DaoFactory.getInstance().getHotelDao().getById(id);
    }

    public List<Hotel> getAllHotels() {
        return DaoFactory.getInstance().getHotelDao().getAllElements();
    }

    public void deleteHotel(Hotel hotel) {
        DaoFactory.getInstance().getHotelDao().delete(hotel);
    }

    public Set<Hotel> findHotels(String city) {
        return DaoFactory.getInstance().getHotelDao().findHotels(city);
    }

    public int findCountOfFreeRooms(String hotel, Date date) {
        return DaoFactory.getInstance().getHotelDao().findCountOfFreeRooms(hotel, date);
    }

    public List<Object[]> findFreeHotels(String city, Date date) {
        return DaoFactory.getInstance().getHotelDao().findFreeHotels(city, date);
    }

    public int findCountOfClients(String hotel) {
        return DaoFactory.getInstance().getHotelDao().findCountOfClients(hotel);
    }

    public int averageTimeOfBooking(String hotel) {
        return DaoFactory.getInstance().getHotelDao().averageTimeOfBooking(hotel);
    }

}
