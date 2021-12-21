package com.exemple.demo.metier;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.exemple.demo.dao.IClientRepository;
import com.exemple.demo.entities.Admin;
import com.exemple.demo.entities.Client;
@Service
public class ClientMetierImpl implements IClientMetier {
	
	@Autowired
	IClientRepository clientRepository;

	@Override
	public Client saveClient(Client c) {
		// TODO Auto-generated method stub
		return clientRepository.save(c);
	}

	@Override
	public Collection<Client> consulterListClient() {
		// TODO Auto-generated method stub
		return  clientRepository.findAll();
	}

	@Override
	public Optional<Client> findClientById(long id) {
		// TODO Auto-generated method stub
		return clientRepository.findById(id);
	}

	@Override
	public Client updateClient(long id, Client c) {
		// TODO Auto-generated method stub
		Client cl = clientRepository.findById(id).
				orElseThrow(() -> new RuntimeException("client introuvable avec id : : " +id));
		cl.setNomClient(c.getNomClient());
		cl.setPasswordClient(c.getPasswordClient());
		cl.setEmailClient(c.getEmailClient());
		cl.setAdresseClient(c.getAdresseClient());
		cl.setTelClient(c.getTelClient());
		final Client updatedClient =  clientRepository.save(cl); 
		return updatedClient;
		
	}

	@Override
	public void deleteClient(long id) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(id);
	}

	@Override
	public Page<Client> FindClientByNom(String nomClient, int page, int size) {
		// TODO Auto-generated method stub
		return clientRepository.findClientByNom(nomClient, PageRequest.of(page, size));
	}

}
