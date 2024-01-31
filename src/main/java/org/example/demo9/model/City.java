package org.example.demo9.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "ko dc de trong name")
    private String name;
    @Min(value = 2,message = "phai de lon hon 2")
    private int age;
    @ManyToOne
    private Country country;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City() {
    }

    public City(int id, String name, int age, Country country) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
    }
}
