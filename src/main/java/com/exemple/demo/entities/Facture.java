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
public class Facture implements Serializable{
	
	@Id
	@GeneratedValue
	private long id;
	@Column(name="dateFacture")
	private Date dateFacture;
	@Column(name="description")
	private String description;
	public Facture(long id, Date dateFacture, String description) {
		super();
		this.id = id;
		this.dateFacture = dateFacture;
		this.description = description;
	}
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateFacture() {
		return dateFacture;
	}
	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
