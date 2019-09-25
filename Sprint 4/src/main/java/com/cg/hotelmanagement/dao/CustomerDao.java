package com.cg.hotelmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.util.JPAUtil;

public class CustomerDao implements ICustomerDao {
	
	private static EntityTransaction tx;
	private static EntityManager entityManager;

	static {
		entityManager = JPAUtil.getEntityManager();
		tx  = JPAUtil.getEntityManager().getTransaction();
	}

	@Override
	public boolean register(Customer customer) {
		tx.begin();
		entityManager.persist(customer);
		tx.commit();
		return true;
	}

}
