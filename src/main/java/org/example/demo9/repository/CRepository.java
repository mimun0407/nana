package org.example.demo9.repository;

import org.example.demo9.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CRepository extends JpaRepository<Country,Integer> {
}
