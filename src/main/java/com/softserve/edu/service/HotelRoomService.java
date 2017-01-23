package com.softserve.edu.service;

import java.util.List;

import com.softserve.edu.dao.DaoFactory;
import com.softserve.edu.entity.HotelRoom;

public class HotelRoomService {

    public void addHotelRoom(HotelRoom hotelRoom) {
        DaoFactory.getInstance().getHotelRoomDao().add(hotelRoom);
    }

    public void updateHotelRoom(HotelRoom hotelRoom) {
        DaoFactory.getInstance().getHotelRoomDao().update(hotelRoom);
    }

    public HotelRoom getHotelRoomById(Integer id) {
        return DaoFactory.getInstance().getHotelRoomDao().getById(id);
    }

    public List<HotelRoom> getAllHotelRooms() {
        return DaoFactory.getInstance().getHotelRoomDao().getAllElements();
    }

    public void deleteHotelRoom(HotelRoom hotelRoom) {
        DaoFactory.getInstance().getHotelRoomDao().delete(hotelRoom);
    }

}
