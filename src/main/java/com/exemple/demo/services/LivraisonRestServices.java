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
import com.exemple.demo.entities.Livraison;
import com.exemple.demo.metier.ILivraisonMetier;

@RestController
public class LivraisonRestServices {
	@Autowired
	private ILivraisonMetier livraisonMetier;
	
	@RequestMapping(value="/livraisons",method=RequestMethod.POST)
	public Livraison saveLivraison(@RequestBody Livraison l) {
		return livraisonMetier.saveLivraison(l);
	}
	@RequestMapping(value="/livraisons",method =RequestMethod.GET)
	public Collection<Livraison> getLivraisons() {
		return livraisonMetier.consulterListLivraison();
	}
	@RequestMapping(value="/livraisons/{id}",method =RequestMethod.GET)
	public Optional<Livraison> findLivraisonById(@PathVariable long id) {
		return livraisonMetier.findLivraisonById(id);
	}
	@RequestMapping(value="/livraisons/{id}",method =RequestMethod.PUT)
	public ResponseEntity<Livraison> updateLivraison(@PathVariable long id,@RequestBody  Livraison livraison) {
		return ResponseEntity.ok(livraisonMetier.updateLivraison(id, livraison));
		
	}
	@RequestMapping(value="/livraisons/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteLivraison(@PathVariable long id) {
		livraisonMetier.deleteLivraison(id);
	}
	@RequestMapping(value="/livraisonByAdr",method = RequestMethod.GET) 
	@ResponseBody
	public Page<Livraison> FindLivraisonByAdresse(@RequestParam String adresseLiv, 
			                                      @RequestParam int page, 
			                                      @RequestParam int size) {
		return livraisonMetier.FindLivraisonByAdresse(adresseLiv, page, size);
	} 
	

}
