package fr.ynov.guerny.banque.manager;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.plaf.synth.SynthSeparatorUI;

import fr.ynov.guerny.banque.model.Account;
import fr.ynov.guerny.banque.model.Client;

public class ClientManager  {
	
	public static void saveClient(Client client) {
		EntityManager em = BaseManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(client);
		em.getTransaction().commit();
	}
	
	public static Client loadClientById(Integer clientId) {
		EntityManager em = BaseManager.getEntityManager();
		Client user = em.find(Client.class, clientId);
		return user;
	}
	public static Client loadClientByLoginAndPassword(String login, String password) {
		EntityManager em = BaseManager.getEntityManager();
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE c.login='" + login +"' and c.password='" + password + "'", Client.class);
		Client cli = query.getSingleResult();
		
//		for (Account iter: cli.getAccounts()) {
//			System.out.println(iter);
//			System.out.println(iter.getTransactions().size());
//			
//		}
		return cli;
	}
	public static void deleteClient(Client cli) {
		
	}
	//suprime toutes les entrées des table, en sens inverse de la cascade
	public static void purgeTable() {
		EntityManager em = BaseManager.getEntityManager();
		em.getTransaction().begin();
		//suprime toutes les entrées de la table tansaction
		em.createQuery("delete from Transaction").executeUpdate();
		em.createQuery("delete from Account").executeUpdate();
		em.createQuery("delete from Client").executeUpdate();
		em.getTransaction().commit();
	}

}
