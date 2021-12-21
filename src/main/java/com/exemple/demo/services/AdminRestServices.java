package com.exemple.demo.services;

import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.demo.entities.Admin;
import com.exemple.demo.metier.AdminMetierImpl;
import com.exemple.demo.metier.IAdminMetier;

@RestController
public class AdminRestServices {
	
	@Autowired
	private IAdminMetier adminMetier;
	
	@RequestMapping(value="/admins",method=RequestMethod.POST)
	public Admin saveAdmin(@RequestBody Admin a) {
		return adminMetier.saveAdmin(a);
	}
	
	
	@RequestMapping(value="/admins",method =RequestMethod.GET)
	public Collection <Admin> getAdmins()
	{
	return adminMetier.consulterListAdmin();
	}
	
	
	@RequestMapping(value="/admins/{id}",method =RequestMethod.GET)
    public Optional <Admin> findAdminById(@PathVariable long id) {
		return adminMetier.findAdminById(id);
	}
	
	
	@RequestMapping(value="/admins/{id}",method =RequestMethod.PUT)
	public ResponseEntity<Admin> updateAdmin(@PathVariable long id,@RequestBody Admin admin) {
		return   ResponseEntity.ok(adminMetier.updateAdmin(id, admin));
		
	
			
		}
	

	@RequestMapping(value="/admins/{id}",method = RequestMethod.DELETE)
	@ResponseBody
    public void delete(@PathVariable long id)
     {
		adminMetier.deleteAdmin(id);
     }

	
	@RequestMapping(value="/adminBynom",method = RequestMethod.GET) 
	@ResponseBody
	public Page<Admin> FindAdminByNom(@RequestParam String nom, 
					                  @RequestParam int page, 
					                  @RequestParam int size) {
		return adminMetier.FindAdminByNom(nom,page,size);
		
	}

}
