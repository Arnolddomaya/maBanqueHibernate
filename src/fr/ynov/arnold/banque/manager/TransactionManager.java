package fr.ynov.arnold.banque.manager;

import javax.persistence.EntityManager;

import fr.ynov.arnold.banque.model.Transaction;

public class TransactionManager {
	public static  Transaction loadClientById(Integer transacId) {
		EntityManager em = BaseManager.getEntityManager();
		Transaction transac = em.find(Transaction.class, transacId);
		return transac;
	}
}
