package fr.ynov.guerny.banque.manager;

import fr.ynov.guerny.banque.model.Account;
import fr.ynov.guerny.banque.model.Client;
import fr.ynov.guerny.banque.model.Transaction;

public class ClientManagerTest {

	public static void main(String[] args) {
		loadByLoginPassword("monLogin", "monPassword");
		//saveClient("prenom", "nom", "monLogin", "monPassword");
		//ClientManager.purgeTable();
		//saveClientWithAccountsWithTransac("prenom", "nom", "monLogin", "monPassword");
		return;
	}
	
	public static void saveClient(String pname, String pForname, String plogin, String ppassword) {
		Client cli = new Client(pname, pForname,plogin, ppassword);
		ClientManager.saveClient(cli);
	}
	
	public static void saveClientWithAccounts(String pname, String pForname, String plogin, String ppassword) {
		Client cli = new Client(pname, pForname,plogin, ppassword);
		for (int i = 0; i < 4; i++) 
			cli.addToAccounts(new Account("compte"+ i)); 
		ClientManager.saveClient(cli);
	}
	
	public static void saveClientWithAccountsWithTransac(String pname, String pForname, String plogin, String ppassword) {
		Client cli = new Client(pname + "TestTransac", pForname + "TestTransac",plogin + "TestTransac", ppassword + "TestTransac");
		Account ac = new Account("testTransaction");
		ac.addToTransactions(new Transaction(20000));
		cli.addToAccounts(ac);
		ClientManager.saveClient(cli);
	}
	
	public static void saveAndLoad() {
		Client c_in = new Client();
		ClientManager.saveClient(c_in);
		Client c_out = ClientManager.loadClientById(1);
		if(c_out != null) {
			System.out.println(c_out.toString());
		}else{
			System.out.println("Client not found");
		}
	}
	
	public static void loadByLoginPassword(String log, String pass) {
		Client cli = ClientManager.loadClientByLoginAndPassword(log, pass);
		if(cli != null) {
			System.out.println(cli.toString());
		}else{
			System.out.println("Client not found");
		}
	}
	
}
