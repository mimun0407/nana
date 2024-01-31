package org.example.demo9.service;

import org.example.demo9.model.City;
import org.example.demo9.model.Country;

import java.util.List;
import java.util.Optional;

public interface ICityService {
    List<City> showALl();
    void Create(City city);
    List<Country>showCountry();
    void delete(int id);
    Optional<City> ShowInf(int id);
    void Update(City city, int id);
}
