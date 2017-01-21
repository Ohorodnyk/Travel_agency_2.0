package com.softserve.edu.entity;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="hotel_rooms")
public class HotelRooms {
    @Id
    @Column(name="room_id")
    private int roomId;

    @Column (name="hotel_id")
    private   int hotelId;

    @Column(name="name")
    private String name;

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getName() {
        return name;
    }

    public HotelRooms() {
    }

    public HotelRooms(int roomId, int hotelId, String name) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.name = name;
    }
}
