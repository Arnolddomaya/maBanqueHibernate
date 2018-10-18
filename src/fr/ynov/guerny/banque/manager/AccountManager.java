package fr.ynov.guerny.banque.manager;

import javax.persistence.EntityManager;

import fr.ynov.guerny.banque.model.Account;
import fr.ynov.guerny.banque.model.Transaction;

public class AccountManager {

	public static  Account loadAccountById(Integer comptId) {
		EntityManager em = BaseManager.getEntityManager();
		Account cmpt = em.find(Account.class, comptId);
		return cmpt;
	}	
}
