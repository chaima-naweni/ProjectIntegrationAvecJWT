package com.exemple.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Piece implements Serializable{
	
	@Id
	@GeneratedValue
	private long id;
	@Column(name="nomP")
	private String nomP;
	@Column(name="type")
	private String type;
	@Column(name="prix")
	private String prix;
	public Piece(long id, String nomP, String type, String prix) {
		super();
		this.id = id;
		this.nomP = nomP;
		this.type = type;
		this.prix = prix;
	}
	public Piece() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomP() {
		return nomP;
	}
	public void setNomP(String nomP) {
		this.nomP = nomP;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	
	

}
