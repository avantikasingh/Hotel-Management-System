package com.cg.hotelmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.hotelmanagement.dto.User;
import com.cg.hotelmanagement.util.JPAUtil;

public class UserDao implements IUserDao {
	
	private static EntityTransaction tx;
	private static EntityManager entityManager;

	static {
		entityManager = JPAUtil.getEntityManager();
		tx  = JPAUtil.getEntityManager().getTransaction();
	}

	@Override
	public boolean register(User user) {
		tx.begin();
		entityManager.persist(user);
		tx.commit();
		return true;
	}

}
