package com.softserve.edu.entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="hotel_rooms")
public class HotelRoom {
    @Id
    @Column(name="room_id")
    private int roomId;

    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotel hotel;
    
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="room")
    Set<Booking> booking = new HashSet<>();
    
    public HotelRoom(String name, int roomId, Hotel hotel) {
        super();
        this.roomId = roomId;
        this.hotel = hotel;
        this.name = name;
    }

    @Column(name="name")
    private String name;
    
    public HotelRoom(){
        
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

  

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomId() {
        return roomId;
    }

   

    public String getName() {
        return name;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Set<Booking> getBooking() {
        return booking;
    }

    public void setBooking(Set<Booking> booking) {
        this.booking = booking;
    }

   
    
}
