package com.softserve.edu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name="booking")
public class Booking {
    
    @Id
    @Column(name="booking_id")
    private  int Id;

    
    @ManyToOne
    @JoinColumn(name="room_id")
    private HotelRoom room;
    
    @ManyToOne
    @JoinColumn(name="client_tour_id")
    private ClientTour clientTour;
    
 
    
    @Column(name="start_date")
    private Date startData;

    @Column(name="end_date")
    private  Date endDate;


    public Booking() {
       
    }

   

    public Booking(HotelRoom room, ClientTour clientTour, Date startData, Date endDate) {
        super();
        this.room = room;
        this.clientTour = clientTour;
        this.startData = startData;
        this.endDate = endDate;
    }





    public int getId() {
        return Id;
    }





    public void setId(int id) {
        Id = id;
    }





    public HotelRoom getRoom() {
        return room;
    }



    public void setRoom(HotelRoom room) {
        this.room = room;
    }



    public ClientTour getClientTour() {
        return clientTour;
    }




    public void setClientTour(ClientTour clientTour) {
        this.clientTour = clientTour;
    }




    public void setStartData(Date startData) {
        this.startData = startData;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

   
    public Date getStartData() {
        return startData;
    }

    public Date getEndDate() {
        return endDate;
    }
}
