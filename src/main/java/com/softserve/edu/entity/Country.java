package com.softserve.edu.entity;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

   
    public Country()
    {
        
    }
    public int getId() {
        return id;
    }

    public Country() {
    }

    public Country(String name, byte needVisa) {
        this.name = name;
        this.needVisa = needVisa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
}
