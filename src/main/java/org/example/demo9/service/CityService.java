package org.example.demo9.service;

import org.example.demo9.model.City;
import org.example.demo9.model.Country;
import org.example.demo9.repository.CRepository;
import org.example.demo9.repository.Cityrepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CityService implements ICityService {
    @Autowired
    Cityrepository repository;
    @Autowired
    CRepository cRepository;
    @Override
    public List<City> showALl() {
        return repository.findAll();
    }
    @Override
    public void Create(City city) {
        repository.save(city);
    }

    @Override
    public List<Country> showCountry() {
        return cRepository.findAll();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<City> ShowInf(int id) {
        return repository.findById(id);
    }

    @Override
    public void Update(City city, int id) {
        city.setId(id);
        repository.save(city);
    }
}
