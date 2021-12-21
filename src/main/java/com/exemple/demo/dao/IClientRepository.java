package com.exemple.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exemple.demo.entities.Admin;
import com.exemple.demo.entities.Client;

public interface IClientRepository extends JpaRepository<Client,Long>{
	
	@Query("select c from Client c where c.nomClient like :x")
	public Page <Client> findClientByNom(@Param("x")String nomClient,Pageable p);	
}



