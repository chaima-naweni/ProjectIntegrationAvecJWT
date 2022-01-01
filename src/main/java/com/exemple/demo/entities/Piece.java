 package com.exemple.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table
public class Piece implements Serializable{
	
	@Id
	@GeneratedValue
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="category")
	private String category;
	@Column(name="description")
	private String description;
	@Column(name="image")
	private String image;
	@Column(name="price")
	private float price;
	@Column(name="quantity")
	private float quantity;
	@Column(name="images")
	private String images;

	
	/*
	 * @OneToMany(mappedBy="orders",fetch = FetchType.LAZY) private
	 * List<Order_Piece> orders = new ArrayList<Order_Piece>();
	 */
	 
	public Piece(long id, String name, String category, String description, String image, float price, float quantity,
			String images) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
		this.images = images;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}

	
	

}
