package com.exemple.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.demo.entities.Role;



public interface RoleRepository extends JpaRepository<Role,Integer>{

}
