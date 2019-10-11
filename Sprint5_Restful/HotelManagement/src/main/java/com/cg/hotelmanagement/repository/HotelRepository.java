package com.cg.hotelmanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hotelmanagement.dto.City;
import com.cg.hotelmanagement.dto.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

}
