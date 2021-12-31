package com.exemple.demo.metier;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.exemple.demo.entities.Piece;

public interface IPieceMetier {
	public Piece savePiece(Piece p);
	public Collection< Piece> consulterListPiece();
	public Optional<Piece> findPieceById(long id);
	public  Piece updatePiece (long id, Piece p);
	public void deletePiece(long id);

	public Page<Piece> FindPieceByCategory(String category,int page, int size);

}
