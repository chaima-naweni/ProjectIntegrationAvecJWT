package com.exemple.demo.metier;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.exemple.demo.dao.IFactureRepository;
import com.exemple.demo.entities.Facture;

@Service
public class FactureMetierImpl implements IFactureMetier{
	@Autowired
	IFactureRepository factureRepository;

	@Override
	public Facture saveFacture(Facture f) {
		// TODO Auto-generated method stub
		return factureRepository.save(f);
	}

	@Override
	public Collection<Facture> consulterListFacture() {
		// TODO Auto-generated method stub
		return factureRepository.findAll();
	}

	@Override
	public Optional<Facture> findFactureById(long id) {
		// TODO Auto-generated method stub
		return factureRepository.findById(id);
	}

	@Override
	public Facture updateFacture(long id, Facture f) {
		// TODO Auto-generated method stub
		Facture fact = factureRepository.findById(id).
				orElseThrow(() -> new RuntimeException("admin introuvable avec id : : " +id));
		fact.setDateFacture(f.getDateFacture());
		fact.setDescription(f.getDescription());
		
		final Facture updatedFacture =  factureRepository.save(fact); 
		return updatedFacture;
	}

	@Override
	public void deleteFacture(long id) {
		// TODO Auto-generated method stub
		factureRepository.deleteById(id);
	}

	@Override
	public Page<Facture> FindFactureByDescription(String description, int page, int size) {
		// TODO Auto-generated method stub
		return  factureRepository.findFactureByDescription(description, PageRequest.of(page, size));
	}

}
