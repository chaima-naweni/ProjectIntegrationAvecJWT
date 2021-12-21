package com.exemple.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.exemple.demo.entities.Facture;


public interface IFactureRepository extends JpaRepository<Facture,Long>{
	@Query("select f from Facture f where f.description like :x")
	public Page <Facture> findFactureByDescription(@Param("x")String description,Pageable p);	

}
