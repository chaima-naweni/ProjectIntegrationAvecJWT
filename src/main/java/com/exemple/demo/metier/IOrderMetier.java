package com.exemple.demo.metier;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.exemple.demo.entities.Livraison;
import com.exemple.demo.entities.Orders;

public interface IOrderMetier {
	public Orders saveOrder(Orders o);
	public Collection< Orders> consulterListOrder();
	public Optional<Orders> findOrderById(long id);
	public  Orders updateOrder(long id, Orders o);
	public void deleteOrder(long id);
	
	public Page<Orders> FindOrdersByUserId(long id_user,int page, int size);

}
