package com.exemple.demo.metier;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.exemple.demo.dao.IOrdersRepository;
import com.exemple.demo.entities.Orders;
import com.exemple.demo.entities.Piece;

@Service
public class OrderMetierImpl implements IOrderMetier{
	
	@Autowired IOrdersRepository orderRepository;
	@Override
	public Orders saveOrder(Orders o) {
		// TODO Auto-generated method stub
		return orderRepository.save(o);
	}

	@Override
	public Collection<Orders> consulterListOrder() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public Optional<Orders> findOrderById(long id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id);
	}

	@Override
	public Orders updateOrder(long id, Orders o) {
		// TODO Auto-generated method stub
		Orders or = orderRepository.findById(id).
				orElseThrow(() -> new RuntimeException("order introuvable avec id : : " +id));
		or.setSuccess(o.isSuccess());
		or.setMessage(o.getMessage());
		or.setId_user(o.getId_user());

		final Orders updatedOrders =  orderRepository.save(or); 
		return updatedOrders;
	}

	@Override
	public void deleteOrder(long id) {
		// TODO Auto-generated method stub
		orderRepository.deleteById(id);    
		}
	

	@Override
	public Page<Orders> FindOrdersByUserId(long id_user, int page, int size) {
		// TODO Auto-generated method stub
		return orderRepository.findOrderByUserId(id_user, PageRequest.of(page, size));
	}

}
