package com.exemple.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Orders implements Serializable{
	@Id
	@GeneratedValue
	private long id;
	private boolean success;
	private String message;
	private long id_user;
	
	
	/*
	 * @OneToMany(mappedBy="orders",fetch = FetchType.LAZY) private
	 * List<Order_Piece> orders = new ArrayList<Order_Piece>();
	 */
	public Orders(long id, boolean success, String message, long id_user) {
		super();
		this.id = id;
		this.success = success;
		this.message = message;
		this.id_user = id_user;
	}


	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public long getId_user() {
		return id_user;
	}


	public void setId_user(long id_user) {
		this.id_user = id_user;
	}




}
