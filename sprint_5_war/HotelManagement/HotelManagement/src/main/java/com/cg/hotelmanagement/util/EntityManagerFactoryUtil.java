package com.cg.hotelmanagement.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerFactoryUtil {
	private static EntityManagerFactory entityManagerFactory;
	
	private EntityManagerFactoryUtil() {}
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("HotelBookingManagement");
	}
	public static EntityManagerFactory getEntityManagerFactory() {
		if(entityManagerFactory==null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("HotelBookingManagement");
		}
		return entityManagerFactory;
	}
	public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		EntityManagerFactoryUtil.entityManagerFactory = entityManagerFactory;
	}
}

