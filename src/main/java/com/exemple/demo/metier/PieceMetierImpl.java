package com.exemple.demo.metier;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.exemple.demo.dao.IPieceRepository;
import com.exemple.demo.entities.Piece;

@Service
public class PieceMetierImpl implements IPieceMetier{
	@Autowired IPieceRepository pieceRepsitory;

	@Override
	public Piece savePiece(Piece p) {
		// TODO Auto-generated method stub
		return pieceRepsitory.save(p);
	}

	@Override
	public Collection<Piece> consulterListPiece() {
		// TODO Auto-generated method stub
		return pieceRepsitory.findAll();
	}

	@Override
	public Optional<Piece> findPieceById(long id) {
		// TODO Auto-generated method stub
		return pieceRepsitory.findById(id);
	}

	@Override
	public Piece updatePiece(long id, Piece p) {
		// TODO Auto-generated method stub
			Piece PI = pieceRepsitory.findById(id).
					orElseThrow(() -> new RuntimeException("Piece introuvable avec id : : " +id));
			PI.setNomP(p.getNomP());
			PI.setType(p.getType());
			PI.setPrix(p.getPrix());
			final Piece updatedPiece =  pieceRepsitory.save(PI); 
			return updatedPiece;
	}

	@Override
	public void deletePiece(long id) {
		// TODO Auto-generated method stub
		pieceRepsitory.deleteById(id);
	}

	@Override
	public Page<Piece> FindPieceByNomP(String nomP, int page, int size) {
		// TODO Auto-generated method stub
		return pieceRepsitory.findPieceByNomP(nomP, PageRequest.of(page, size));
	
	}



}
