package com.moisesmiiranda.projetomongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.moisesmiiranda.projetomongo.domain.User;
import com.moisesmiiranda.projetomongo.dto.UserDTO;
import com.moisesmiiranda.projetomongo.services.UserService;


@RestController
@RequestMapping(value="/users")
public class UserResource {//controlador rest
	
	@Autowired
	private UserService service;//acessa o serviço

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findALL(){
		List<User> list	= service.findALL();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);	
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	//@RequestMapping(method=RequestMethod.POST)
	@PostMapping
 	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		//cabeçalho contendo o novo conteudo do obj criado
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();//retorna codigo 201
	}

}
