package com.exemple.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Client implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	@Column(name="nomClient")
	private String nomClient;
	@Column(name="passwordClient")
	private String passwordClient;
	@Column(name="emailClient")
	private String emailClient;
	@Column(name="adresseClient")
	private String adresseClient;
	@Column(name="telClient")
	private String telClient;
	public Client(long id, String nomClient, String passwordClient, String emailClient, String adresseClient,
			String telClient) {
		super();
		this.id = id;
		this.nomClient = nomClient;
		this.passwordClient = passwordClient;
		this.emailClient = emailClient;
		this.adresseClient = adresseClient;
		this.telClient = telClient;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPasswordClient() {
		return passwordClient;
	}
	public void setPasswordClient(String passwordClient) {
		this.passwordClient = passwordClient;
	}
	public String getEmailClient() {
		return emailClient;
	}
	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}
	public String getAdresseClient() {
		return adresseClient;
	}
	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	public String getTelClient() {
		return telClient;
	}
	public void setTelClient(String telClient) {
		this.telClient = telClient;
	}
	

	
	

}
