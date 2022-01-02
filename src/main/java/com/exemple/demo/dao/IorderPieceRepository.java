package com.exemple.demo.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exemple.demo.entities.Order_Piece;
import com.exemple.demo.entities.User;


public interface IorderPieceRepository extends JpaRepository<Order_Piece,Long>{
	@Query("select po from Order_Piece po where po.id_order like :x")
	Optional<Order_Piece> findOrderPieceByIdOrder(@Param("x")long id_order);

}
