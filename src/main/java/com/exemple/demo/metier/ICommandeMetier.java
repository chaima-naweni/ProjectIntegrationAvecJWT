package com.exemple.demo.metier;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Page;


import com.exemple.demo.entities.Commande;

public interface ICommandeMetier {
	public Commande saveCommande(Commande C);
	public Collection<Commande> consulterListCommande();
	public Optional<Commande> findCommandeById(long id);
	public  Commande updateCommande(long id, Commande C);
	public void deleteCommande(long id);
	public Page<Commande> FindCommandeByDateCmdClient(String dateCmdClient,int page, int size);

}
 