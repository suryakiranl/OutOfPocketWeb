package com.surya.apps.outofpocket.data.dao.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Entity Manger Factory class to fetch and retrieve Entity Manager Factory
 * instance from the Persistence object.
 * 
 * NOTE: This uses the default Entity Manger Factory name: out-of-office-web
 * 
 * @author surya
 * 
 */
public final class EMF {
	private static final String EMF_NAME = "out-of-office-web";
	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory(EMF_NAME);

	private EMF() {
	}

	/**
	 * Singleton instance of the class to obtain a copy.
	 * 
	 * @return - EntityMangerFactory instance.
	 */
	public static EntityManagerFactory get() {
		return emfInstance;
	}
}