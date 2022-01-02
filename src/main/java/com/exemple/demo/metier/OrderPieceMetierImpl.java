package com.exemple.demo.metier;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.exemple.demo.dao.IorderPieceRepository;
import com.exemple.demo.entities.Commande;
import com.exemple.demo.entities.Order_Piece;

@Service
public class OrderPieceMetierImpl implements IOrderPieceMetier{
	@Autowired
	private IorderPieceRepository orderPieceRepo;

	@Override
	public Order_Piece saveOrder_Piece(Order_Piece po) {
		// TODO Auto-generated method stub
		return orderPieceRepo.save(po);
	}

	@Override
	public Collection<Order_Piece> consulterListOrder_Piece() {
		// TODO Auto-generated method stub
		return orderPieceRepo.findAll();
	}

	@Override
	public Optional<Order_Piece> findOrder_PieceById(long id) {
		// TODO Auto-generated method stub
		return orderPieceRepo.findById(id);
	}

	@Override
	public Order_Piece updateOrder_Piece(long id, Order_Piece po) {
		// TODO Auto-generated method stub
		Order_Piece OP = orderPieceRepo.findById(id).
				orElseThrow(() -> new RuntimeException("pieceorder introuvable avec id : : " +id));
		OP.setId_piece(po. getId_piece());
		OP.setId_order(po. getId_order());
		OP.setQuantity(po. getQuantity());
		final Order_Piece updatedOrder_Piece =  orderPieceRepo.save(OP); 
		return updatedOrder_Piece;
	}

	@Override
	public void deleteOrder_Piece(long id) {
		// TODO Auto-generated method stub
		orderPieceRepo.deleteById(id);
	}

	@Override
	public Optional<Order_Piece> FindOrderPieceByIdOrder(long id_order) {
		// TODO Auto-generated method stub
		
		return orderPieceRepo.findOrderPieceByIdOrder(id_order);
	}

}
