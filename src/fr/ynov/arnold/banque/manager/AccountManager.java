package fr.ynov.arnold.banque.manager;

import javax.persistence.EntityManager;

import fr.ynov.arnold.banque.model.Account;
import fr.ynov.arnold.banque.model.Transaction;

public class AccountManager {

	public static  Account loadAccountById(Integer comptId) {
		EntityManager em = BaseManager.getEntityManager();
		Account cmpt = em.find(Account.class, comptId);
		return cmpt;
	}	
	
	public static Account updateAccount(Account acc) {
		
		EntityManager em = BaseManager.getEntityManager();
		em.getTransaction().begin();
		acc = em.merge(acc);
		em.getTransaction().commit();
		
		return acc;
	}
	
	public static void deleteAccount(int id) {
		
		EntityManager em = BaseManager.getEntityManager();
		em.getTransaction().begin();
		Account acc = em.find(Account.class, id);
		em.remove(acc);
		em.getTransaction().commit();
	}
}
