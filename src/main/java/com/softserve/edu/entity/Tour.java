package com.softserve.edu.entity;
import javax.persistence.*;

@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @Column(name = "tour_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "country_id")
    private int countryId;

    @Column(name = "city_id")
    private int cityId;

    @Column(name = "hotel_id")
    private int hotelId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
