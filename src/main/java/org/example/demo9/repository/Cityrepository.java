package org.example.demo9.repository;

import org.example.demo9.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cityrepository extends JpaRepository<City,Integer> {
}
