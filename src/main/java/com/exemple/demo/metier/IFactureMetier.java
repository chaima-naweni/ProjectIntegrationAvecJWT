package com.exemple.demo.metier;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.exemple.demo.entities.Facture;

public interface IFactureMetier {
	public Facture saveFacture(Facture f);
	public Collection< Facture> consulterListFacture();
	public Optional<Facture> findFactureById(long id);
	public  Facture updateFacture (long id, Facture f);
	public void deleteFacture(long id);

	public Page<Facture> FindFactureByDescription(String description,int page, int size);

}
