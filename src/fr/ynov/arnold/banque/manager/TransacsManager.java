package fr.ynov.arnold.banque.manager;

import javax.persistence.EntityManager;

import fr.ynov.arnold.banque.model.Client;
import fr.ynov.arnold.banque.model.Transaction;

public class TransacsManager {
	
	public static  void saveTransaction(Transaction transac) {
		
		EntityManager em = BaseManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(transac);
		em.getTransaction().commit();
	}	
	
	public static Transaction updateTransaction(Transaction tran) {
			
		EntityManager em = BaseManager.getEntityManager();
		em.getTransaction().begin();
		tran = em.merge(tran);
		em.getTransaction().commit();
		
		return tran;
	}

}
