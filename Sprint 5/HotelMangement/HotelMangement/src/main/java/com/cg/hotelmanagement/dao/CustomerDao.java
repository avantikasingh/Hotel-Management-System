package com.cg.hotelmanagement.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	public int authenticateUser(String username, String password) {
		Query query = entityManager.createQuery("From Customer u where u.username=:first AND u.password=:second");
		query.setParameter("first", username);
		query.setParameter("second", password);
		Customer customer = (Customer) query.getSingleResult();
		if(customer!=null) {
			if(customer.getRole().equalsIgnoreCase("Admin"))
				return 1;
			else
				return 0;
		}
		return -1;
	}

	
}
