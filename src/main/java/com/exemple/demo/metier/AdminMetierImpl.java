package com.exemple.demo.metier;

import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exemple.demo.dao.IAdminRepository;
import com.exemple.demo.entities.Admin;

@Service
public class AdminMetierImpl implements  IAdminMetier{
	
	@Autowired
	IAdminRepository  adminRepository;
	@Override
	public Admin saveAdmin(Admin a) {
		// TODO Auto-generated method stub
		return adminRepository.save(a);
	}

	@Override
	public Collection<Admin> consulterListAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public Optional<Admin> findAdminById(long id) {
		// TODO Auto-generated method stub
		return adminRepository.findById(id);
	}

	@Override
	public Admin updateAdmin(long id, Admin a) {
		// TODO Auto-generated method stub
		Admin ad = adminRepository.findById(id).
				orElseThrow(() -> new RuntimeException("admin introuvable avec id : : " +id));
		ad.setNom(a.getNom());
		ad.setPassword(a.getPassword());
		ad.setEmail(a.getEmail());
		ad.setAdresse(a.getAdresse());
		ad.setTel(a.getTel());
		final Admin updatedAdmin =  adminRepository.save(ad); 
		return updatedAdmin;
	}

	@Override
	public void deleteAdmin(long id) {
		// TODO Auto-generated method stub
		 adminRepository.deleteById(id);
	}

	@Override
	public Page<Admin> FindAdminByNom(String nom, int page,int size) {
		// TODO Auto-generated method stub
		return  adminRepository.findAdminByNom(nom, PageRequest.of(page, size));
	}



}
