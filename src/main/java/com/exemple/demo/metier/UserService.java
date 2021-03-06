package com.exemple.demo.metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exemple.demo.dao.RoleRepository;
import com.exemple.demo.dao.UserRepository;
import com.exemple.demo.entities.Livraison;
import com.exemple.demo.entities.Role;
import com.exemple.demo.entities.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService implements AuthenticationUserDetailsService, UserDetailsService {
	private final UserRepository userRepository;
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
	this.userRepository = userRepository;
	}
	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Objects.requireNonNull(username);
	User user = userRepository.findUserWithName(username)
	.orElseThrow(() -> new UsernameNotFoundException("User not found"));
	Collection<GrantedAuthority> authorities=new ArrayList<>();
	user.getRoles().forEach(r->{
	 authorities.add(new SimpleGrantedAuthority(r.getName()));
	});
	return new
	org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
	}
	
	
	
	public User saveUser(String username, String password, String confirmedPassword,String email,String adresse,String tel) {
		 User appUser = new User();
		 if (userRepository.findUserWithName(username).isPresent() == true)
		 throw new RuntimeException("User already exists");
		 
		 if (!password.equals(confirmedPassword))
		 throw new RuntimeException("Please confirm your password");
		
		 appUser.setUsername(username);
		 appUser.setEmail(email);
		 appUser.setAdresse(adresse);
		 appUser.setTel(tel);
		 Set<Role> roles = new HashSet<Role>();
		 Role r = new Role("ROLE_USER");
		 roleRepository.save(r);
		 roles.add(r);
		 appUser.setRoles(roles);
		 appUser.setPassword(bCryptPasswordEncoder.encode(password));
		 userRepository.save(appUser);
		 return appUser;
		 }
	//yaffichy user bel username
	public Optional<User> FindUserWithName(String username) {
		// TODO Auto-generated method stub
		return userRepository.findUserWithName(username);
	}

	@Override
	public UserDetails loadUserDetails(Authentication token) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
