package org.example.demo9.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String CityCountry;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityCountry() {
        return CityCountry;
    }

    public void setCityCountry(String cityCountry) {
        CityCountry = cityCountry;
    }

    public Country() {
    }

    public Country(int id, String cityCountry) {
        this.id = id;
        CityCountry = cityCountry;
    }
}
