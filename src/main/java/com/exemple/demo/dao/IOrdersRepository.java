package com.exemple.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exemple.demo.entities.Orders;



public interface IOrdersRepository extends JpaRepository<Orders,Long>{
	@Query("select o from Orders o where o.id_user like :x")
	public Page <Orders> findOrderByUserId(@Param("x")long id_user,Pageable p);

}
