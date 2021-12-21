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


import com.exemple.demo.entities.Facture;
import com.exemple.demo.metier.IFactureMetier;

@RestController
public class FactureRestServices {
	
	@Autowired
	private IFactureMetier facturenMetier;

	@RequestMapping(value="/factures",method=RequestMethod.POST)
	public Facture saveFacture( @RequestBody Facture f) {
		return facturenMetier.saveFacture(f);
	}
	@RequestMapping(value="/factures",method =RequestMethod.GET)
	public Collection<Facture> getFactures() {
		return facturenMetier.consulterListFacture();
	}

	@RequestMapping(value="/factures/{id}",method =RequestMethod.GET)
	public Optional<Facture> findFactureById( @PathVariable long id) {
		return facturenMetier.findFactureById(id);
	}
	@RequestMapping(value="/factures/{id}",method =RequestMethod.PUT)
	public ResponseEntity<Facture> updateFacture( @PathVariable long id, @RequestBody Facture facture) {
		return ResponseEntity.ok(facturenMetier.updateFacture(id, facture));
	}
	@RequestMapping(value="/factures/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteFacture( @PathVariable long id) {
		facturenMetier.deleteFacture(id);
	}
	@RequestMapping(value="/factureByDesc",method = RequestMethod.GET) 
	@ResponseBody
	public Page<Facture> FindFactureByDescription(@RequestParam String description, 
			                                      @RequestParam int page,
			                                      @RequestParam int size) {
		return facturenMetier.FindFactureByDescription(description, page, size);
	}
	

}
