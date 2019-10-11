package com.cg.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hotelmanagement.dto.City;



public interface CityRepository extends JpaRepository<City,Long> {

}
