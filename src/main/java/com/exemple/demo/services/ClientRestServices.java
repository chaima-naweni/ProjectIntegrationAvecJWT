package com.exemple.demo.services;

import java.util.Collection;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.exemple.demo.entities.Client;
import com.exemple.demo.metier.IClientMetier;
@RestController
public class ClientRestServices {
	@Autowired
	private IClientMetier clientMetier;
	
	@RequestMapping(value="/clients",method=RequestMethod.POST)
	public Client saveClient( @RequestBody Client c) {
		return clientMetier.saveClient(c);
	}
	
	@RequestMapping(value="/clients",method =RequestMethod.GET)
	public Collection<Client> getClients() {
		return clientMetier.consulterListClient();
	}
	
	@RequestMapping(value="/clients/{id}",method =RequestMethod.GET)
	public Optional<Client> findClientById( @PathVariable long id) {
		return clientMetier.findClientById(id);
	}
	@RequestMapping(value="/clients/{id}",method =RequestMethod.PUT)
	public ResponseEntity<Client> updateClient(@PathVariable long id, @RequestBody Client client) {
		 return ResponseEntity.ok(clientMetier.updateClient(id, client));
	}
	@RequestMapping(value="/clients/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteClient( @PathVariable long id) {
		clientMetier.deleteClient(id);
	}
	@RequestMapping(value="/clientBynom",method = RequestMethod.GET) 
	@ResponseBody
	public Page<Client> FindClientByNom(@RequestParam String nomClient,
			                            @RequestParam int page,
			                            @RequestParam int size) {
		return clientMetier.FindClientByNom(nomClient, page, size);
	}
	
	

}
