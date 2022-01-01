package com.exemple.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.exemple.demo.entities.Piece;
import com.exemple.demo.entities.Orders;
@Entity
@Table
public class Order_Piece implements Serializable{
	
	@Id
	@GeneratedValue
	private long id;
	private long id_piece;
	private long id_order;
	private double quantity;
	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name="id_piece") private Piece piece;
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name="id_order") private Orders order;
	 */
	  
	  
	public Order_Piece(long id,long id_piece, long id_order, double quantity) {
		super();
		this.id=id;
		this.id_piece = id_piece;
		this.id_order = id_order;
		this.quantity = quantity;
	}
	public Order_Piece() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_piece() {
		return id_piece;
	}
	public void setId_piece(long id_piece) {
		this.id_piece = id_piece;
	}
	public long getId_order() {
		return id_order;
	}
	public void setId_order(long id_order) {
		this.id_order = id_order;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	
	

}
