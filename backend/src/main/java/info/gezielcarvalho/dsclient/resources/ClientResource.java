package info.gezielcarvalho.dsclient.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.gezielcarvalho.dsclient.DTO.ClientDTO;
import info.gezielcarvalho.dsclient.services.ClientService;



@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll(){
		return ResponseEntity.ok().body(clientService.findAll());
	}

}
