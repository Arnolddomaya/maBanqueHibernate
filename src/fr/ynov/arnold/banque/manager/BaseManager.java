package fr.ynov.arnold.banque.manager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class BaseManager {

	private static final String UNIT_NAME = "myBanque";
	private static EntityManagerFactory factory;
	
	protected static EntityManagerFactory getEntityManagerFactory() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory(UNIT_NAME);
		}
		return factory;
	}
	
	public static void shutDown() {
		if (factory != null) {
			factory.close();
		}
	}
	
	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = getEntityManagerFactory();
		return factory.createEntityManager();
	}
	
}
