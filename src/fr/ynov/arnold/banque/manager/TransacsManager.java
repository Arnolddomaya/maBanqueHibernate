package fr.ynov.arnold.banque.manager;

import javax.persistence.EntityManager;

import fr.ynov.arnold.banque.model.Transaction;

public class TransacsManager {
	
	public static  void saveTransaction(Transaction transac) {
		
		EntityManager em = BaseManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(transac);
		em.getTransaction().commit();
	}	

}
