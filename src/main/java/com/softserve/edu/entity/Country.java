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

    @Column(name = "need_visa")
    private byte needVisa;

    public int getId() {
        return id;
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

    public byte getNeedVisa() {
        return needVisa;
    }

    public void setNeedVisa(byte needVisa) {
        this.needVisa = needVisa;
    }
}
