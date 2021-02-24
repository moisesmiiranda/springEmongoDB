package com.moisesmiiranda.projetomongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
