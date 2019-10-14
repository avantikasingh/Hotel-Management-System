package com.cg.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hotelmanagement.dto.Customer;;

/**
 * @author Saurabh
 *
 */

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
