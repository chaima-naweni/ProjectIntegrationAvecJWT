package com.exemple.demo.dao;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exemple.demo.entities.Admin;

public interface IAdminRepository extends JpaRepository<Admin,Long> {

	@Query("select a from Admin a where a.nom like :x")
	public Page <Admin> findAdminByNom(@Param("x")String nom,Pageable p);	
}
