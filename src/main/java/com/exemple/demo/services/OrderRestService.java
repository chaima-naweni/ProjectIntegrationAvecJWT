package com.exemple.demo.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.demo.entities.Livraison;
import com.exemple.demo.entities.Orders;
import com.exemple.demo.metier.IOrderMetier;

@RestController
public class OrderRestService {
	@Autowired
	private IOrderMetier orderMetier;
	
	
	@RequestMapping(value="/orders",method=RequestMethod.POST)
	public Orders saveOrder( @RequestBody Orders o) {
		return orderMetier.saveOrder(o);
	}
	@RequestMapping(value="/orders",method =RequestMethod.GET)
	public Collection<Orders> getOrders() {
		return orderMetier.consulterListOrder();
	}
	@RequestMapping(value="/orders/{id}",method =RequestMethod.GET)
	public Optional<Orders> findOrderById(@PathVariable long id) {
		return orderMetier.findOrderById(id);
	}
	@RequestMapping(value="/orders/{id}",method =RequestMethod.PUT)
	public  ResponseEntity<Orders> updateOrder( @PathVariable long id, @RequestBody Orders order) {
		return ResponseEntity.ok(orderMetier.updateOrder(id, order));
		
		
	}
	@RequestMapping(value="/orders/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteOrder( @PathVariable long id) {
		orderMetier.deleteOrder(id);
	}
	@RequestMapping(value="/orderByUserId",method = RequestMethod.GET) 
	@ResponseBody
	public Page<Orders> FindOrdersByUserId( @RequestParam long id_user, @RequestParam int page, @RequestParam int size) {
		return orderMetier.FindOrdersByUserId(id_user, page, size);
	}
	

}
