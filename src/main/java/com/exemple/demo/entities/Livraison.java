package com.exemple.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Livraison implements Serializable{
	@Id
	@GeneratedValue
	private long id;
	@Column(name="dateLiv")
	private Date dateLiv;
	@Column(name="adresseLiv")
	private String adresseLiv;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_fact")
	private Facture  facture;
	
	public Livraison(long id, Date dateLiv, String adresseLiv) {
		super();
		this.id = id;
		this.dateLiv = dateLiv;
		this.adresseLiv = adresseLiv;
	}
	public Livraison() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateLiv() {
		return dateLiv;
	}
	public void setDateLiv(Date dateLiv) {
		this.dateLiv = dateLiv;
	}
	public String getAdresseLiv() {
		return adresseLiv;
	}
	public void setAdresseLiv(String adresseLiv) {
		this.adresseLiv = adresseLiv;
	}
	
	
	

}
