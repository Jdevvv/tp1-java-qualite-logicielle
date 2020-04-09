package com.tactfactory.monprojetsb.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String firstname;
	private String lastname;
	@OneToMany
	private List<Product> products;
	public User(Long id, String firstname, String lastname, List<Product> products) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.products = products;
	}
	
	
}
