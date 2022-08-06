package info.gezielcarvalho.dsclient.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.gezielcarvalho.dsclient.DTO.ClientDTO;
import info.gezielcarvalho.dsclient.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		return clientRepository.findAll().stream().map(item -> new ClientDTO(item)).toList();
	}
}
