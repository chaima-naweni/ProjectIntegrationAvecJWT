package com.exemple.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Commande implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	@Column(name="dateCmdClient")
	private String dateCmdClient;
	
	public Commande(long id, String dateCmdClient) {
		super();
		this.id = id;
		this.dateCmdClient = dateCmdClient;
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDateCmdClient() {
		return dateCmdClient;
	}

	public void setDateCmdClient(String dateCmdClient) {
		this.dateCmdClient = dateCmdClient;
	}
	
	
	
	
	

}
