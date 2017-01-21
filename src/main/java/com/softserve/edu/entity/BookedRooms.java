package com.softserve.edu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name="booked_rooms")
public class BookedRooms {

    @Column(name="room_id")
    private  int roomId;

    @Column(name="client_tour_id")
    private  int clientTourId;

    @Column(name="start_date")
    private Date startData;

    @Column(name="end_date")
    private  Date endDate;


    public BookedRooms(int roomId) {
        this.roomId = roomId;
    }

    public BookedRooms(int roomId, int clientTourId, Date startData, Date endDate) {
        this.roomId = roomId;
        this.clientTourId = clientTourId;
        this.startData = startData;
        this.endDate = endDate;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setClientTourId(int clientTourId) {
        this.clientTourId = clientTourId;
    }

    public void setStartData(Date startData) {
        this.startData = startData;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getClientTourId() {
        return clientTourId;
    }

    public Date getStartData() {
        return startData;
    }

    public Date getEndDate() {
        return endDate;
    }
}
