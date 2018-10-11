package fr.ynov.guerny.banque.model;

import java.util.ArrayList;
import java.util.Date;

public class Account {

	private int id;
	private TypeCpt type_cpt;
	private double balance;
	private Date creation;
	private ArrayList<Transaction> transactions;
	
}
