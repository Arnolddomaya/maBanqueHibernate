package fr.ynov.guerny.banque.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double amount;
	@ManyToOne
	private Account transactionAccount;
	private Date date;
	
	//constructors
	public Transaction() {
	}
	
	public Transaction(double pamount) {
		amount = pamount;
	}
	
	//Getters and Setters
	public Account getTransactionAccount() {
		return transactionAccount;
	}
	public void setTransactionAccount(Account transactionAccount) {
		this.transactionAccount = transactionAccount;
	}
	private String label;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
