package info.gezielcarvalho.dsclient.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.gezielcarvalho.dsclient.DTO.ClientDTO;
import info.gezielcarvalho.dsclient.entities.Client;
import info.gezielcarvalho.dsclient.repositories.ClientRepository;
import info.gezielcarvalho.dsclient.services.exceptions.EntityNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		return clientRepository.findAll().stream().map(item -> new ClientDTO(item)).toList();
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		return new ClientDTO(clientRepository.findById(id).orElseThrow(
								() -> new EntityNotFoundException("Client not found"))
							);
	}

	@Transactional
	public ClientDTO insert(ClientDTO clientDto) {
		Client client = new Client();
		client.setName(clientDto.getName());
		client.setIncome(clientDto.getIncome());
		client.setCpf(clientDto.getCpf());
		client.setChildren(clientDto.getChildren());
		client.setBirthDate(clientDto.getBirthDate());
		return new ClientDTO(clientRepository.save(client));
	}
}
