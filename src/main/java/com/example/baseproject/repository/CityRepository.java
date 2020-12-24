package com.example.baseproject.repository;

import com.example.baseproject.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {

}
