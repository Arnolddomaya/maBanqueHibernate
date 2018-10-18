package fr.ynov.arnold.banque.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String name;
    private String forename;
    private String email;
    private String login;
    private String password;
    private String phone;
    private Date dab;
    private String address;
    @OneToMany(mappedBy="accountClient", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Account> accounts = new ArrayList<Account>();
    
    
    public Client() {
    }
    public Client(String pname, String pForname, String plogin, String ppassword) {	
    	name= pname;
    	forename = pForname;
    	email = "email@email.com";
    	login = plogin;
    	password = ppassword;
    	phone = "3615";
    	dab = new Date(200);
    	address = "rue";
    }
	
    @Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", forename=" + forename + "]";
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
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public void addToAccounts(Account ac) {
		ac.setAccountClient(this);
		this.accounts.add(ac);
	}
	
}
