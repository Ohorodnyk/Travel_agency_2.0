package com.softserve.edu.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "client_tours")
public class ClientTour {
    @Id
    @Column(name = "client_tour_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientTourId;

    @Column(name = "client_id")
    private int clientId;

    @Column(name = "tour_id")
    private int tourId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "rooms_count")
    private int roomsCount;

    public int getClientTourId() {
        return clientTourId;
    }

    public void setClientTourId(int clientTourId) {
        this.clientTourId = clientTourId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }
}
