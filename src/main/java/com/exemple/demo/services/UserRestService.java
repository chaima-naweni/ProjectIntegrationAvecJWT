package com.exemple.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.demo.dao.UserRepository;
import com.exemple.demo.entities.Piece;
import com.exemple.demo.entities.User;
import com.exemple.demo.metier.UserService;




@RestController
public class UserRestService {
	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private UserService userService;
	
	
	
	@PostMapping("/registre")
	public User SaveUser(@RequestBody UserForm userForm){
		return userService.saveUser( userForm.getUsername(), userForm.getPassword(), userForm.getConfirmedPasssword(),userForm.getEmail(),userForm.getAdresse(),userForm.getTel());
	}
	
	
	@RequestMapping(value="/user",method = RequestMethod.GET)
	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<User> getUser(){
		return userRepository.findAll();
		}
	
	@RequestMapping(value="/user/{id}",method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_USER')")
    public User getUser(@PathVariable Integer id) {
		return userRepository.findById(id).get();
	}
	
	@PostMapping("/user")
	@PreAuthorize("hasRole('ROLE_USER')")	
	public User AddUser(@RequestBody User c){
    	return userRepository.save(c);
	}
	
	@RequestMapping(value="/user/{iduser}",method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public void deleteUser(@PathVariable Integer iduser) {
			userRepository.deleteById(iduser);
	}
	
	
	@RequestMapping(value="/user/{iduser}",method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ROLE_USER')")
	public User EditUser(@PathVariable Integer iduser, @RequestBody User user){
		return userRepository.save(user);
    }
	//yaffichi user belll username
	@RequestMapping(value="/UserByUsername",method = RequestMethod.GET) 
	@ResponseBody
	public Optional<User> FindUserWithName(@RequestParam String username)
           {
          return userRepository.findUserWithName(username);
}
	
}



class UserForm {
	
	private String username;
	private String password;
	private String confirmedPasssword;
	private String email;
	private String adresse;
	private String tel;

	public UserForm( String username, String password, String confirmedPasssword,String email, String adresse,
			String tel) {
		super();
		
		this.username = username;
		this.password = password;
		this.confirmedPasssword = confirmedPasssword;
		this.email = email;
		this.adresse = adresse;
		this.tel = tel;
	}

	public UserForm() {
		super();
// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmedPasssword() {
		return confirmedPasssword;
	}

	public void setConfirmedPasssword(String confirmedPasssword) {
		this.confirmedPasssword = confirmedPasssword;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	

}
