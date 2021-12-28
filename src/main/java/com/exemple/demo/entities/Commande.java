package com.exemple.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table
public class Commande implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	@Column(name="dateCmdClient")
	private String dateCmdClient;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_fact")
	private Facture facture;
	
	 @ManyToMany
	  @JoinTable(name = "commande_piece",
	             joinColumns = @JoinColumn(name = "commande_id"),
	             inverseJoinColumns = @JoinColumn(name = "piece_id"))
	  private List<Piece> piece = new ArrayList<>();
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
