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

import com.exemple.demo.entities.Admin;
import com.exemple.demo.entities.Commande;
import com.exemple.demo.metier.ICommandeMetier;

@RestController
public class CommandeRestServices {
	@Autowired
	private ICommandeMetier commandeMetier;

	@RequestMapping(value="/commandes",method=RequestMethod.POST)
	public Commande saveCommande(@RequestBody Commande C) {
		return commandeMetier.saveCommande(C);
	}

	@RequestMapping(value="/commandes",method =RequestMethod.GET)
	public Collection<Commande> getCommandes() {
		return commandeMetier.consulterListCommande();
	}
	@RequestMapping(value="/commandes/{id}",method =RequestMethod.GET)
	public Optional<Commande> findCommandeById(@PathVariable long id) {
		return commandeMetier.findCommandeById(id);
	}
	@RequestMapping(value="/commandes/{id}",method =RequestMethod.PUT)
	public ResponseEntity<Commande> updateCommande(@PathVariable long id, @RequestBody Commande commande) {
		return  ResponseEntity.ok(commandeMetier.updateCommande(id, commande));
	}
	@RequestMapping(value="/commandes/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCommande(@PathVariable long id) {
		commandeMetier.deleteCommande(id);
	}
	@RequestMapping(value="/commandeByDate",method = RequestMethod.GET) 
	@ResponseBody
	public Page<Commande> FindCommandeByDateCmdClient(@RequestParam String dateCmdClient, 
			                                          @RequestParam int page, 
			                                          @RequestParam int size) {
		return commandeMetier.FindCommandeByDateCmdClient(dateCmdClient, page, size);
	}
	

}
