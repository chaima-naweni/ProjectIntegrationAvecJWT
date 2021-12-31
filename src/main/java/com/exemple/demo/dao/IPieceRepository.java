package com.exemple.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.exemple.demo.entities.Piece;

public interface IPieceRepository  extends JpaRepository<Piece,Long>{
	@Query("select p from Piece p where p.category like :x")
	public Page <Piece> findPieceByCategory(@Param("x")String category,Pageable p);	

}
