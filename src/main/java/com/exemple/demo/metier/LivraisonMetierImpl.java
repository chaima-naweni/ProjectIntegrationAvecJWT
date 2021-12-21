package com.exemple.demo.metier;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.exemple.demo.dao.ILivraisonRepository;
import com.exemple.demo.entities.Livraison;

@Service
public class LivraisonMetierImpl implements ILivraisonMetier {
	@Autowired 
	ILivraisonRepository livraisonRepository;

	@Override
	public Livraison saveLivraison(Livraison l) {
		// TODO Auto-generated method stub
		return livraisonRepository.save(l);
	}

	@Override
	public Collection<Livraison> consulterListLivraison() {
		// TODO Auto-generated method stub
		return livraisonRepository.findAll();
	}

	@Override
	public Optional<Livraison> findLivraisonById(long id) {
		// TODO Auto-generated method stub
		return livraisonRepository.findById(id);
	}

	@Override
	public Livraison updateLivraison(long id, Livraison l) {
		// TODO Auto-generated method stub
		Livraison liv = livraisonRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Livraison introuvable avec id : : " +id));
		liv.setDateLiv(l. getDateLiv());
		liv.setAdresseLiv(l.getAdresseLiv());
		final Livraison updatedLivraison =  livraisonRepository.save(liv); 
		return updatedLivraison;
	}

	@Override
	public void deleteLivraison(long id) {
		// TODO Auto-generated method stub
		livraisonRepository.deleteById(id);
		
	}

	@Override
	public Page<Livraison> FindLivraisonByAdresse(String adresseLiv, int page, int size) {
		// TODO Auto-generated method stub
		return livraisonRepository.findLivraisonByAdresse(adresseLiv, PageRequest.of(page, size));
	}
	
	

}
