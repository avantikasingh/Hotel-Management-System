package com.cg.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hotelmanagement.dto.Customer;;



public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
