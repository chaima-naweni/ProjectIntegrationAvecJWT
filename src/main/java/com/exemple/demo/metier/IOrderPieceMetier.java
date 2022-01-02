package com.exemple.demo.metier;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.exemple.demo.entities.Order_Piece;


public interface IOrderPieceMetier {
	public Order_Piece saveOrder_Piece(Order_Piece po);
	public Collection< Order_Piece> consulterListOrder_Piece();
	public Optional<Order_Piece> findOrder_PieceById(long id);
	public  Order_Piece updateOrder_Piece(long id, Order_Piece po);
	public void deleteOrder_Piece(long id);

	Optional<Order_Piece> FindOrderPieceByIdOrder(long id_order);
}
