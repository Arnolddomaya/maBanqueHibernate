package fr.ynov.guerny.banque.model;

import fr.ynov.guerny.banque.manager.ClientManager;

public class Main {

	public static void main(String[] args) {
		
		Client c_in = new Client();
		
		ClientManager.saveClient(c_in);
		
		Client c_out = ClientManager.loadClientById(1);
		
		if(c_out != null) {
			System.out.println(c_out.toString());
		}else{
			System.out.println("Client not found");
		}
		
		return;
	}
	
}
