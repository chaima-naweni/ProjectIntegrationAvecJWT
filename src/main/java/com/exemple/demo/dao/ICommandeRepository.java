package com.exemple.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.exemple.demo.entities.Commande;

public interface ICommandeRepository extends JpaRepository<Commande,Long>{
	@Query("select C from Commande C  where C.dateCmdClient like :x")
	public Page <Commande> findCommandeByDateCmdClient(@Param("x")String dateCmdClient,Pageable p);

}
