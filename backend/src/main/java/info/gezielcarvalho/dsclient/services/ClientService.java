package info.gezielcarvalho.dsclient.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.gezielcarvalho.dsclient.DTO.ClientDTO;
import info.gezielcarvalho.dsclient.entities.Client;
import info.gezielcarvalho.dsclient.repositories.ClientRepository;
import info.gezielcarvalho.dsclient.services.exceptions.ResourceNotFoundException;

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
								() -> new ResourceNotFoundException("Client not found"))
							);
	}

	@Transactional
	public ClientDTO insert(ClientDTO clientDto) {
		Client entity = new Client();
		entity.setName(clientDto.getName());
		entity.setIncome(clientDto.getIncome());
		entity.setCpf(clientDto.getCpf());
		entity.setChildren(clientDto.getChildren());
		entity.setBirthDate(clientDto.getBirthDate());
		return new ClientDTO(clientRepository.save(entity));
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO clientDto) {
		try {
			Client entity = clientRepository.getOne(id);
			entity.setName(clientDto.getName());
			entity.setIncome(clientDto.getIncome());
			entity.setCpf(clientDto.getCpf());
			entity.setChildren(clientDto.getChildren());
			entity.setBirthDate(clientDto.getBirthDate());
			return new ClientDTO(clientRepository.save(entity));
		}
		catch (EntityNotFoundException enfe) {
			throw new ResourceNotFoundException("Id not found: "+ id);
		}
	}

	public void delete(Long id) {
		try {
			clientRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException erdae) {
			throw new ResourceNotFoundException("Id not found: "+ id);
		}
	}
}
