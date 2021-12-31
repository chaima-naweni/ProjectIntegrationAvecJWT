package com.exemple.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Facture implements Serializable{
	
	@Id
	@GeneratedValue
	private long id;
	@Column(name="dateFacture")
	private String dateFacture;
	@Column(name="description")
	private String description;
	//relation entre facture et admin//
	  @ManyToOne(fetch = FetchType.LAZY)
		 @JoinColumn(name="id_admin")
		 private Admin admin;
	  
	  
	  //relation entre facture et client//
	  @ManyToOne(fetch = FetchType.LAZY)
		 @JoinColumn(name="id_client")
		 private Client client;
	  
	  //relation entre facture et livraison//
	  @OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "id_liv")
		private Livraison livraison;
	  
	  //relation entre facture et commande
	  @OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "id_cmd")
		private Commande commande;

	public Facture(long id, String dateFacture, String description, Admin admin, Client client, Livraison livraison,
			Commande commande) {
		super();
		this.id = id;
		this.dateFacture = dateFacture;
		this.description = description;
		this.admin = admin;
		this.client = client;
		this.livraison = livraison;
		this.commande = commande;
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

	public String getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(String dateFacture) {
		this.dateFacture = dateFacture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Livraison getLivraison() {
		return livraison;
	}

	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
}
