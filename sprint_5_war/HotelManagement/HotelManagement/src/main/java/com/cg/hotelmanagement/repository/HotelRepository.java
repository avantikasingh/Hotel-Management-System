package com.cg.hotelmanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hotelmanagement.dto.Hotel;

/**
 * @author Saurabh
 *
 */

public interface HotelRepository extends JpaRepository<Hotel,Long> {

}
