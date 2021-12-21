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

import com.exemple.demo.entities.Admin;
import com.exemple.demo.entities.Piece;
import com.exemple.demo.metier.IPieceMetier;

@RestController
public class PieceRestServices {
	@Autowired
	 private IPieceMetier pieceMetier;
	
	@RequestMapping(value="/pieces",method=RequestMethod.POST)
	public Piece savePiece( @RequestBody Piece p) {
		return pieceMetier.savePiece(p);
	}
	@RequestMapping(value="/pieces",method =RequestMethod.GET)
	public Collection<Piece> getPieces() {
		return pieceMetier.consulterListPiece();
	}
	@RequestMapping(value="/pieces/{id}",method =RequestMethod.GET)
	public Optional<Piece> findPieceById(@PathVariable long id) {
		return pieceMetier.findPieceById(id);
	}
	@RequestMapping(value="/pieces/{id}",method =RequestMethod.PUT)
	public ResponseEntity<Piece> updatePiece(@PathVariable long id, @RequestBody Piece piece) {
		return ResponseEntity.ok(pieceMetier.updatePiece(id, piece));
	}
	@RequestMapping(value="/pieces/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePiece(@PathVariable long id) {
		pieceMetier.deletePiece(id);
	}
	@RequestMapping(value="/pieceByNomP",method = RequestMethod.GET) 
	@ResponseBody
	public Page<Piece> FindPieceByNomP(@RequestParam String nomP,
			                           @RequestParam  int page, 
			                           @RequestParam int size) {
		return pieceMetier.FindPieceByNomP(nomP, page, size);
	}
	

}
