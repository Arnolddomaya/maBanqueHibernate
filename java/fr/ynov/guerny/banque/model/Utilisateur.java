package fr.ynov.guerny.banque.model;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name="utilisateur")
public class Utilisateur 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private static int idCount;
	
    private int id;
	private String name;
    private String forename;
    private String email;
    private String login;
    private String password;
    private String phone;
    private Date dab;
    private String address;
    private ArrayList<Account> accounts;
    
    public Utilisateur() {
    	id = idCount;
    	idCount++;
    	name="Name";
    	forename = "Forename";
    	email = "email@email.com";
    	login = "toto";
    	password = "toto";
    	phone = "3615";
    	dab = new Date(200);
    	address = "rue";
    }
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String surname) {
		this.forename = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDab() {
		return dab;
	}
	public void setDab(Date dab) {
		this.dab = dab;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
}
