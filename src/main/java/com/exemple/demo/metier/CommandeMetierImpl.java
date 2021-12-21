package com.exemple.demo.metier;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.exemple.demo.dao.ICommandeRepository;
import com.exemple.demo.entities.Admin;
import com.exemple.demo.entities.Commande;

@Service
public class CommandeMetierImpl implements ICommandeMetier {
	
	@Autowired
	ICommandeRepository  commandeRepository;

	@Override
	public Commande saveCommande(Commande C) {
		// TODO Auto-generated method stub
		return commandeRepository.save(C);
	}

	@Override
	public Collection<Commande> consulterListCommande() {
		// TODO Auto-generated method stub
		return commandeRepository.findAll();
	}

	@Override
	public Optional<Commande> findCommandeById(long id) {
		// TODO Auto-generated method stub
		return commandeRepository.findById(id);
	}

	@Override
	public Commande updateCommande(long id, Commande C) {
		// TODO Auto-generated method stub
		Commande cmd = commandeRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Commande introuvable avec id : : " +id));
		cmd.setDateCmdClient(C.getDateCmdClient());
		final Commande updatedCommande =  commandeRepository.save(cmd); 
		return updatedCommande;
	}

	@Override
	public void deleteCommande(long id) {
		// TODO Auto-generated method stub
		commandeRepository.deleteById(id);
	}

	@Override
	public Page<Commande> FindCommandeByDateCmdClient(String dateCmdClient, int page, int size) {
		// TODO Auto-generated method stub
		return commandeRepository.findCommandeByDateCmdClient(dateCmdClient, PageRequest.of(page, size));
	}
	

}
