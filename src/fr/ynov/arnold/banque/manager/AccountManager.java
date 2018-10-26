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
}
