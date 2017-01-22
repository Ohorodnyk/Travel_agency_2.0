package com.softserve.edu.service;

import java.util.List;

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

}
