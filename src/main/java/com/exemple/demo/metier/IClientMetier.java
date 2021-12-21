package com.exemple.demo.metier;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.exemple.demo.entities.Client;

public interface IClientMetier {
	public Client saveClient(Client c);
	public Collection<Client> consulterListClient();
	public Optional<Client> findClientById(long id);
	public Client updateClient (long id, Client c);
	public void deleteClient(long id);

	public Page<Client> FindClientByNom(String nomClient,int page, int size);

}
