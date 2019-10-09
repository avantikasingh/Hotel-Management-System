package com.cg.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hotelmanagement.dto.City;



public interface CityRepository extends JpaRepository<City,Long> {
//	@Modifying
//    @Transactional
//    @Query("delete from City city where city.city_id = ?1")
//	void deleteById(Integer cityId);
	
}
