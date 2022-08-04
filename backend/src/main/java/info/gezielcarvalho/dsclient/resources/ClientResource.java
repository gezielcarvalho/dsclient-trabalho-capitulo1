package info.gezielcarvalho.dsclient.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.gezielcarvalho.dsclient.entities.Client;
import info.gezielcarvalho.dsclient.services.ClientService;



@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		 List<Client> list = clientService.findAll();
		 
//		 list.add(new Client(1L,"Joana","001",2234.56,Instant.parse("1972-11-30T00:30:29.10Z"),2));
//		 list.add(new Client(2L,"Maria","003",1334.56,Instant.parse("1982-05-15T00:25:14.01Z"),3));
//		 list.add(new Client(3L,"José","005",1235.56,Instant.parse("1986-07-10T00:31:26.02Z"),2));
//		 list.add(new Client(4L,"Marta","009",1234.76,Instant.parse("1945-09-01T00:34:34.20Z"),0));
//		 list.add(new Client(5L,"Marcos","007",1234.59,Instant.parse("1970-07-31T00:00:00.00Z"),1));
		 
		 
		return ResponseEntity.ok().body(list);
	}

}
