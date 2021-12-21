package com.exemple.demo.metier;

import java.util.Collection;
import java.util.Optional;


import org.springframework.data.domain.Page;

import com.exemple.demo.entities.Admin;

public interface IAdminMetier {
	public Admin saveAdmin(Admin a);
	public Collection< Admin> consulterListAdmin();
	public Optional<Admin> findAdminById(long id);
	public  Admin updateAdmin (long id, Admin a);
	public void deleteAdmin(long id);

	public Page<Admin> FindAdminByNom(String nom,int page, int size);

}
