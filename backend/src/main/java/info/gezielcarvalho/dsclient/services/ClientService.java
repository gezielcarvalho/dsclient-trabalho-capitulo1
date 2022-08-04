package info.gezielcarvalho.dsclient.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.gezielcarvalho.dsclient.entities.Client;
import info.gezielcarvalho.dsclient.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	public List<Client> findAll() {
		return clientRepository.findAll();
	}
}
