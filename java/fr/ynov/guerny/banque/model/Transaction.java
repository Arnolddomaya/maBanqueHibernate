package fr.ynov.guerny.banque.model;

import java.sql.Date;

public class Transaction {
	private int id;
	private double amount;
	private Account source_cpt;
	private Account dest_cpt;
	private Date date;
	private String label;
}
