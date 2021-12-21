package com.exemple.demo.metier;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.exemple.demo.entities.Livraison;

public interface ILivraisonMetier {
	public Livraison saveLivraison(Livraison l);
	public Collection<Livraison> consulterListLivraison();
	public Optional<Livraison> findLivraisonById(long id);
	public  Livraison updateLivraison (long id, Livraison l);
	public void deleteLivraison(long id);

	public Page<Livraison> FindLivraisonByAdresse(String adresseLiv,int page, int size);

}
