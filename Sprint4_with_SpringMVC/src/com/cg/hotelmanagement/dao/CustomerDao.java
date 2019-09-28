package com.cg.hotelmanagement.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.dto.Hotel;
import com.cg.hotelmanagement.util.JPAUtil;

@Repository("customerDao")
public class CustomerDao implements ICustomerDao {
	
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public boolean register(Customer customer) {
		entityManager.persist(customer);
		return true;
	}

	@Override
	public List<Hotel> viewAvailableHotels(LocalDate checkin, LocalDate checkout) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	
}
