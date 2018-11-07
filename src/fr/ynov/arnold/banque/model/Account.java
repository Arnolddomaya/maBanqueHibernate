package fr.ynov.arnold.banque.model;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="compte")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//private TypeCpt type_cpt;
	private double balance;
	private Date creation;
	private String libelle;
	
	@OneToMany(mappedBy="transactionAccount", cascade=CascadeType.ALL)
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	@ManyToOne
	private Client accountClient;
	
	
	//Constructeurs
	public Account() {
		this.creation = new Date();
	}
	public Account(String lib) {
		libelle = lib;
		this.creation = new Date();
	}
	
	public Account(String lib, double balance) {
		libelle = lib;
		this.creation = new Date();
		this.balance = balance;
	}
	
	
	//getteurs et setteurs 
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public TypeCpt getType_cpt() {
//		return type_cpt;
//	}
//	public void setType_cpt(TypeCpt type_cpt) {
//		this.type_cpt = type_cpt;
//	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getCreation() {
		return creation;
	}
	public void setCreation(Date creation) {
		this.creation = creation;
	}
	public Client getAccountClient() {
		return accountClient;
	}
	public void setAccountClient(Client accountClient) {
		this.accountClient = accountClient;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	//Autres méthodes 
	public void addToTransactions(Transaction tran) {
		tran.setTransactionAccount(this);
		this.transactions.add(tran);
		this.balance += tran.getAmount();
	}
	
	
}
