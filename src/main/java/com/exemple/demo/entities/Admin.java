package com.exemple.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Admin implements Serializable {
	
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	private String nom;
	@Column(name="password",nullable = false)
	private String password;
	private String email;
	@Column(name="adresse")
	private String adresse;
	@Column(name="tel")
	private String tel;
	

	
	//zedet constructeur!
	public Admin(long id, String nom, String password, String email, String adresse, String tel) {
		super();
		this.id = id;
		this.nom = nom;
		this.password = password;
		this.email = email;
		this.adresse = adresse;
		this.tel = tel;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	//badalet type de retour kent Long!!
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
 
}
