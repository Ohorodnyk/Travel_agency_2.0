package com.softserve.edu.entity;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "visas")
public class Visa {
    @Id
    @Column(name = "visa_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    
    
    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

   
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public Visa(){
        
    }
    
    
    public Visa(Client client, Country country, Date startDate, Date endDate) {
        super();
        this.client = client;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
