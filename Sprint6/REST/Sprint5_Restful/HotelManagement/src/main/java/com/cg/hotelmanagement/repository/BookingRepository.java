package com.cg.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hotelmanagement.dto.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

}
