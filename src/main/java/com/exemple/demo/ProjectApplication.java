package com.exemple.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exemple.demo.dao.IAdminRepository;
import com.exemple.demo.dao.IClientRepository;
import com.exemple.demo.dao.ICommandeRepository;
import com.exemple.demo.dao.IFactureRepository;
import com.exemple.demo.dao.ILivraisonRepository;
import com.exemple.demo.dao.IPieceRepository;
import com.exemple.demo.dao.RoleRepository;
import com.exemple.demo.dao.UserRepository;
import com.exemple.demo.entities.Role;
import com.exemple.demo.entities.User;
import com.exemple.demo.metier.UserService;
import com.exemple.demo.services.AdminRestServices;
import com.exemple.demo.services.ClientRestServices;
import com.exemple.demo.services.LivraisonRestServices;
import com.exemple.demo.services.FactureRestServices;
import com.exemple.demo.services.CommandeRestServices;
import com.exemple.demo.services.PieceRestServices;

@SpringBootApplication

public class ProjectApplication implements CommandLineRunner{

	@Autowired 
	private UserService userService;
	@Autowired 
	RoleRepository roleRepository;
	@Autowired 
	UserRepository userRepository;
	@Autowired 
	IFactureRepository factureRepository;
	@Autowired 
	ICommandeRepository commandeRepository;
	@Autowired 
	ILivraisonRepository livraisonRepository;
	@Autowired
	IPieceRepository  pieceRepository;
	@Autowired
	IClientRepository clientRepository;
	@Autowired
	IAdminRepository adminRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
	
	
	public void run(String... args) throws Exception {
		
		BCryptPasswordEncoder encoder; 
		encoder = new BCryptPasswordEncoder();

		Role r1=new Role("ROLE_ADMIN");
		roleRepository.save(r1);
		
		User u1=new User();
		u1.setUsername("admin");
		encoder = new BCryptPasswordEncoder();
		u1.setPassword(encoder.encode("admin"));
		u1.getRoles().add(r1);
		userRepository.save(u1);
		
		roleRepository.save(r1);
		
   
	User u2=userService.saveUser("user", "user", "user");
	
	
	Set<Role> roles = new HashSet<Role>();
	roles.add(r1);
	u1.setRoles(roles);
	userRepository.save(u2);
}
}
