package net.codejava.spring.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Contact {
	
	private int id;
	
	@NotEmpty(message = "Please enter name.")
	private String name;
	
	@NotEmpty(message = "Please enter email id.")
	@Email(message = "Please enter valid email id.")
	private String email;
	
	private String address;
	
	private String telephone;

	private String amount;
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Contact() {
	}

	public Contact(String name, String email, String address, String telephone) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.telephone = telephone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
