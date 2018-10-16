package fr.ynov.guerny.banque.manager;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.ynov.arnold.banque.controller.ListeComptes;
import fr.ynov.guerny.banque.model.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class ClientManager  {
	
	private static final long serialVersionUID = 3L;
	private static final Logger logger = (Logger) LogManager.getLogger(ListeComptes.class);
	
	
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
	public static Client loadClientByLoginAndPassword(String login, String password) throws NoResultException{
		EntityManager em = BaseManager.getEntityManager();
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE c.login='" + login +"' and c.password='" + password + "'", Client.class);
		Client cli;
		try{
			cli = query.getSingleResult();
			logger.info("CLient found");
		}
		catch(NoResultException e) {
			cli = null;
			logger.info("CLient not found in the bdd");
		}
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
