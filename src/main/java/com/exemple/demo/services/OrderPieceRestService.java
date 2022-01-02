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

import com.exemple.demo.entities.Order_Piece;
import com.exemple.demo.entities.Piece;
import com.exemple.demo.metier.IOrderPieceMetier;

@RestController
public class OrderPieceRestService {
	@Autowired
	IOrderPieceMetier orderPieceMerier;

	
	@RequestMapping(value="/orderPieces",method=RequestMethod.POST)
	public Order_Piece saveOrder_Piece( @RequestBody Order_Piece po) {
		return orderPieceMerier.saveOrder_Piece(po);
	}
	@RequestMapping(value="/orderPieces",method =RequestMethod.GET)
	public Collection<Order_Piece> getOrderPieces() {
		return orderPieceMerier.consulterListOrder_Piece();
	}
	@RequestMapping(value="/orderPieces/{id}",method =RequestMethod.GET)
	public Optional<Order_Piece> findOrder_PieceById( @PathVariable long id) {
		return orderPieceMerier.findOrder_PieceById(id);
	}
	@RequestMapping(value="/orderPieces/{id}",method =RequestMethod.PUT)
	public ResponseEntity<Order_Piece> updateOrder_Piece( @PathVariable long id, @RequestBody Order_Piece orderPiecee) {
		return ResponseEntity.ok(orderPieceMerier.updateOrder_Piece(id, orderPiecee));
	}
	@RequestMapping(value="/orderPieces/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteOrder_Piece( @PathVariable long id) {
		orderPieceMerier.deleteOrder_Piece(id);
	}
	@RequestMapping(value="/OrderPieceByOrderId",method = RequestMethod.GET) 
	@ResponseBody

	public Optional<Order_Piece> FindOrderPieceByIdOrder( @RequestParam long id_order) {
		return orderPieceMerier.FindOrderPieceByIdOrder(id_order);
	}
	

}
